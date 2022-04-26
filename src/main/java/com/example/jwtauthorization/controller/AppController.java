package com.example.jwtauthorization.controller;

import com.example.jwtauthorization.domain.Role;
import com.example.jwtauthorization.domain.User;
import com.example.jwtauthorization.payload.AddRoleToUserForm;
import com.example.jwtauthorization.payload.RegisterUserForm;
import com.example.jwtauthorization.service.RoleService;
import com.example.jwtauthorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody @Valid RegisterUserForm registerUserForm) {
        if(userService.findByUsername(registerUserForm.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        User user = new User(registerUserForm.getName(), registerUserForm.getUsername(),
                registerUserForm.getPassword());

        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @PostMapping("/saveRole")
    public ResponseEntity<?> saveRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.saveRole(role), HttpStatus.OK);
    }

    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @PostMapping("/addRoleToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody AddRoleToUserForm addRoleToUserForm) {
        userService.addRoleToUser(addRoleToUserForm.getUsername(), addRoleToUserForm.getRole());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
