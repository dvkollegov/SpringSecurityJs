package ru.kata.spring.security.util;

import org.springframework.stereotype.Component;
import ru.kata.spring.security.models.Role;
import ru.kata.spring.security.models.User;
import ru.kata.spring.security.services.RoleService;
import ru.kata.spring.security.services.UserService;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.LinkedList;

@Component
public class InitApp {
    private final UserService userService;
    private final RoleService roleService;

    public InitApp(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void defaultAdminAndUser() {
        Role defaultAdmin = new Role("ROLE_ADMIN");
        Role defaultUser = new Role("ROLE_USER");
        Collection<Role> rolesAdmin = new LinkedList<>();
        Collection<Role> rolesUser = new LinkedList<>();
        rolesAdmin.add(defaultAdmin);
        rolesUser.add(defaultUser);
        User admin = new User("Admin", "Admin", 38, "test@mail.ru",
                "pass", rolesAdmin);
        User user = new User("User", "User", 38, "test@ya.ru",
                "pass", rolesUser);
        roleService.save(defaultAdmin);
        roleService.save(defaultUser);
        userService.addUser(admin);
        userService.addUser(user);
    }
}
