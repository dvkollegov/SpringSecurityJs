package ru.kata.spring.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.security.models.Role;
import ru.kata.spring.security.models.User;
import ru.kata.spring.security.services.RoleService;
import ru.kata.spring.security.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showAllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/user")
    public String showUser(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user")User user, Model model){
        List<Role> role = roleService.getAllRoles();
        model.addAttribute("allRoles", role);
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(value = "id") long id, Model model) {
        List<Role> role = roleService.getAllRoles();
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("allRoles", role);
        return "edit";
    }

    @PatchMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
