package com.delivery.mulla.delivery.controller.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_latitude", nullable = false)
    private Double customerLatitude;
    @Column(name = "customer_longitude", nullable = false)
    private Double customerLongitude;
    @Column(name = "restaurant_latitude", nullable = false)
    private Double restaurantLatitude;
    @Column(name = "restaurant_longitude", nullable = false)
    private Double restaurantLongitude;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status; // e.g., "ASSIGNED", "CANCELLED", "UNASSIGNED"
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    // Many orders belong to one assigned driver (foreign key: driver_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private DriverEntity assignedDriver;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public enum Status {
        ASSIGNED, CANCELLED, UNASSIGNED
    }
}
