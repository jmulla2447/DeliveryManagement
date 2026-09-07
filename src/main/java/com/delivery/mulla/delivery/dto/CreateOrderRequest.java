package com.delivery.mulla.delivery.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * CreateOrderRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-09-06T17:31:20.304656+01:00[Europe/London]", comments = "Generator version: 7.4.0")
public class CreateOrderRequest {

    private Double restaurantLatitude;

    private Double restaurantLongitude;

    private Double customerLatitude;

    private Double customerLongitude;

    public CreateOrderRequest() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public CreateOrderRequest(Double restaurantLatitude, Double restaurantLongitude, Double customerLatitude, Double customerLongitude) {
        this.restaurantLatitude = restaurantLatitude;
        this.restaurantLongitude = restaurantLongitude;
        this.customerLatitude = customerLatitude;
        this.customerLongitude = customerLongitude;
    }

    public CreateOrderRequest restaurantLatitude(Double restaurantLatitude) {
        this.restaurantLatitude = restaurantLatitude;
        return this;
    }

    /**
     * Get restaurantLatitude
     *
     * @return restaurantLatitude
     */
    @Schema(name = "restaurantLatitude", example = "12.9716", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("restaurantLatitude")
    public Double getRestaurantLatitude() {
        return restaurantLatitude;
    }

    public void setRestaurantLatitude(Double restaurantLatitude) {
        this.restaurantLatitude = restaurantLatitude;
    }

    public CreateOrderRequest restaurantLongitude(Double restaurantLongitude) {
        this.restaurantLongitude = restaurantLongitude;
        return this;
    }

    /**
     * Get restaurantLongitude
     *
     * @return restaurantLongitude
     */
    @Schema(name = "restaurantLongitude", example = "77.5946", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("restaurantLongitude")
    public Double getRestaurantLongitude() {
        return restaurantLongitude;
    }

    public void setRestaurantLongitude(Double restaurantLongitude) {
        this.restaurantLongitude = restaurantLongitude;
    }

    public CreateOrderRequest customerLatitude(Double customerLatitude) {
        this.customerLatitude = customerLatitude;
        return this;
    }

    /**
     * Get customerLatitude
     *
     * @return customerLatitude
     */
    @Schema(name = "customerLatitude", example = "12.98", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("customerLatitude")
    public Double getCustomerLatitude() {
        return customerLatitude;
    }

    public void setCustomerLatitude(Double customerLatitude) {
        this.customerLatitude = customerLatitude;
    }

    public CreateOrderRequest customerLongitude(Double customerLongitude) {
        this.customerLongitude = customerLongitude;
        return this;
    }

    /**
     * Get customerLongitude
     *
     * @return customerLongitude
     */
    @Schema(name = "customerLongitude", example = "77.6", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("customerLongitude")
    public Double getCustomerLongitude() {
        return customerLongitude;
    }

    public void setCustomerLongitude(Double customerLongitude) {
        this.customerLongitude = customerLongitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateOrderRequest createOrderRequest = (CreateOrderRequest) o;
        return Objects.equals(this.restaurantLatitude, createOrderRequest.restaurantLatitude) &&
                Objects.equals(this.restaurantLongitude, createOrderRequest.restaurantLongitude) &&
                Objects.equals(this.customerLatitude, createOrderRequest.customerLatitude) &&
                Objects.equals(this.customerLongitude, createOrderRequest.customerLongitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantLatitude, restaurantLongitude, customerLatitude, customerLongitude);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateOrderRequest {\n");
        sb.append("    restaurantLatitude: ").append(toIndentedString(restaurantLatitude)).append("\n");
        sb.append("    restaurantLongitude: ").append(toIndentedString(restaurantLongitude)).append("\n");
        sb.append("    customerLatitude: ").append(toIndentedString(customerLatitude)).append("\n");
        sb.append("    customerLongitude: ").append(toIndentedString(customerLongitude)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
