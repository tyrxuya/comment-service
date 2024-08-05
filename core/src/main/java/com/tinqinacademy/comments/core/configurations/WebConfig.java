package com.tinqinacademy.comments.core.configurations;

import com.tinqinacademy.comments.core.converters.CreateCommentInputToComment;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CreateCommentInputToComment());
    }
}
