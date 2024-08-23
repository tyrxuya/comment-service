package com.tinqinacademy.comments.core.converters;

import com.tinqinacademy.comments.api.operations.comments.CommentsOutput;
import com.tinqinacademy.comments.persistence.entities.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentOutput extends AbstractConverter<Comment, CommentsOutput> {
    @Override
    protected Class<CommentsOutput> getTargetClass() {
        return CommentsOutput.class;
    }

    @Override
    protected CommentsOutput doConvert(Comment source) {
        CommentsOutput result = CommentsOutput.builder()
                .commentId(source.getId().toString())
                .content(source.getComment())
                .publishDate(source.getPublishedDate().toLocalDate())
                .lastEditedDate(source.getLastEditTime().toLocalDate())
                .lastEditedBy(String.valueOf(source.getLastEditedBy()))
                .userId(source.getUserId().toString())
                .build();

        return result;
    }
}
