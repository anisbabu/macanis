package com.armr.core.model;

import jakarta.persistence.ManyToOne;

public class Position extends Base {
    @ManyToOne
    private OperatingUnit operationUnit;

    @ManyToOne
    private CompanyGroup orgUnit;

    @ManyToOne
    private CompanyGroup job;

    private String code;
    private String name;
    private String nameNative;
    private int minNoPosition;
    private int maxNoPosition;
}