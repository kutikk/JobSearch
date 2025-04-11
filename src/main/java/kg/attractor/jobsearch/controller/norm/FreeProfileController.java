package kg.attractor.jobsearch.controller.norm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
public class FreeProfileController {

    @GetMapping
    public String profile() {
        return "profile";
    }
    @GetMapping("update")
    public String updateProfile() {
        return "updateProfile";

    }
}
