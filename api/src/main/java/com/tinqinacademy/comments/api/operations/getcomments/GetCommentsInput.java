package com.tinqinacademy.comments.api.operations.getcomments;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GetCommentsInput {
    //@NotBlank(message = "roomId cannot be blank!")
    private String roomId;
}
