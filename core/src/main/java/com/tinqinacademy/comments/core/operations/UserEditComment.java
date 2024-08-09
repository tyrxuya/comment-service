package com.tinqinacademy.comments.core.operations;

import com.tinqinacademy.comments.api.errors.ErrorMapper;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import com.tinqinacademy.comments.api.exceptions.CommentNotFound;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentInput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOperation;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOutput;
import com.tinqinacademy.comments.persistence.entities.Comment;
import com.tinqinacademy.comments.persistence.repositories.CommentRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static io.vavr.API.Match;

@Service
@Slf4j
public class UserEditComment extends BaseOperation implements UserEditCommentOperation {
    private final CommentRepository commentRepository;

    public UserEditComment(Validator validator, ConversionService conversionService, ErrorMapper errorMapper, CommentRepository commentRepository) {
        super(validator, conversionService, errorMapper);
        this.commentRepository = commentRepository;
    }

    @Override
    public Either<ErrorsList, UserEditCommentOutput> process(UserEditCommentInput input) {
        return Try.of(() -> {
                    log.info("Start process method in UserEditCommentOperation. Input: {}", input);

                    validate(input);

                    Comment comment = findCommentByInputId(input);
                    log.info("Comment {} found.", comment);

                    comment.setComment(input.getContent());

                    commentRepository.save(comment);
                    log.info("Comment {} saved.", comment);

                    UserEditCommentOutput result = UserEditCommentOutput.builder()
                            .id(comment.getId().toString())
                            .build();

                    log.info("End process method in UserEditCommentOperation. Result: {}", result);

                    return result;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        defaultCase(throwable, HttpStatus.I_AM_A_TEAPOT)
                ));
    }

    private Comment findCommentByInputId(UserEditCommentInput input) {
        return commentRepository.findById(UUID.fromString(input.getCommentId()))
                .orElseThrow(() -> {
                    log.warn("Comment with id {} not found.", input.getCommentId());
                    return new CommentNotFound();
                });
    }
}
