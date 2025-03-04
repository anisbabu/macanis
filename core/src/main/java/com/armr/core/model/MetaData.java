package com.armr.core.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class MetaData extends Base {
    private String code;
    private String name;
    private String nameNative;
    private String description;

    @Enumerated(EnumType.STRING)
    private MetaKey metaKey;
}