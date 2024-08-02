package com.tinqinacademy.comments.core.operations;

import com.tinqinacademy.comments.api.errors.ErrorMapper;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentInput;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOperation;
import com.tinqinacademy.comments.api.operations.usereditcomment.UserEditCommentOutput;
import io.vavr.control.Either;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserEditComment extends BaseOperation implements UserEditCommentOperation {
    public UserEditComment(Validator validator, ConversionService conversionService, ErrorMapper errorMapper) {
        super(validator, conversionService, errorMapper);
    }

    @Override
    public Either<ErrorsList, UserEditCommentOutput> process(UserEditCommentInput input) {
        return null;
    }
}
