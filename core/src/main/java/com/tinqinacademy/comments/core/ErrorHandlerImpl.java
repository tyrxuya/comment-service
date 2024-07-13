package com.tinqinacademy.comments.core;

import com.tinqinacademy.comments.api.contracts.ErrorHandler;
import com.tinqinacademy.comments.api.errors.Error;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ErrorHandlerImpl implements ErrorHandler {

    @Override
    public ErrorsList handle(BindException ex) {
        List<Error> errors = new ArrayList<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.add(
                                Error.builder()
                                        .message(error.getDefaultMessage())
                                        .field(error.getField())
                                        .errorCode(error.getCode())
                                        .build()
                        )
                );

        ErrorsList errorsList = ErrorsList.builder()
                .errors(errors)
                .build();

        return errorsList;
    }
}
