package kg.attractor.jobsearch.controller;

import kg.attractor.jobsearch.models.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        if (user.getAccount_type() == null || (!user.getAccount_type().equalsIgnoreCase("APPLICANT")
                && !user.getAccount_type().equalsIgnoreCase("EMPLOYER"))) {
            return ResponseEntity.badRequest().body("Неверная роль!");
        }
        return ResponseEntity.ok("Пользователь успешно зарегистрирован как " + user.getAccount_type());
    }
}