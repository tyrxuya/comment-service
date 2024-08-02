package com.tinqinacademy.comments.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentInput;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentOperation;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentOutput;
import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentInput;
import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentOperation;
import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.vavr.control.Either;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "System REST APIs")
@Validated
public class SystemController extends BaseController {
    private final AdminEditCommentOperation adminEditCommentOperation;
    private final DeleteCommentOperation deleteCommentOperation;
    private final ObjectMapper objectMapper;

    @PutMapping(RestApiPaths.ADMIN_EDIT_COMMENT)
    public ResponseEntity<?> adminEditComment(@PathVariable String commentId,
                                              @RequestBody AdminEditCommentInput input) {
        Either<ErrorsList, AdminEditCommentOutput> result = adminEditCommentOperation.process(input);
        return getOutput(result, HttpStatus.OK);
    }

    @DeleteMapping(RestApiPaths.DELETE_COMMENT)
    public ResponseEntity<?> deleteComment(@PathVariable String commentId,
                                           @RequestBody DeleteCommentInput input) {
        Either<ErrorsList, DeleteCommentOutput> result = deleteCommentOperation.process(input);
        return getOutput(result, HttpStatus.OK);
    }
}
