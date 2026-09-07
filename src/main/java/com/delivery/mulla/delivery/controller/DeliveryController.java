package com.delivery.mulla.delivery.controller;

import com.delivery.mulla.delivery.controller.mapper.RequestMapper;
import com.delivery.mulla.delivery.dto.CreateOrderRequest;
import com.delivery.mulla.delivery.dto.OrderDto;
import com.delivery.mulla.delivery.dto.OrderResponse;
import com.delivery.mulla.delivery.service.DeliveryServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class DeliveryController implements DeliveryApi {
    private DeliveryServiceInterface serviceInterface;
    private RequestMapper mapper;

    public DeliveryController(DeliveryServiceInterface serviceInterface, RequestMapper mapper) {
        this.serviceInterface = serviceInterface;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<OrderResponse> createOrder(CreateOrderRequest createOrderRequest) {
        OrderDto dto = serviceInterface.createOrder(mapper.toCustomerDto(createOrderRequest), mapper.toRestaurantDto(createOrderRequest));
        return ResponseEntity.ok(new OrderResponse().customerLatitude(dto.getCustomerLatitude()).
                customerLongitude(dto.getCustomerLongitude()).customerLongitude(dto.getCustomerLongitude()).customerLatitude(dto.getCustomerLongitude()));
    }
}
