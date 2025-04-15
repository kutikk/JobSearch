package kg.attractor.jobsearch.controller.norm;

import kg.attractor.jobsearch.dto.ProfileDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.service.ProfileService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("profile")
public class FreeProfileController {
    private final ProfileService profileService;

    public FreeProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public String profile(Model model) throws UserNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        long userId = profileService.getIdByUsername(username);
        model.addAttribute("profile", profileService.getProfileById(userId) );
        return "profile";
    }
    @GetMapping("update")
    public String updateProfile() {
        return "updateProfile";
    }
    @PostMapping("update")
    public String updateProfile(@RequestParam("avatar") MultipartFile avatar,
                                @RequestParam("name") String name,
                                @RequestParam("phone") String phone,
                                @RequestParam("age") int age) throws IOException, UserNotFoundException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        long userId = profileService.getIdByUsername(username);
        profileService.updateProfileWithFile(userId, name, phone, age, avatar);
        return "redirect:/profile";
    }



}
