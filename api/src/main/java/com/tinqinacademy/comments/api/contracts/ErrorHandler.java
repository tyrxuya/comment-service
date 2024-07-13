package com.tinqinacademy.comments.api.contracts;

import com.tinqinacademy.comments.api.errors.ErrorsList;
import org.springframework.validation.BindException;

public interface ErrorHandler {
    ErrorsList handle(BindException ex);
}
