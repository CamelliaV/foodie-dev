package com.learn.enums;

public enum CarouselState {
    YES(1),
    NO(0);

    public final Integer value;

    CarouselState(Integer value) {
        this.value = value;
    }
}
