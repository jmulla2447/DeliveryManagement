package com.delivery.mulla.delivery.controller.mapper;

import com.delivery.mulla.delivery.dto.Coordinates;
import com.delivery.mulla.delivery.dto.CreateOrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    @Mapping(source = "customerLatitude", target = "latitude")
    @Mapping(source = "customerLongitude", target = "longitude")
    Coordinates toCustomerDto(CreateOrderRequest request);

    @Mapping(source = "restaurantLatitude", target = "latitude")
    @Mapping(source = "restaurantLongitude", target = "longitude")
    Coordinates toRestaurantDto(CreateOrderRequest request);
}
