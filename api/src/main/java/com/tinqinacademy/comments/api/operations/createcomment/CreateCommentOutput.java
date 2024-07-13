package com.tinqinacademy.comments.api.operations.createcomment;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateCommentOutput {
    //@NotBlank(message = "id cannot be blank!")
    private String id;
}
