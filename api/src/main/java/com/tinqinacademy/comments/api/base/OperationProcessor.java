package com.tinqinacademy.comments.api.base;

import com.tinqinacademy.comments.api.errors.ErrorsList;
import io.vavr.control.Either;

public interface OperationProcessor<S extends OperationInput, T extends OperationOutput> {
    Either<ErrorsList, T> process(S input);
}
