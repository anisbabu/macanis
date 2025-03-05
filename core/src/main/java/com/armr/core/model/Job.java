package com.armr.core.model;

import jakarta.persistence.Entity;

@Entity
public class Job extends Base {
    private String code;
    private String name;
    private String nameNative;
}