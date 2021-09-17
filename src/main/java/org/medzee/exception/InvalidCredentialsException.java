package org.medzee.exception;

import org.medzee.exception.model.BaseRuntimeException;

import java.util.Map;

public class InvalidCredentialsException extends BaseRuntimeException {

    public InvalidCredentialsException(String name, String message, Map<String, String> additionalData) {
        super(name, message, additionalData);
    }

    public InvalidCredentialsException(){
        super("INVALID_CREDENTIALS", "Invalid Credentials", Map.of());
    }
}
