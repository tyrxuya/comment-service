package com.tinqinacademy.comments.api.operations.usereditcomment;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserEditCommentOutput {
    //@NotBlank(message = "id cannot be blank!")
    private String id;
}
