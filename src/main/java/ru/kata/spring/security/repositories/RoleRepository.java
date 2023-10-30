package ru.kata.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.security.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
