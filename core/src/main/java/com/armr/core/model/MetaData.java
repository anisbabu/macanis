package com.armr.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class MetaData extends Base {
    private String code;
    private String name;
    private String nameNative;
    private String description;

    @Enumerated(EnumType.STRING)
    private MetaKey metaKey;
}