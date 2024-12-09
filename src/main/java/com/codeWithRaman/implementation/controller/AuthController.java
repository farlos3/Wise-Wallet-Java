package com.codeWithRaman.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeWithRaman.implementation.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";  // ตรวจสอบว่ามี view ชื่อ "register"
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               @RequestParam String email,
                               org.springframework.ui.Model model) { // เพิ่ม email
        if (!password.equals(confirmPassword)) {
            model.addAttribute("errorMessage", "Passwords do not match.");
            return "register";  // ตรวจสอบว่ามี view ชื่อ "register"
        }
        userService.registerUser(username, password, email); // ส่ง email ไปยัง service
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // ตรวจสอบว่ามี view ชื่อ "login"
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";  // ตรวจสอบว่ามี view ชื่อ "welcome"
    }
}

