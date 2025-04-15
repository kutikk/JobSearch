package kg.attractor.jobsearch.controller.norm;

import kg.attractor.jobsearch.dto.ProfileDto;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/auth")
public class RegisterController {
   private final ProfileService profileService;

    public RegisterController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("register")
    public String register(ProfileDto profileDto, MultipartFile avatarFile) throws IOException {
        return profileService.createProfile(profileDto, avatarFile);
    }

}
