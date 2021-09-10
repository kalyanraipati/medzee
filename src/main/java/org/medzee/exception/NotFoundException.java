package org.medzee.exception;

import org.medzee.exception.model.BaseRuntimeException;

import java.util.Map;

public class NotFoundException extends BaseRuntimeException {

    public NotFoundException(String name, String message, Map<String, String> additionalData) {
        super(name, message, additionalData);
    }
    public NotFoundException(String name,String message) {
        this(name, message, Map.of());
    }

    public NotFoundException(String name) {
        this(name, name + " not found", Map.of());
    }
}
