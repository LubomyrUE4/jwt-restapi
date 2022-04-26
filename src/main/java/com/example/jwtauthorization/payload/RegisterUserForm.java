package com.example.jwtauthorization.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterUserForm {
    @NotBlank
    @Size(min=3, message = "Should have at least 3 characters!")
    @Size(max=20, message = "Should have not more than 20 characters!")
    private String name;
    @NotBlank
    @Size(min=3, message = "Should have at least 3 characters!")
    @Size(max=20, message = "Should have not more than 20 characters!")
    private String username;
    @NotBlank
    @Size(min=3, message = "Should have at least 3 characters!")
    @Size(max=20, message = "Should have not more than 20 characters!")
    private String password;
}
