package com.tinqinacademy.comments.core.operations;

import com.tinqinacademy.comments.api.errors.ErrorMapper;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentInput;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentOperation;
import com.tinqinacademy.comments.api.operations.createcomment.CreateCommentOutput;
import io.vavr.control.Either;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateComment extends BaseOperation implements CreateCommentOperation {
    public CreateComment(Validator validator, ConversionService conversionService, ErrorMapper errorMapper) {
        super(validator, conversionService, errorMapper);
    }

    @Override
    public Either<ErrorsList, CreateCommentOutput> process(CreateCommentInput input) {
        return null;
    }
}
