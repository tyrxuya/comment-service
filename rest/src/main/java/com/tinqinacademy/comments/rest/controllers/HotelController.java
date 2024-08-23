package com.tinqinacademy.comments.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.comments.api.CommentsRestApiPaths;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentInput;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentOperation;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentOutput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsInput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsOperation;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsOutput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentInput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOperation;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.vavr.control.Either;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Hotel REST APIs")
@RequiredArgsConstructor
public class HotelController extends BaseController {
    private final GetCommentsOperation getCommentsOperation;
    private final CreateCommentOperation createCommentOperation;
    private final UserEditCommentOperation userEditCommentOperation;

    @GetMapping(CommentsRestApiPaths.GET_COMMENT)
    @Operation(
            summary = "Get comments REST API",
            description = "Get list of all comments left for a certain room"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comments found"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Comments not found")
    })
    public ResponseEntity<?> getComments(@PathVariable String roomId) {
        GetCommentsInput input = GetCommentsInput.builder()
                .roomId(roomId)
                .build();

        Either<ErrorsList, GetCommentsOutput> result = getCommentsOperation.process(input);
        return getOutput(result, HttpStatus.OK);
    }

    @PostMapping(CommentsRestApiPaths.CREATE_COMMENT)
    @Operation(
            summary = "Create comment REST API",
            description = "Leaves a comment regarding a certain room."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<?> createComment(@PathVariable String roomId,
                                           @RequestBody CreateCommentInput input) {
        input.setRoomId(roomId);

        Either<ErrorsList, CreateCommentOutput> result = createCommentOperation.process(input); //!!!

        return getOutput(result, HttpStatus.CREATED);
    }

    @PatchMapping(CommentsRestApiPaths.USER_EDIT_COMMENT)
    @Operation(
            summary = "User edit comment REST API",
            description = "User can edit own comment left for a certain room. Last edited date is updated. Info regarding user edited is updated."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Edit successful"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Comment not found")
    })
    public ResponseEntity<?> userEditComment(@PathVariable String commentId,
                                             @RequestBody UserEditCommentInput input) {
        input.setCommentId(commentId);

        Either<ErrorsList, UserEditCommentOutput> result = userEditCommentOperation.process(input);
        return getOutput(result, HttpStatus.OK);
    }
}
