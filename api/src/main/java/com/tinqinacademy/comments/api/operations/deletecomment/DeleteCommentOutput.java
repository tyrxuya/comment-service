package com.tinqinacademy.comments.api.operations.deletecomment;

import com.tinqinacademy.comments.api.base.OperationOutput;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class DeleteCommentOutput implements OperationOutput {
    private String comment;
    private String userId;
    private String roomId;
    private LocalDateTime publishedDate;
    private LocalDateTime lastEditTime;
    private String editedByUserId;
}
