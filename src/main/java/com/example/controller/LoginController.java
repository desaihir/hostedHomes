package com.example.controller;

import com.example.pojo.User;
import com.example.service.EmailService;
import com.example.service.UserService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private EmailService emailService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();

        // Validate login credentials
        if (userService.isValidLogin(username, password)) {
            // Login successful
        	session.setAttribute("username", username);
            return "redirect:/dashboard";
        } else {
            // Login failed
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        if (userService.usernameExists(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("error", "Email already exists");
            return "register";
        }
        userService.save(user);
        try {
			emailService.sendRegistrationEmail(user);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:/login";
    }
}

