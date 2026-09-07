package com.delivery.mulla.delivery.controller.repository;

import com.delivery.mulla.delivery.controller.entity.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;

    @Test
    void orderRepository_save_ok(){

        OrderEntity order = OrderEntity.builder().createdAt(LocalDateTime.now())
                .status(OrderEntity.Status.ASSIGNED).customerLatitude(1.44)
                .customerLongitude(1.66)
                .restaurantLatitude(3.99).restaurantLongitude(2.77).build();

        OrderEntity savedOrder = repository.save(order);

        assertNotNull(savedOrder);
        assertEquals(order.getCustomerLatitude(), savedOrder.getCustomerLatitude());
    }
}
