package com.tinqinacademy.comments.restexport;

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
public interface CommentsRestExport {
    @RequestLine("GET /api/v1/hotel/{roomId}/comment")
    GetCommentsOutput getComments(@Param String roomId);

    @RequestLine("POST /api/v1/hotel{roomId}/comment")
    CreateCommentOutput createComment(@Param String roomId,
                                      CreateCommentInput input);

    @RequestLine("PATCH /api/v1/hotel/comment/{commentId}")
    UserEditCommentOutput userEditComment(@Param String commentId,
                                          UserEditCommentInput input);

    @RequestLine("PUT /api/v1/system/comment/{commentId}")
    AdminEditCommentOutput adminEditComment(@Param String commentId,
                                            AdminEditCommentInput input);

    @RequestLine("DELETE /api/v1/system/comment/{commentId}")
    DeleteCommentOutput deleteComment(@Param String commentId,
                                      DeleteCommentInput input);
}
