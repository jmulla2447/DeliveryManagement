package com.delivery.mulla.delivery.service;

import com.delivery.mulla.delivery.dto.Coordinates;
import com.delivery.mulla.delivery.dto.OrderDto;

public interface DeliveryServiceInterface {
    OrderDto createOrder(Coordinates customerLatitude, Coordinates restaurantLatitude);
}
