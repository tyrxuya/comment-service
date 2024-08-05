package com.tinqinacademy.comments.core.converters;

import com.tinqinacademy.comments.api.operations.comments.CommentsOutput;
import com.tinqinacademy.comments.persistence.entities.Comment;

public class CommentToCommentOutput extends AbstractConverter<Comment, CommentsOutput> {
    @Override
    protected Class<CommentsOutput> getTargetClass() {
        return CommentsOutput.class;
    }

    @Override
    protected CommentsOutput doConvert(Comment source) {
        CommentsOutput result = CommentsOutput.builder()
                .id(source.getId().toString())
                .content(source.getComment())
                .publishDate(source.getPublishedDate().toLocalDate())
                .lastEditedBy(source.getEditedByUserId().toString())
                .build();

        return result;
    }
}
