package com.taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TaskRequest {

    @NotBlank(message = "Titel is verplicht")
    private String title;

    private String description;

    private LocalDate deadline;

    private Long categoryId;
}
