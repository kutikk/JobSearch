package kg.attractor.jobsearch.controller.norm;
import jakarta.validation.Valid;
import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.service.interfaces.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/auth")
public class RegisterController {
    private final ProfileService profileService;

    public RegisterController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDto userDto,
                           BindingResult bindingResult,
                           @RequestParam("avatarFile") MultipartFile avatarFile,
                           Model model) throws IOException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            model.addAttribute("user", userDto);
            return "register";
        }

        return profileService.createProfile(userDto, avatarFile);
    }

}
