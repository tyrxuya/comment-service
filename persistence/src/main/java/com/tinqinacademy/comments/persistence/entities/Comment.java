package com.tinqinacademy.comments.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 200)
    private String comment;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private UUID roomId;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishedDate;

    @Column()
    private LocalDateTime lastEditTime = LocalDateTime.now();

    @Column()
    private UUID editedByUserId;
}
