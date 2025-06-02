package gr.aueb.cf.teacher.teacherapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {

    // Principal = loggedIn user
    @GetMapping("/login")
    public String login(Principal principal) {
        return principal == null ? "loginb" : "redirect:/school/teachers";
    }
}
