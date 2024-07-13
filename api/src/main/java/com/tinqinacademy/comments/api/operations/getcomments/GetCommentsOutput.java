package com.tinqinacademy.comments.api.operations.getcomments;

import com.tinqinacademy.comments.api.operations.comments.CommentsOutput;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GetCommentsOutput {
    //@Valid
    private List<CommentsOutput> comments;
}
