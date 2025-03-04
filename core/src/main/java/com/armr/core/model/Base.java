package com.armr.core.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class Base {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID clientId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private boolean isDeleted = false;

    @UpdateTimestamp
    private LocalDateTime deletedAt;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private boolean isActive = true;
}