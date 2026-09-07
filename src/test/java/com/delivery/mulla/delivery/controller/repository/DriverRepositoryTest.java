package com.delivery.mulla.delivery.controller.repository;

import com.delivery.mulla.delivery.controller.entity.DriverEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DriverRepositoryTest {

    @Autowired
    DriverRepository repository;
    @Test
    void DeriverRepository_findById_ok() {
        saveDriver result = saveDriver();

        DriverEntity actualDriver = repository.findById(new BigInteger(String.valueOf(result.newDrivier().getId()))).get();


        assertNotNull(actualDriver);
        assertEquals(result.drivier().toString(), actualDriver.toString());
    }

    private saveDriver saveDriver() {
        DriverEntity drivier =  DriverEntity.builder()
                .available(true).name("jason").completedDeliveries(5)
                .latitude(1.55).longitude(1.99).build();

        DriverEntity newDrivier  = repository.save(drivier);
        saveDriver result = new saveDriver(drivier, newDrivier);
        return result;
    }

    private record saveDriver(DriverEntity drivier, DriverEntity newDrivier) {
    }


    @Test
    void DeriverRepository_findById_null(){
        Optional<DriverEntity> actualDriver = repository.findById(new BigInteger(String.valueOf(21)));

        assertFalse(actualDriver.isPresent());
    }

    @Test
    void DeriverRepository_findByAvailable_list(){
        saveDriver result = saveDriver();
        saveDriver result1 = saveDriver();
       List<DriverEntity> listDriver = repository.findByAvailable(true);

       assertNotNull(listDriver);
       assertTrue(listDriver.size() > 1);
    }
}
