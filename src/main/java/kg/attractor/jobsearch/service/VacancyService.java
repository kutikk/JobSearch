package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.dto.VacancyDto;

import java.util.List;

public interface VacancyService {

    List<VacancyDto> getVacancyByApplicant(int applicant_id);

    List<VacancyDto> getAllVacancies();

    List<VacancyDto> getVacancyByCategory(int categoryID);
}
