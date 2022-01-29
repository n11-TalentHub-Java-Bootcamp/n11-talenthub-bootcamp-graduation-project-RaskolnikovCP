package com.ozansaribal.n11bootcamp.graduation_project.Enums;

public enum EnumCreditResultType {

    APPROVED("APPROVED"),
    DENIED("DENIED")
    ;

    private String type;

    EnumCreditResultType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

}
