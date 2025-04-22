package kg.attractor.jobsearch.controller.norm;

import jakarta.validation.Valid;
import kg.attractor.jobsearch.dto.VacancyDto;
import kg.attractor.jobsearch.models.Vacancies;
import kg.attractor.jobsearch.service.interfaces.ProfileService;
import kg.attractor.jobsearch.service.interfaces.VacancyService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("vacancies")
public class VacanciesController {
    private final VacancyService vacancyService;

    public VacanciesController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;

    }

    @GetMapping()
    public String showVacancies(Model model) {
        List<VacancyDto> vacancies = vacancyService.getAllVacancies();
        model.addAttribute("vacancies", vacancies);
        return "vacancies";
    }
    @GetMapping("new")
    public String newVacancy(Model model) {
        model.addAttribute("vacancy", new VacancyDto());
        return   "newVacancy";
    }

    @PostMapping("create")
    public String createVacancy(@ModelAttribute("vacancy")
                                    @Valid VacancyDto vacancyDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            model.addAttribute("vacancy", vacancyDto);
            return "newVacancy";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        vacancyDto.setAuthor_id(username);
        return vacancyService.createVacancy(vacancyDto);
    }
    @GetMapping("update/{id}")
    public String updateVacancy(@PathVariable Integer id, Model model) {
        model.addAttribute("vacancy", vacancyService.getVacancyById(id));
        return   "updateVacancy";
    }
    @PostMapping("update/{id}")
    public String updateVacancies(@PathVariable Integer id, VacancyDto  vacancyDto,Model model) {
        model.addAttribute("vacancy", vacancyService.getVacancyById(id));
        return vacancyService.updateVacancy(vacancyDto);
    }



}
