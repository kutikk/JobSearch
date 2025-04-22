package kg.attractor.jobsearch.controller.norm;

import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.models.Vacancies;
import kg.attractor.jobsearch.repository.VacanciesRepository;
import kg.attractor.jobsearch.service.interfaces.ProfileService;
import kg.attractor.jobsearch.service.interfaces.VacancyService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("home")
public class homeController {
    private final VacancyService vacancyService;
    private final ProfileService profileService;

    public homeController(VacancyService vacancyService, ProfileService profileService) {
        this.vacancyService = vacancyService;

        this.profileService = profileService;
    }

    @GetMapping()
    public String getVacancies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            Model model) throws UserNotFoundException {
        Page<Vacancies> vacancyPage = vacancyService.getVacancies(page, size);
        model.addAttribute("vacancies", vacancyPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", vacancyPage.getTotalPages());
        model.addAttribute("totalItems", vacancyPage.getTotalElements());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        model.addAttribute("profile", profileService.getPublicProfileById(email));
        return "home";
    }
}
