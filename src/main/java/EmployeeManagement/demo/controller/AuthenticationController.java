package EmployeeManagement.demo.controller;

import EmployeeManagement.demo.model.User;
import EmployeeManagement.demo.model.UserTemplate;
import EmployeeManagement.demo.repository.UserRepository;
import EmployeeManagement.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserTemplate());
        return "authentication/register";
    }


    @PostMapping("/register")
    public String registerHandle(Model model,
                                 @Valid UserTemplate ut, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("user", ut);
            return "register";
        } else {
            User user = userService.register(ut);
            if (user != null) {
                model.addAttribute("user", new UserTemplate());
                model.addAttribute("success", true);
                return "employee/list";
            } else {
                model.addAttribute("user", ut);
                model.addAttribute("error", true);
                return "register";
            }
        }
    }
}
