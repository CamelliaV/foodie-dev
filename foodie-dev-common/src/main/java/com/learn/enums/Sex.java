package com.learn.enums;

public enum Sex {
    WOMAN(0, "female"),
    MAN(1, "male"),
    SECRET(2, "secret");
    
    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
