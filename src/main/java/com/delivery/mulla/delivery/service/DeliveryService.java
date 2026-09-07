package com.delivery.mulla.delivery.service;

import com.delivery.mulla.delivery.controller.entity.DriverEntity;
import com.delivery.mulla.delivery.controller.entity.OrderEntity;
import com.delivery.mulla.delivery.controller.repository.DriverRepository;
import com.delivery.mulla.delivery.controller.repository.OrderRepository;
import com.delivery.mulla.delivery.dto.Coordinates;
import com.delivery.mulla.delivery.dto.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService implements DeliveryServiceInterface {

    /*
    * Availability Filter:
    The candidate driver must currently have available == true.
    Maximum Distance Cutoff:
    The candidate driver must be located $\le 10.0$ kilometers from the restaurant (restaurantLatitude, restaurantLongitude).
    Primary Preference (Distance):
    Prefer the driver with the shortest straight-line (Haversine) distance to the restaurant.
    Secondary Preference (500-Meter Fairness Window):
    If two eligible drivers are within $500$ meters ($0.5$ km) distance of each other relative to the restaurant, break the tie by choosing the driver who has fewer completedDeliveries.
    State Updates & Fallback:
    If a match is found: Set the driver's available status to false, assign the driver to the order, and mark the order status as ASSIGNED.
    If no eligible drivers exist: Leave the order assignedDriver as null and mark the order status as UNASSIGNED.
    * */
    private static final double EARTH_RADIUS_KM = 6371.0;
    private static final double MAX_DISTANCE_KM = 10.0;
    private static final double FAIRNESS_WINDOW_KM = 0.5; // 500 meters
    private DriverRepository driverRepository;
    private OrderRepository orderRepository;

    public DeliveryService(DriverRepository driverRepository, OrderRepository orderRepository) {
        this.driverRepository = driverRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public OrderDto createOrder(Coordinates customerLocation, Coordinates restaurantLocation) {
        // 1. Initialize Order Entity
        OrderEntity order = new OrderEntity();
        order.setCustomerLatitude(customerLocation.getLatitude());
        order.setCustomerLongitude(customerLocation.getLongitude());
        order.setRestaurantLatitude(restaurantLocation.getLatitude());
        order.setRestaurantLongitude(restaurantLocation.getLongitude());
        order.setCreatedAt(LocalDateTime.now());

        // 2. Fetch available drivers and calculate distances to the restaurant
        List<DriverEntity> availableDrivers = driverRepository.findByAvailable(true);

        Optional<DriverEntity> selectedDriver = findEligibleDriver(
                availableDrivers,
                restaurantLocation.getLatitude(),
                restaurantLocation.getLongitude()
        );

        // 3. Assign or Fallback to UNASSIGNED
        if (selectedDriver.isPresent()) {
            DriverEntity driver = selectedDriver.get();
            driver.setAvailable(false);
            driverRepository.save(driver);

            order.setAssignedDriver(driver);
            order.setStatus(OrderEntity.Status.ASSIGNED);
        } else {
            order.setStatus(OrderEntity.Status.UNASSIGNED);
        }

        orderRepository.save(order);

        return new OrderDto(
                order.getRestaurantLatitude(),
                order.getRestaurantLongitude(),
                order.getCustomerLatitude(),
                order.getCustomerLongitude(),
                order.getStatus().toString()
        );
    }

    /**
     * Filters by max distance cutoff (<= 10km) and applies the 500-meter fairness tie-breaker.
     */
    private Optional<DriverEntity> findEligibleDriver(List<DriverEntity> drivers, double restLat, double restLon) {
        // Step A: Find drivers within the 10.0 km cutoff radius
        List<DriverDistancePair> eligibleDrivers = drivers.stream()
                .map(driver -> new DriverDistancePair(
                        driver,
                        calculateDistanceKm(driver.getLatitude(), driver.getLongitude(), restLat, restLon)
                ))
                .filter(pair -> pair.distanceKm <= MAX_DISTANCE_KM)
                .toList();

        if (eligibleDrivers.isEmpty()) {
            return Optional.empty();
        }

        // Step B: Determine the absolute closest driver's distance
        double minDistance = eligibleDrivers.stream()
                .mapToDouble(pair -> pair.distanceKm)
                .min()
                .orElse(Double.MAX_VALUE);

        // Step C: Filter drivers within the 500m (0.5km) fairness window of the closest driver,
        // then pick the one with fewer completed deliveries (breaking ties by distance)
        return eligibleDrivers.stream()
                .filter(pair -> (pair.distanceKm - minDistance) <= FAIRNESS_WINDOW_KM)
                .min(Comparator.comparingInt((DriverDistancePair pair) -> pair.driver.getCompletedDeliveries())
                        .thenComparingDouble(pair -> pair.distanceKm))
                .map(pair -> pair.driver);
    }

    private double calculateDistanceKm(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS_KM * c;
    }

    // Lightweight record wrapper for distance pairing
    private record DriverDistancePair(DriverEntity driver, double distanceKm) {
    }
}
