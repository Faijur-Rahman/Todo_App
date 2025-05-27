package com.todo.project.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoPatchDTO {

    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters if provided")
    private String title;

    @Size(max = 500, message = "Description cannot exceed 500 characters if provided")
    private String description;

    @NotNull(message = "Completed status cannot be null if explicitly provided")
    private Boolean completed;
}
