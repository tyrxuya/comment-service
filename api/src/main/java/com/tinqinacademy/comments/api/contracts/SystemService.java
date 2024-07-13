package com.tinqinacademy.comments.api.contracts;

import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentInput;
import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentOutput;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentInput;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentOutput;

public interface SystemService {
    AdminEditCommentOutput adminEditComment(AdminEditCommentInput input);

    DeleteCommentOutput deleteComment(DeleteCommentInput input);
}
