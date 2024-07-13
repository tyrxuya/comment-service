package com.tinqinacademy.comments.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.comments.api.contracts.HotelService;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentInput;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentOutput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsInput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsOutput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentInput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOutput;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Hotel REST APIs")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final ObjectMapper objectMapper;

    @GetMapping(Endpoint.GET_COMMENT)
    public ResponseEntity<GetCommentsOutput> getComments(@PathVariable String roomId) {
        GetCommentsInput input = GetCommentsInput.builder()
                .roomId(roomId)
                .build();
        return new ResponseEntity<>(hotelService.getComments(input), HttpStatus.OK);
    }

    @PostMapping(Endpoint.CREATE_COMMENT)
    public ResponseEntity<CreateCommentOutput> createComment(@PathVariable String roomId,
                                                             @RequestBody @Valid CreateCommentInput input) {
        input = input.toBuilder()
                .roomId(roomId)
                .build();

        return new ResponseEntity<>(hotelService.createComment(input), HttpStatus.CREATED);
    }

    @PatchMapping(Endpoint.USER_EDIT_COMMENT)
    public ResponseEntity<UserEditCommentOutput> userEditComment(@PathVariable String commentId,
                                                                 @RequestBody @Valid UserEditCommentInput input) {
        return new ResponseEntity<>(hotelService.userEditComment(input), HttpStatus.OK);
    }
}
