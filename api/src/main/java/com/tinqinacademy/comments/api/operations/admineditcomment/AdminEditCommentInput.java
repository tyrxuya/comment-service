package com.tinqinacademy.comments.api.operations.admineditcomment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminEditCommentInput {
    @Schema(example = "10021")
    @NotBlank(message = "commentId cannot be blank!")
    private String commentId;

    @Schema(example = "100b")
    @NotBlank(message = "roomNo cannot be blank!")
    private String roomNo;

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
}
