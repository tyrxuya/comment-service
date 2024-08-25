package com.tinqinacademy.comments.restexport;

import com.tinqinacademy.comments.api.CommentsFeignClientApiPaths;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentInput;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentOutput;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentInput;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentOutput;
import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentInput;
import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentOutput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsOutput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentInput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({
        "Content-Type: application/json"
})
public interface CommentsClient {
    @RequestLine(CommentsFeignClientApiPaths.GET_COMMENTS)
    GetCommentsOutput getComments(@Param String roomId);

    @RequestLine(CommentsFeignClientApiPaths.CREATE_COMMENT)
    CreateCommentOutput createComment(@Param String roomId,
                                      CreateCommentInput input);

    @RequestLine(CommentsFeignClientApiPaths.USER_EDIT_COMMENT)
    UserEditCommentOutput userEditComment(@Param String commentId,
                                          UserEditCommentInput input);

    @RequestLine(CommentsFeignClientApiPaths.ADMIN_EDIT_COMMENT)
    AdminEditCommentOutput adminEditComment(@Param String commentId,
                                            AdminEditCommentInput input);

    @RequestLine(CommentsFeignClientApiPaths.DELETE_COMMENT)
    DeleteCommentOutput deleteComment(@Param String commentId);
}
