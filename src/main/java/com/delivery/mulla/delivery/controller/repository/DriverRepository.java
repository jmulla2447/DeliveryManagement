package com.delivery.mulla.delivery.controller.repository;

import com.delivery.mulla.delivery.controller.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface DriverRepository extends JpaRepository<DriverEntity, BigInteger> {

    List<DriverEntity> findByAvailable(boolean flag);
}
