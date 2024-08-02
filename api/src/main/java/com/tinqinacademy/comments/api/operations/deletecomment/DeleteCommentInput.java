package com.tinqinacademy.comments.api.operations.deletecomment;

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
public class DeleteCommentInput implements OperationInput {
    @NotBlank(message = "roomId cannot be blank!")
    private String roomId;
}
