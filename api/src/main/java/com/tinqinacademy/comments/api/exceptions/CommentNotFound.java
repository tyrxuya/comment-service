package com.tinqinacademy.comments.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentNotFound extends RuntimeException {
    private final String message = ExceptionMessages.COMMENT_NOT_FOUND;
}
