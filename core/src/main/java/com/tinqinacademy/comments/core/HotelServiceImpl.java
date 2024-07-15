package com.tinqinacademy.comments.core;

import com.tinqinacademy.comments.api.contracts.HotelService;
import com.tinqinacademy.comments.api.operations.comments.CommentsOutput;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentInput;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentOutput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsInput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsOutput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentInput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOutput;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class HotelServiceImpl implements HotelService {
    @Override
    public GetCommentsOutput getComments(GetCommentsInput input) {
        log.info("start getComments input: {}", input);

        List<CommentsOutput> comments = new ArrayList<>();

        comments.add(CommentsOutput.builder()
                .content("i like this room")
                .firstName("vanio")
                .lastName("ivanov")
                .id("12312")
                .publishDate(LocalDate.now().plusDays(3))
                .lastEditedDate(LocalDate.now().plusDays(3))
                .lastEditedBy("admin")
                .build()
        );

        comments.add(CommentsOutput.builder()
                .content("i dont like this room")
                .firstName("vanio")
                .lastName("ivanov")
                .id("12313")
                .publishDate(LocalDate.of(2024, 7, 9))
                .lastEditedDate(LocalDate.of(2024, 7, 9))
                .lastEditedBy("petia")
                .build()
        );

        GetCommentsOutput result = GetCommentsOutput.builder()
                .comments(comments)
                .build();

        log.info("end getComments result: {}", result);

        return result;
    }

    @Override
    public CreateCommentOutput createComment(CreateCommentInput input) {
        log.info("start createComment input: {}", input);

        CreateCommentOutput result = CreateCommentOutput.builder()
                .id("151515")
                .build();

        log.info("end createComment result: {}", result);

        return result;
    }

    @Override
    public UserEditCommentOutput userEditComment(UserEditCommentInput input) {
        log.info("start userEditComment input: {}", input);

        UserEditCommentOutput result = UserEditCommentOutput.builder()
                .id("121212")
                .build();

        log.info("end userEditComment result: {}", result);

        return result;
    }
}
