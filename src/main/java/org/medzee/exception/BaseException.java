package org.medzee.exception;

import lombok.Data;

import java.util.Collections;
import java.util.Map;

public interface BaseException {
    String getName();
    String getMessage();
    Map<String,String> getAdditional();
}
