package com.tinqinacademy.comments.core.converters;

import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentInput;
import com.tinqinacademy.comments.persistence.entities.Comment;

import java.util.UUID;

public class CreateCommentInputToComment extends AbstractConverter<CreateCommentInput, Comment> {
    @Override
    protected Class<Comment> getTargetClass() {
        return Comment.class;
    }

    @Override
    protected Comment doConvert(CreateCommentInput source) {
        Comment result = Comment.builder()
                .roomId(source.getRoomId())
                .comment(source.getContent())
                .editedByUserId(UUID.randomUUID()) //will be changed later
                .build();

        return result;
    }
}
