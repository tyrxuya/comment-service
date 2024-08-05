package com.tinqinacademy.comments.core.operations;

import com.tinqinacademy.comments.api.base.OperationInput;
import com.tinqinacademy.comments.api.errors.Error;
import com.tinqinacademy.comments.api.errors.ErrorMapper;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import com.tinqinacademy.comments.api.exceptions.InvalidInputException;
import com.tinqinacademy.comments.persistence.repositories.CommentRepository;
import io.vavr.API;
import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import jakarta.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.vavr.API.$;
import static io.vavr.Predicates.instanceOf;

@RequiredArgsConstructor
@Getter
@Setter
public abstract class BaseOperation {
    protected final Validator validator;
    protected final ConversionService conversionService;
    protected final ErrorMapper errorMapper;

    public <T extends OperationInput> void validate(T input) {
        Set<ConstraintViolation<OperationInput>> violations = validator.validate(input);

        if (!violations.isEmpty()) {
            List<Error> errors = new ArrayList<>();

            violations.forEach(violation ->
                    errors.add(Error.builder()
                            .message(violation.getMessage())
                            .field(violation.getPropertyPath().toString())
                            .build())
            );

            throw new InvalidInputException(errors);
        }
    }

    protected API.Match.Case<? extends Exception, ErrorsList> customCase(Throwable cause,
                                                                         HttpStatus status,
                                                                         Class<? extends Exception> exceptionClass) {
        return API.Case($(instanceOf(exceptionClass)), errorMapper.map(cause, status));
    }

    protected API.Match.Case<? extends Exception, ErrorsList> defaultCase(Throwable cause,
                                                                           HttpStatus status) {
        return API.Case($(), errorMapper.map(cause, status));
    }

    protected API.Match.Case<InvalidInputException, ErrorsList> validateCase(Throwable cause,
                                                                              HttpStatus status) {
        List<Error> errors = cause instanceof InvalidInputException ex ? ex.getErrors() : new ArrayList<>();

        return API.Case($(instanceOf(InvalidInputException.class)), () -> ErrorsList.builder()
                .errors(errors)
                .status(status)
                .build());
    }
}
