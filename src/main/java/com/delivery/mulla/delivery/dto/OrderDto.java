package com.delivery.mulla.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDto {

    private Double restaurantLatitude;

    private Double restaurantLongitude;

    private Double customerLatitude;

    private Double customerLongitude;

    private String status;
}
