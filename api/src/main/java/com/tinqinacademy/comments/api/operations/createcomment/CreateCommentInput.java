package com.tinqinacademy.comments.api.operations.createcomment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.comments.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class CreateCommentInput implements OperationInput {
    @JsonIgnore
    private String roomId;

    @NotBlank(message = "firstName cannot be blank!")
    @Size(min = 2, max = 50, message = "firstName must be between 2 and 50 symbols!")
    private String firstName;

    @NotBlank(message = "lastName cannot be blank!")
    @Size(min = 2, max = 50, message = "lastName must be between 2 and 50 symbols!")
    private String lastName;

    @NotBlank(message = "content cannot be blank!")
    @Size(min = 1, max = 200, message = "content cannot be over 200 symbols!")
    private String content;
}
