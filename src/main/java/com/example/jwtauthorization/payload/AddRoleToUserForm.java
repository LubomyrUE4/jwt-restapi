package com.example.jwtauthorization.payload;

import lombok.Data;

@Data
public class AddRoleToUserForm {
    private String username;
    private String role;
}