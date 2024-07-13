package com.tinqinacademy.comments.api.errors;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Component
public class ErrorsList {
    private List<Error> errors;
}
