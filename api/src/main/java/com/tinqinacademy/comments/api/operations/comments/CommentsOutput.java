package com.tinqinacademy.comments.api.operations.comments;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentsOutput {
    //@NotBlank(message = "id cannot be blank!")
    private String id;

    //@NotBlank(message = "firstName cannot be blank!")
    //@Size(min = 2, max = 50, message = "firstName must be between 2 and 50 symbols!")
    private String firstName;

    //@NotBlank(message = "lastName cannot be blank!")
    //@Size(min = 2, max = 50, message = "lastName must be between 2 and 50 symbols!")
    private String lastName;

    //@NotBlank(message = "content cannot be blank!")
    //@Size(max = 200, message = "content cannot be over 200 symbols!")
    private String content;

    //@Future(message = "invalid publishDate!")
    private LocalDateTime publishDate;

    //@Future(message = "invalid lastEditedDate!")
    private LocalDateTime lastEditedDate;

    //@NotBlank(message = "lastEditedBy cannot be blank!")
    private String lastEditedBy;
}
