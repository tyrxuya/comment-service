package com.tinqinacademy.comments.api.operations.usereditcomment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.comments.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserEditCommentInput implements OperationInput {
    @JsonIgnore
    private String commentId;

    @NotBlank(message = "content cannot be blank!")
    @Size(min = 1, max = 200, message = "content cannot be over 200 symbols!")
    private String content;
}
