package com.tinqinacademy.comments.core.converters;

import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentInput;
import com.tinqinacademy.comments.persistence.entities.Comment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCommentInputToComment extends AbstractConverter<CreateCommentInput, Comment> {
    @Override
    protected Class<Comment> getTargetClass() {
        return Comment.class;
    }

    @Override
    protected Comment doConvert(CreateCommentInput source) {
        Comment result = Comment.builder()
                .roomId(UUID.fromString(source.getRoomId()))
                .comment(source.getContent())
                .userId(UUID.fromString(source.getUserId()))
                .build();

        return result;
    }
}
