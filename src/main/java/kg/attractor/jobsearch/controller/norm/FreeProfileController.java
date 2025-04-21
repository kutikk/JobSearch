package kg.attractor.jobsearch.controller.norm;

import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.service.interfaces.ProfileService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String profile(  @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "2") int size, Model model) throws UserNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        UserDto profile = profileService.getProfileById(email, page, size);
        model.addAttribute("pageSize", size);
        model.addAttribute("profile", profile);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", profile.getTotalPages());
        model.addAttribute("totalItems", profile.getTotalElements());
        return "profile";
    }
    @GetMapping("update")
    public String updateProfile() {
        return "updateProfile";
    }

    @PostMapping("update")
    public String updateProfile(@RequestParam("avatar") MultipartFile avatar,
                                @RequestParam("user_name") String user_name,
                                @RequestParam("phone") String phone,
                                @RequestParam("age") int age) throws IOException, UserNotFoundException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        profileService.updateProfileWithFile( email,user_name, phone, age, avatar);
        return "redirect:/profile";
    }
    @GetMapping("/{id}")
    public String viewProfileById(@PathVariable("id") String id, Model model) {
        model.addAttribute("profile", profileService.getPublicProfileById(id));
        return "publicProfile";
    }




}
