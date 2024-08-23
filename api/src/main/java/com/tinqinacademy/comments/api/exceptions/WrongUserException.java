package com.tinqinacademy.comments.api.exceptions;

import com.tinqinacademy.comments.api.ExceptionMessages;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WrongUserException extends RuntimeException {
    private final String message = ExceptionMessages.WRONG_USER;
}
