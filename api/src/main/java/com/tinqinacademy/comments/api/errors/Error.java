package com.tinqinacademy.comments.api.errors;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Error {
    private String message;
    private String errorCode;
    private String field;
}
