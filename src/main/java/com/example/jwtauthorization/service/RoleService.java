package com.example.jwtauthorization.service;

import com.example.jwtauthorization.domain.Role;
import com.example.jwtauthorization.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {
    private final RoleRepo roleRepo;

    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

}
