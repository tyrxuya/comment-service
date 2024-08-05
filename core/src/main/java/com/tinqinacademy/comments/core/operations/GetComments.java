package com.tinqinacademy.comments.core.operations;

import com.tinqinacademy.comments.api.errors.ErrorMapper;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import com.tinqinacademy.comments.api.operations.comments.CommentsOutput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsInput;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsOperation;
import com.tinqinacademy.comments.api.operations.getcomments.GetCommentsOutput;
import com.tinqinacademy.comments.persistence.entities.Comment;
import com.tinqinacademy.comments.persistence.repositories.CommentRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.vavr.API.List;
import static io.vavr.API.Match;

@Service
@Slf4j
public class GetComments extends BaseOperation implements GetCommentsOperation {
    private final CommentRepository commentRepository;

    public GetComments(Validator validator, ConversionService conversionService, ErrorMapper errorMapper, CommentRepository commentRepository) {
        super(validator, conversionService, errorMapper);
        this.commentRepository = commentRepository;
    }

    @Override
    public Either<ErrorsList, GetCommentsOutput> process(GetCommentsInput input) {
        return Try.of(() -> {
            log.info("start process input: {}", input);

            validate(input);

            List<Comment> comments = commentRepository.findCommentsByRoomId(UUID.fromString(input.getRoomId()));

            List<CommentsOutput> commentsOutputs = getCommentsOutputsListFromListOfComments(comments);

            GetCommentsOutput result = GetCommentsOutput.builder()
                    .comments(commentsOutputs)
                    .build();

            log.info("end process result: {}", result);

            return result;
        })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        defaultCase(throwable, HttpStatus.I_AM_A_TEAPOT)
                ));
    }

    private List<CommentsOutput> getCommentsOutputsListFromListOfComments(List<Comment> comments) {
        List<CommentsOutput> commentsOutputs = new ArrayList<>();

        comments.forEach(comment -> commentsOutputs.add(
                conversionService.convert(comment, CommentsOutput.class)
        ));

        return commentsOutputs;
    }
}
