package com.example.TaskPlanner.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    @Enumerated(EnumType.STRING)
    StatusType status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;


}
