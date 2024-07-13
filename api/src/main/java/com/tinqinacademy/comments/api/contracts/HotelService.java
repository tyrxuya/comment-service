package com.tinqinacademy.comments.api.contracts;

import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentInput;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentOutput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsInput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsOutput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentInput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOutput;

public interface HotelService {
    GetCommentsOutput getComments(GetCommentsInput input);

    CreateCommentOutput createComment(CreateCommentInput input);

    UserEditCommentOutput userEditComment(UserEditCommentInput input);
}
