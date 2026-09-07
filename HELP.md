# 🚚 Helper Guide: Delivery Route & Driver Assignment API

## Overview
You are building a backend REST service for a food delivery platform. When a customer places a new order, the system must automatically analyze all nearby drivers and assign the best available driver based on spatial location, availability status, and workload metrics.

---

## 1. Domain Entities

### Driver
* `id` (Unique Identifier)
* `name` (String)
* `latitude` (Double - Current geolocation)
* `longitude` (Double - Current geolocation)
* `available` (Boolean - True if ready for new orders)
* `completedDeliveries` (Integer - Total past orders delivered)

### Order
* `id` (Unique Identifier)
* `restaurantLatitude` (Double - Pickup location)
* `restaurantLongitude` (Double - Pickup location)
* `customerLatitude` (Double - Dropoff location)
* `customerLongitude` (Double - Dropoff location)
* `status` (Enum - e.g., `UNASSIGNED`, `ASSIGNED`, `DELIVERED`)
* `assignedDriver` (Reference to assigned Driver, optional)

---

## 2. API Requirements

### Order Creation Endpoint
`POST /orders`

**Payload:** Accepts pickup (`restaurantLatitude`, `restaurantLongitude`) and dropoff (`customerLatitude`, `customerLongitude`) coordinates.  
**Action:** Triggers the driver selection algorithm upon order placement.  
**Response:** Returns the created Order payload including its `status` and `assignedDriver` details (if matched).

---

## 3. Assignment Rules & Constraints

When a new order arrives, the system must pick a single best driver by applying the following rules in order:

1. **Availability Filter:**
    * The candidate driver must currently have `available == true`.
2. **Maximum Distance Cutoff:**
    * The candidate driver must be located **$\le 10.0$ kilometers** from the restaurant (`restaurantLatitude`, `restaurantLongitude`).
3. **Primary Preference (Distance):**
    * Prefer the driver with the shortest straight-line (Haversine) distance to the restaurant.
4. **Secondary Preference (500-Meter Fairness Window):**
    * If two eligible drivers are within **$500$ meters ($0.5$ km)** distance of each other relative to the restaurant, break the tie by choosing the driver who has **fewer `completedDeliveries`**.
5. **State Updates & Fallback:**
    * **If a match is found:** Set the driver's `available` status to `false`, assign the driver to the order, and mark the order status as `ASSIGNED`.
    * **If no eligible drivers exist:** Leave the order `assignedDriver` as `null` and mark the order status as `UNASSIGNED`.

---

## 4. Key Edge Cases & Engineering Challenges

* **Concurrent Order Creation:** Multiple orders submitted simultaneously must not result in the same driver being assigned twice (race conditions).
* **Distance Precision:** Distances must be calculated using spherical geometry (Haversine Formula) rather than Euclidean distances.
* **Exact Threshold Ties:** If two drivers have the exact same distance *and* the exact same number of completed deliveries, secondary determinism (e.g., sorting by `id`) must be maintained.
This document serves as an architectural, algorithmic, and implementation reference for building the Driver Assignment System.

---

## 1. Domain Entities & Database Schema

### Entity Schema (SQL)

```sql
CREATE TABLE drivers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE,
    completed_deliveries INT NOT NULL DEFAULT 0,
    version BIGINT NOT NULL DEFAULT 0 -- For Optimistic Locking
);

CREATE TABLE orders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    restaurant_latitude DOUBLE PRECISION NOT NULL,
    restaurant_longitude DOUBLE PRECISION NOT NULL,
    customer_latitude DOUBLE PRECISION NOT NULL,
    customer_longitude DOUBLE PRECISION NOT NULL,
    status VARCHAR(50) NOT NULL, -- PENDING, ASSIGNED, COMPLETED, CANCELLED
    driver_id BIGINT,
    CONSTRAINT fk_orders_driver FOREIGN KEY (driver_id) REFERENCES drivers(id)
);
