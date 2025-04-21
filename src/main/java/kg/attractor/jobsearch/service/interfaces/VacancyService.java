package kg.attractor.jobsearch.service.interfaces;

import kg.attractor.jobsearch.dto.VacancyDto;
import kg.attractor.jobsearch.models.Vacancies;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VacancyService {

    List<VacancyDto> getVacancyByApplicant(int applicant_id);

    List<VacancyDto> getAllVacancies();

    List<VacancyDto> getVacancyByCategory(int categoryID);

    String createVacancy(VacancyDto vacancyDto);

    VacancyDto getVacancyById(Integer id);

    String  updateVacancy(VacancyDto vacancyDto);

    Page<Vacancies> getVacancies(int page, int size);
}
