package com.tinqinacademy.comments.api.operations.admineditcomment;

import com.tinqinacademy.comments.api.base.OperationOutput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminEditCommentOutput implements OperationOutput {
    private String commentId;
}
