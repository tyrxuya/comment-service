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
            log.info("start process input: {}", input);

            validate(input);

            Comment comment = findCommentByInputId(input);

            editCommentFieldsByInput(comment, input);

            commentRepository.save(comment);

            AdminEditCommentOutput result = AdminEditCommentOutput.builder()
                    .id(comment.getId().toString())
                    .build();

            log.info("end process result: {}", result);

            return result;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        customCase(throwable, HttpStatus.NOT_FOUND, CommentNotFound.class),
                        defaultCase(throwable, HttpStatus.I_AM_A_TEAPOT)
                ));
    }

    private void editCommentFieldsByInput(Comment comment, AdminEditCommentInput input) {
        comment.setRoomNo(input.getRoomNo());
        comment.setComment(input.getContent());
        comment.setEditedByUserId(UUID.randomUUID()); //will be changed later
    }

    private Comment findCommentByInputId(AdminEditCommentInput input) {
        return commentRepository.findById(UUID.fromString(input.getCommentId()))
                .orElseThrow(CommentNotFound::new);
    }
}
