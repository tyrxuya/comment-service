package com.tinqinacademy.comments.api.operations.deletecomment;

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
public class DeleteCommentInput implements OperationInput {
    @JsonIgnore
    @UUID(message = "commentId must be a valid UUID")
    private String commentId;
}
