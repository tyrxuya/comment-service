package com.tinqinacademy.comments.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.comments.api.contracts.SystemService;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentInput;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentOutput;
import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentInput;
import com.tinqinacademy.comments.api.operations.deletecomment.DeleteCommentOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
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
public class SystemController {
    private final SystemService commentService;
    private final ObjectMapper objectMapper;

    @PutMapping(RestApiPaths.ADMIN_EDIT_COMMENT)
    public ResponseEntity<AdminEditCommentOutput> adminEditComment(@PathVariable String commentId,
                                                                   @RequestBody @Valid AdminEditCommentInput input) {
        AdminEditCommentOutput result = commentService.adminEditComment(input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(RestApiPaths.DELETE_COMMENT)
    public ResponseEntity<DeleteCommentOutput> deleteComment(@PathVariable String commentId,
                                                             @RequestBody @Valid DeleteCommentInput input) {
        DeleteCommentOutput result = commentService.deleteComment(input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
