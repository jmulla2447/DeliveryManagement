package com.delivery.mulla.delivery.controller;


import com.delivery.mulla.delivery.dto.CreateOrderRequest;
import com.delivery.mulla.delivery.dto.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.processing.Generated;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-09-06T17:31:20.304656+01:00[Europe/London]", comments = "Generator version: 7.4.0")
@Validated
public interface DeliveryApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /orders : Create a new order and assign a driver
     *
     * @param createOrderRequest (required)
     * @return Order created successfully (status code 201)
     */
    @Operation(
            operationId = "createOrder",
            summary = "Create a new order and assign a driver",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Order created successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/orders",
            produces = {"application/json"},
            consumes = {"application/json"}
    )

    default ResponseEntity<OrderResponse> createOrder(
            @Parameter(name = "CreateOrderRequest", description = "", required = true) @Valid @RequestBody CreateOrderRequest createOrderRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"restaurantLatitude\" : 6.027456183070403, \"customerLatitude\" : 5.962133916683182, \"id\" : 0, \"assignedDriver\" : { \"latitude\" : 7.061401241503109, \"name\" : \"name\", \"available\" : true, \"id\" : 2, \"longitude\" : 9.301444243932576 }, \"restaurantLongitude\" : 1.4658129805029452, \"customerLongitude\" : 5.637376656633329, \"status\" : \"ASSIGNED\" }";
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
