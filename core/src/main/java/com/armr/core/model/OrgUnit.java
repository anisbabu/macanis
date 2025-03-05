package com.armr.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class OrgUnit extends Base {
    @ManyToOne
    private OrgUnit orgUnit;
    private String code;

    @ManyToOne
    private MetaData orgUnitKey;

    @Enumerated(EnumType.STRING)
    private OrgType orgType;
}