package ru.kata.spring.security.services;

import ru.kata.spring.security.models.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);

}
