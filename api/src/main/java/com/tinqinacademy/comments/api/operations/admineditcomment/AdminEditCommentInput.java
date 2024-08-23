package com.tinqinacademy.comments.api.operations.admineditcomment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.comments.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminEditCommentInput implements OperationInput {
    @JsonIgnore
    @UUID(message = "commentId must be a valid UUID")
    private String commentId;

    @UUID(message = "roomId must be a valid UUID")
    private String roomId;

    @Schema(example = "vanio")
    @NotBlank(message = "firstName cannot be blank!")
    @Size(min = 2, max = 50, message = "firstName must be between 2 and 50 symbols!")
    private String firstName;

    @Schema(example = "georgiev")
    @NotBlank(message = "lastName cannot be blank!")
    @Size(min = 2, max = 50, message = "lastName must be between 2 and 50 symbols!")
    private String lastName;

    @Schema(example = "tazi staq e mn qka")
    @NotBlank(message = "content cannot be blank!")
    @Size(min = 1, max = 200, message = "content cannot be over 200 symbols!")
    private String content;

    @UUID(message = "userId must be a valid UUID")
    @NotBlank(message = "userId cannot be blank")
    private String userId;
}
