package kg.attractor.jobsearch.controller.norm;

import kg.attractor.jobsearch.models.Vacancies;
import kg.attractor.jobsearch.service.VacancyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vacancies")
public class VacanciesController {
    private final VacancyService vacancyService;

    public VacanciesController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping
    public String vacancies(Model model) {
        model.addAttribute("vacancies", vacancyService.getAllVacancies());
        return "vacancies";
    }
    @GetMapping("new")
    public String newVacancy(Model model) {
        return   "newVacancy";
    }

}
