package kg.attractor.jobsearch.service.impl;
import kg.attractor.jobsearch.dto.VacancyDto;
import kg.attractor.jobsearch.exceptions.ResumeNotFoundException;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.models.Vacancies;
import kg.attractor.jobsearch.repository.VacanciesRepository;
import kg.attractor.jobsearch.service.interfaces.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacanciesRepository  vacanciesRepository;

    @Override
    public List<VacancyDto> getVacancyByApplicant(int applicant_id) {
        return List.of();
    }

    @Override
    public List<VacancyDto> getAllVacancies() {
        List<Vacancies> vacanciesList = vacanciesRepository.findAll();
        return vacanciesList.stream()
                .map(vacancies -> {
                    VacancyDto vacancyDto = new VacancyDto();
                    vacancyDto.setId(vacancies.getId());
                    vacancyDto.setName(vacancies.getName());
                    vacancyDto.setDescription(vacancies.getDescription());
                    vacancyDto.setAuthor_id(vacancies.getAuthor().getEmail());
                    vacancyDto.setSalary(Float.valueOf(vacancies.getSalary()));
                    vacancyDto.setExp_from(Integer.valueOf(vacancies.getExp_from()));
                    vacancyDto.setCreated_date(vacancies.getCreated_date());
                    vacancyDto.setUpdate_time(vacancies.getUpdate_time());
                    return vacancyDto;
                })
                .collect(Collectors.toList());
    }


    @Override
    public List<VacancyDto> getVacancyByCategory(int categoryID) {
        return List.of();
    }


    @Override
    public String createVacancy(VacancyDto vacancyDto) {
        Users user = new Users();
        user.setEmail(vacancyDto.getAuthor_id());
        Vacancies vacancies = new Vacancies();

        return getString(vacancyDto, user, vacancies);

    }
@Override
public VacancyDto getVacancyById(Integer id) {
        Vacancies vacancy = vacanciesRepository.findById(id)
                .orElseThrow(ResumeNotFoundException::new);
       return VacancyDto.builder()
               .id(vacancy.getId())
                .name(vacancy.getName())
                .description(vacancy.getDescription())
                .salary(vacancy.getSalary())
                .exp_from(vacancy.getExp_from())
                .exp_to(vacancy.getExp_to())
                .created_date(vacancy.getCreated_date())
                .update_time(vacancy.getUpdate_time())
                .is_active(vacancy.getIs_active())
                .build();

    }
    @Override
    public String updateVacancy(VacancyDto vacancyDto) {
        Vacancies existingVacancy = vacanciesRepository.findById(vacancyDto.getId())
                .orElseThrow(() -> new RuntimeException("Vacancy not found"));
        existingVacancy.setName(vacancyDto.getName());
        existingVacancy.setDescription(vacancyDto.getDescription());
        existingVacancy.setSalary(vacancyDto.getSalary());
        existingVacancy.setExp_from(vacancyDto.getExp_from());
        existingVacancy.setExp_to(vacancyDto.getExp_to());
        existingVacancy.setUpdate_time(LocalDateTime.now());
        existingVacancy.setIs_active(vacancyDto.getIs_active());

        vacanciesRepository.save(existingVacancy);

        return "/success";
    }

    private String getString(VacancyDto vacancyDto, Users user, Vacancies vacancies) {
        vacancies.setName(vacancyDto.getName());
        vacancies.setCategory_id(vacancies.getCategory_id());
        vacancies.setDescription(vacancyDto.getDescription());
        vacancies.setSalary(vacancyDto.getSalary());
        vacancies.setExp_from(vacancyDto.getExp_from());
        vacancies.setExp_to(vacancyDto.getExp_to());
        vacancies.setAuthor(user);
        vacancies.setCreated_date(LocalDateTime.now());
        vacancies.setUpdate_time(LocalDateTime.now());
        vacancies.setIs_active(vacancyDto.getIs_active());
        vacanciesRepository.save(vacancies);
        return "/success";
    }
@Override
public Page<Vacancies> getVacancies(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return vacanciesRepository.findAll(pageable);
    }


}
