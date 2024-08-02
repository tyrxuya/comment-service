package com.tinqinacademy.comments.api.operations.createcomment;

import com.tinqinacademy.comments.api.base.OperationOutput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateCommentOutput implements OperationOutput {
    //@NotBlank(message = "id cannot be blank!")
    private String id;
}
