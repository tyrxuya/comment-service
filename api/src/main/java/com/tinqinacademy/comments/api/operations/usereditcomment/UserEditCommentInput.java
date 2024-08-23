package com.tinqinacademy.comments.api.operations.usereditcomment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.comments.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserEditCommentInput implements OperationInput {
    @JsonIgnore
    @UUID(message = "commentId must be a valid UUID")
    private String commentId;

    @NotBlank(message = "content cannot be blank!")
    @Size(min = 1, max = 200, message = "content cannot be over 200 symbols!")
    private String content;

    @NotBlank(message = "userId cannot be blank")
    @UUID(message = "userId must be a valid UUID")
    private String userId;
}
