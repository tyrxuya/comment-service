package com.tinqinacademy.comments.core.operations;

import com.tinqinacademy.comments.api.errors.ErrorMapper;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentInput;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentOperation;
import com.tinqinacademy.comments.api.operations.admineditcomment.AdminEditCommentOutput;
import io.vavr.control.Either;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminEditComment extends BaseOperation implements AdminEditCommentOperation {
    public AdminEditComment(Validator validator, ConversionService conversionService, ErrorMapper errorMapper) {
        super(validator, conversionService, errorMapper);
    }

    @Override
    public Either<ErrorsList, AdminEditCommentOutput> process(AdminEditCommentInput input) {
        return null;
    }
}
