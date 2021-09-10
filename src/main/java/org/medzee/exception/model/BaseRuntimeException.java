package org.medzee.exception.model;

import lombok.Data;
import org.medzee.exception.BaseException;

import java.util.Map;
@Data
public class BaseRuntimeException extends RuntimeException implements BaseException {

    private String name;
    private String message;
    private Map<String,String> additionalData;
   public BaseRuntimeException(String name,String message,Map<String,String> additionalData){
        super(message);
        this.name=name;
        this.message=message;
        this.additionalData=additionalData;
    }

    @Override
    public Map<String, String> getAdditional() {
        return additionalData;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
