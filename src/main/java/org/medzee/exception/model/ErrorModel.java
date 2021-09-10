package org.medzee.exception.model;

import lombok.Data;

@Data
public class ErrorModel{

    private String errorCode;
    private String errorMessage;
    private String trace;
    private int status=500;

    public ErrorModel(String errorMessage) {
        this.errorMessage=errorMessage;
    }
    public ErrorModel(String errorCode,String errorMessage) {
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public ErrorModel(String errorCode,String errorMessage,int status) {
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
        this.status=status;
    }
    public ErrorModel(String errorCode,String errorMessage,int status,String trace) {
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
        this.status=status;
        this.trace=trace;
    }


}
