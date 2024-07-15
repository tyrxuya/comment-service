package com.tinqinacademy.comments.rest;

import com.tinqinacademy.comments.api.contracts.ErrorHandler;
import com.tinqinacademy.comments.api.errors.ErrorsList;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = {HotelController.class, SystemController.class})
@Slf4j
public class GlobalExceptionHandler {
    private final ErrorHandler errorHandler;

    public GlobalExceptionHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorsList> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                            HttpServletRequest request) {
        log.error("Request {} raised {}", request.getRequestURL(), ex.getClass());

        return new ResponseEntity<>(errorHandler.handle(ex), HttpStatus.I_AM_A_TEAPOT);
    }
}
