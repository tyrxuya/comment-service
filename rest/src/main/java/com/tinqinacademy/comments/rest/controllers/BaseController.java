package com.tinqinacademy.comments.rest.controllers;

import com.tinqinacademy.comments.api.base.OperationOutput;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    public ResponseEntity<?> getOutput(Either<ErrorsList, ? extends OperationOutput> result, HttpStatus status) {
        return result.fold(
                errorOutput -> new ResponseEntity<>(errorOutput, errorOutput.getStatus()),
                output -> new ResponseEntity<>(output, status)
        );
    }
}
