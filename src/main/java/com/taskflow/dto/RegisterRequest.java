package com.taskflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Username is verplicht")
    @Size(min = 3, max = 30)
    private String username;

    @NotBlank(message = "Email is verplicht")
    @Email(message = "Geen geldig emailadres")
    private String email;

    @NotBlank(message = "Wachtwoord is verplicht")
    @Size(min = 6, message = "Wachtwoord minimaal 6 tekens")
    private String password;
}
