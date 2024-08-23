package com.tinqinacademy.comments.core.configurations;

import com.tinqinacademy.comments.core.converters.CommentToCommentOutput;
import com.tinqinacademy.comments.core.converters.CommentToDeleteCommentOutput;
import com.tinqinacademy.comments.core.converters.CreateCommentInputToComment;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final CommentToCommentOutput commentToCommentOutput;
    private final CommentToDeleteCommentOutput commentToDeleteCommentOutput;
    private final CreateCommentInputToComment createCommentInputToComment;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(commentToCommentOutput);
        registry.addConverter(commentToDeleteCommentOutput);
        registry.addConverter(createCommentInputToComment);
    }
}
