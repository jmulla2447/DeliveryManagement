package com.delivery.mulla.delivery.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * OrderResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-09-06T17:31:20.304656+01:00[Europe/London]", comments = "Generator version: 7.4.0")
public class OrderResponse {

    private Long id;

    private Double restaurantLatitude;

    private Double restaurantLongitude;

    private Double customerLatitude;

    private Double customerLongitude;

    private String status;

    private DriverResponse assignedDriver;


    public OrderResponse id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */

    @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderResponse restaurantLatitude(Double restaurantLatitude) {
        this.restaurantLatitude = restaurantLatitude;
        return this;
    }

    /**
     * Get restaurantLatitude
     *
     * @return restaurantLatitude
     */

    @Schema(name = "restaurantLatitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("restaurantLatitude")
    public Double getRestaurantLatitude() {
        return restaurantLatitude;
    }

    public void setRestaurantLatitude(Double restaurantLatitude) {
        this.restaurantLatitude = restaurantLatitude;
    }

    public OrderResponse restaurantLongitude(Double restaurantLongitude) {
        this.restaurantLongitude = restaurantLongitude;
        return this;
    }

    /**
     * Get restaurantLongitude
     *
     * @return restaurantLongitude
     */

    @Schema(name = "restaurantLongitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("restaurantLongitude")
    public Double getRestaurantLongitude() {
        return restaurantLongitude;
    }

    public void setRestaurantLongitude(Double restaurantLongitude) {
        this.restaurantLongitude = restaurantLongitude;
    }

    public OrderResponse customerLatitude(Double customerLatitude) {
        this.customerLatitude = customerLatitude;
        return this;
    }

    /**
     * Get customerLatitude
     *
     * @return customerLatitude
     */

    @Schema(name = "customerLatitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("customerLatitude")
    public Double getCustomerLatitude() {
        return customerLatitude;
    }

    public void setCustomerLatitude(Double customerLatitude) {
        this.customerLatitude = customerLatitude;
    }

    public OrderResponse customerLongitude(Double customerLongitude) {
        this.customerLongitude = customerLongitude;
        return this;
    }

    /**
     * Get customerLongitude
     *
     * @return customerLongitude
     */

    @Schema(name = "customerLongitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("customerLongitude")
    public Double getCustomerLongitude() {
        return customerLongitude;
    }

    public void setCustomerLongitude(Double customerLongitude) {
        this.customerLongitude = customerLongitude;
    }

    public OrderResponse status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */

    @Schema(name = "status", example = "ASSIGNED", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderResponse assignedDriver(DriverResponse assignedDriver) {
        this.assignedDriver = assignedDriver;
        return this;
    }

    /**
     * Get assignedDriver
     *
     * @return assignedDriver
     */
    @Valid
    @Schema(name = "assignedDriver", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("assignedDriver")
    public DriverResponse getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(DriverResponse assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderResponse orderResponse = (OrderResponse) o;
        return Objects.equals(this.id, orderResponse.id) &&
                Objects.equals(this.restaurantLatitude, orderResponse.restaurantLatitude) &&
                Objects.equals(this.restaurantLongitude, orderResponse.restaurantLongitude) &&
                Objects.equals(this.customerLatitude, orderResponse.customerLatitude) &&
                Objects.equals(this.customerLongitude, orderResponse.customerLongitude) &&
                Objects.equals(this.status, orderResponse.status) &&
                Objects.equals(this.assignedDriver, orderResponse.assignedDriver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, restaurantLatitude, restaurantLongitude, customerLatitude, customerLongitude, status, assignedDriver);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OrderResponse {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    restaurantLatitude: ").append(toIndentedString(restaurantLatitude)).append("\n");
        sb.append("    restaurantLongitude: ").append(toIndentedString(restaurantLongitude)).append("\n");
        sb.append("    customerLatitude: ").append(toIndentedString(customerLatitude)).append("\n");
        sb.append("    customerLongitude: ").append(toIndentedString(customerLongitude)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    assignedDriver: ").append(toIndentedString(assignedDriver)).append("\n");
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
