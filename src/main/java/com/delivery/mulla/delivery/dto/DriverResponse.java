package com.delivery.mulla.delivery.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * DriverResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-09-06T17:31:20.304656+01:00[Europe/London]", comments = "Generator version: 7.4.0")
public class DriverResponse {

    private Long id;

    private String name;

    private Double latitude;

    private Double longitude;

    private Boolean available;

    public DriverResponse id(Long id) {
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

    public DriverResponse name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */

    @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DriverResponse latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Get latitude
     *
     * @return latitude
     */

    @Schema(name = "latitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public DriverResponse longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * Get longitude
     *
     * @return longitude
     */

    @Schema(name = "longitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public DriverResponse available(Boolean available) {
        this.available = available;
        return this;
    }

    /**
     * Get available
     *
     * @return available
     */

    @Schema(name = "available", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("available")
    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DriverResponse driverResponse = (DriverResponse) o;
        return Objects.equals(this.id, driverResponse.id) &&
                Objects.equals(this.name, driverResponse.name) &&
                Objects.equals(this.latitude, driverResponse.latitude) &&
                Objects.equals(this.longitude, driverResponse.longitude) &&
                Objects.equals(this.available, driverResponse.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude, available);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DriverResponse {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
        sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
        sb.append("    available: ").append(toIndentedString(available)).append("\n");
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
