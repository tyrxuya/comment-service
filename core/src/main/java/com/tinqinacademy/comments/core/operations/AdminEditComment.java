package com.tinqinacademy.comments.core.operations;

import com.tinqinacademy.comments.api.errors.ErrorMapper;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import com.tinqinacademy.comments.api.exceptions.CommentNotFound;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentInput;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentOperation;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentOutput;
import com.tinqinacademy.comments.persistence.entities.Comment;
import com.tinqinacademy.comments.persistence.repositories.CommentRepository;
import io.vavr.API;
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
public class AdminEditComment extends BaseOperation implements AdminEditCommentOperation {
    protected final CommentRepository commentRepository;

    public AdminEditComment(Validator validator, ConversionService conversionService, ErrorMapper errorMapper, CommentRepository commentRepository) {
        super(validator, conversionService, errorMapper);
        this.commentRepository = commentRepository;
    }

    @Override
    public Either<ErrorsList, AdminEditCommentOutput> process(AdminEditCommentInput input) {
        return Try.of(() -> {
            log.info("Start process method in AdminEditCommentOperation. Input: {}", input);

            validate(input);

            Comment comment = findCommentByInputId(input);
            log.info("Comment {} found", comment);

            editCommentFieldsByInput(comment, input);
            log.info("Comment fields updated");

            commentRepository.save(comment);
            log.info("Comment saved in repository");

            AdminEditCommentOutput result = AdminEditCommentOutput.builder()
                    .commentId(comment.getId().toString())
                    .build();

            log.info("End process method in AdminEditCommentOperation. Result: {}", result);

            return result;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        validateCase(throwable, HttpStatus.BAD_REQUEST),
                        customCase(throwable, HttpStatus.NOT_FOUND, CommentNotFound.class)
                ));
    }

    private void editCommentFieldsByInput(Comment comment, AdminEditCommentInput input) {
        comment.setRoomId(UUID.fromString(input.getRoomId()));
        comment.setComment(input.getContent());
        comment.setLastEditedBy(UUID.fromString(input.getUserId()));
    }

    private Comment findCommentByInputId(AdminEditCommentInput input) {
        return commentRepository.findById(UUID.fromString(input.getCommentId()))
                .orElseThrow(() -> {
                    log.warn("Comment with id {} not found", input.getCommentId());
                    return new CommentNotFound();
                });
    }
}
