package com.tinqinacademy.comments.api.operations.getcomments;

import com.tinqinacademy.comments.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GetCommentsInput implements OperationInput {
    //@NotBlank(message = "roomId cannot be blank!")
    @UUID(message = "roomId must be a valid UUID")
    private String roomId;
}
