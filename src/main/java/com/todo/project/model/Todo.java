package com.todo.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "todos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty") // Ensures title is not null, empty, or just whitespace
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters") // Enforces length
    private String title;

    @Size(max = 500, message = "Description cannot exceed 500 characters") // Optional: Description can be null, but if present, has max size
    private String description;

    @NotNull(message = "Completed status cannot be null")
    private Boolean completed;
}
