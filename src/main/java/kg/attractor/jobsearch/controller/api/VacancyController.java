package kg.attractor.jobsearch.controller.api;


import kg.attractor.jobsearch.dto.VacancyDto;
import kg.attractor.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;
    @GetMapping("{applicant_id}")
    public List<VacancyDto> getVacancyByApplicant(@PathVariable int applicant_id) {
        return vacancyService.getVacancyByApplicant(applicant_id);
    }

    @GetMapping("/all")
    public List<VacancyDto> getAllVacancies() {
        return vacancyService.getAllVacancies();
    }

    @GetMapping("category/{category_id}")
    public List<VacancyDto> getVacanciesByCategory(@PathVariable String category_id) {
     return vacancyService.getVacancyByCategory(Integer.parseInt(category_id));
    }
    @GetMapping("{id}")
    public List<VacancyDto> getVacanciesById(@PathVariable int id) {
        return vacancyService.getVacancyById(id);
    }
}
