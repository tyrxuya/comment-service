package com.tinqinacademy.comments.api.errors;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
@Component
public class ErrorMapper {
    private final ErrorsList errorsList;

    public <T extends Throwable> ErrorsList map(T throwable, HttpStatus httpStatus) {
        log.info("Mapping throwable {} to ErrorsList", throwable.getClass().getName());

        errorsList.setErrors(List.of(Error.builder()
                .message(throwable.getMessage())
                .build()));

        errorsList.setStatus(httpStatus);

        log.info("Result: {}", errorsList);

        return errorsList;
    }

}
