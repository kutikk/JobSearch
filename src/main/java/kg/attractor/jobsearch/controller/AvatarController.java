package kg.attractor.jobsearch.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
public class AvatarController {
    @PostMapping("/upload-avatar")
    public ResponseEntity<String> uploadAvatar(@RequestParam MultipartFile file) {
        return ResponseEntity.ok("Аватар загружен!");
    }
}
