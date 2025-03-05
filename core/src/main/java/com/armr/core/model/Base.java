package com.armr.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Data
@MappedSuperclass
public abstract class Base {
    @Id
    @GeneratedValue
    private String id;

    private String clientId;

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