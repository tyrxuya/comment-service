package com.tinqinacademy.comments.core.converters;

import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentOutput;
import com.tinqinacademy.comments.persistence.entities.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentToDeleteCommentOutput extends AbstractConverter<Comment, DeleteCommentOutput> {
    @Override
    protected Class<DeleteCommentOutput> getTargetClass() {
        return DeleteCommentOutput.class;
    }

    @Override
    protected DeleteCommentOutput doConvert(Comment source) {
        DeleteCommentOutput result = DeleteCommentOutput.builder()
                .comment(source.getComment())
                .userId(source.getUserId().toString())
                .roomId(source.getRoomId().toString())
                .publishedDate(source.getPublishedDate())
                .lastEditTime(source.getLastEditTime())
                .editedByUserId(String.valueOf(source.getUserId()))
                .build();

        return result;
    }
}
