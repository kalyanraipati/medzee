package org.medzee.exception;

import org.medzee.exception.model.BaseRuntimeException;

import java.util.Map;

public class UserAlreadyExistsException extends BaseRuntimeException {

    public UserAlreadyExistsException(String name, String message, Map<String, String> additionalData) {
        super(name, message, additionalData);
    }

    public UserAlreadyExistsException(){
        super("USER_EXISTS", "User already exists, please proceed with Login", Map.of());
    }
}
