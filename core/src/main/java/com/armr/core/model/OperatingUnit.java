package com.armr.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
//@Table(name = "COMPANY")
public class OperatingUnit extends Base {
    @ManyToOne
    private Company company;
    private String code;
    private String name;
    private String nameNative;

    @Enumerated(EnumType.STRING)
    private OperatingUnitType operatingUnitType;
}