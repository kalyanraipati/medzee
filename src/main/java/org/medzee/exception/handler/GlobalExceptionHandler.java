package org.medzee.exception.handler;


import lombok.extern.slf4j.Slf4j;
import org.medzee.exception.NotFoundException;
import org.medzee.exception.UserAlreadyExistsException;
import org.medzee.exception.model.BaseRuntimeException;
import org.medzee.exception.model.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorModel> handle(NotFoundException eidNotFound){
        ErrorModel model=new ErrorModel(eidNotFound.getMessage());
        model.setErrorCode("NOT_FOUND");
        model.setStatus(404);
        return ResponseEntity.status(404).body(model);
    }

    @ExceptionHandler(BaseRuntimeException.class)
    public ResponseEntity<ErrorModel> handle(BaseRuntimeException baseRuntimeException){
        ErrorModel model=new ErrorModel(baseRuntimeException.getMessage());
        model.setErrorCode(baseRuntimeException.getName());
        model.setStatus(400);
        return ResponseEntity.status(400).body(model);
    }
}
