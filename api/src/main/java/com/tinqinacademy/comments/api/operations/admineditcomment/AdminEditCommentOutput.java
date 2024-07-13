package com.tinqinacademy.comments.api.operations.admineditcomment;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminEditCommentOutput {
    private String id;
}
