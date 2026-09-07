package com.delivery.mulla.delivery.controller.repository;

import com.delivery.mulla.delivery.controller.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface OrderRepository extends JpaRepository<OrderEntity, BigInteger> {
}
