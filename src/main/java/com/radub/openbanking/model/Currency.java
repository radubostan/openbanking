package com.radub.openbanking.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Currency {
    CAD("CAD"),
	USD("USD");

    @JsonValue
    private String value;

    private Currency(String value) {
        this.value = value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Currency fromString(String value) {
        for (Currency b : Currency.values()) {
            if (b.value.equalsIgnoreCase(value)) {
                return b;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
