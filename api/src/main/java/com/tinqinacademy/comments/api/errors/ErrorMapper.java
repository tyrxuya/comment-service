package com.tinqinacademy.comments.api.errors;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Component
public class ErrorMapper {
    private final ErrorsList errorsList;

    public <T extends Throwable> ErrorsList map(T throwable, HttpStatus httpStatus) {
        errorsList.setErrors(List.of(Error.builder()
                .message(throwable.getMessage())
                .build()));

        errorsList.setStatus(httpStatus);

        return errorsList;
    }

}
