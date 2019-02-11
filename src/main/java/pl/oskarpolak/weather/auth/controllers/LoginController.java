package pl.oskarpolak.weather.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.weather.auth.forms.LoginForm;
import pl.oskarpolak.weather.auth.forms.RegisterForm;
import pl.oskarpolak.weather.auth.services.UserService;

@Controller
public class LoginController {

    final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String register(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "register";
    }

    @PostMapping("/login")
    public String register(@ModelAttribute LoginForm loginForm,
                           Model model){ //zmienna1,  zmienna2, zmienna3
        userService.login(loginForm);
        return "redirect:/login";
    }


}
