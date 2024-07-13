package com.tinqinacademy.comments.api.operations.usereditcomment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserEditCommentInput {
    @NotBlank(message = "content cannot be blank!")
    @Size(max = 200, message = "content cannot be over 200 symbols!")
    private String content;
}
