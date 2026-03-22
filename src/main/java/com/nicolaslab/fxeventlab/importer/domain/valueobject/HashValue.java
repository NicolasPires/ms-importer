package com.nicolaslab.fxeventlab.importer.domain.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
@EqualsAndHashCode
public class HashValue {

    private final String value;

    public HashValue(String value) {
        if (value == null || value.length() < 10) {
            throw new IllegalArgumentException("Hash Invalido");
        }
        this.value = value;
    }
}
