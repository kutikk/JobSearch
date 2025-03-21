package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.dao.VacancyDao;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.dto.VacancyDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Vacancies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyDao vacancyDao;
    @Override
    public List<VacancyDto> getVacancyByApplicant(int applicant_id){
        List<Vacancies> list = vacancyDao.getVacancyRespondedApplicant(applicant_id);
        return list.stream()
                .map(vacancies -> VacancyDto.builder()
                        .id(vacancies.getId())
                        .name(vacancies.getName())
                        .description(vacancies.getDescription())
                        .category_id(vacancies.getCategory_id())
                        .salary(vacancies.getSalary())
                        .exp_from(vacancies.getExp_from())
                        .exp_to(vacancies.getExp_to())
                        .is_active(vacancies.getIs_active())
                        .author_id(vacancies.getAuthor_id())
                        .created_date(vacancies.getCreated_date())
                        .update_time(vacancies.getUpdate_time())
                        .build())
                .toList();

    }
    @Override
    public List<VacancyDto> getAllVacancies(){
        List<Vacancies> list = vacancyDao.getAllVacancies();
        return list.stream()
                .map(vacancies -> VacancyDto.builder()
                        .id(vacancies.getId())
                        .name(vacancies.getName())
                        .description(vacancies.getDescription())
                        .category_id(vacancies.getCategory_id())
                        .salary(vacancies.getSalary())
                        .exp_from(vacancies.getExp_from())
                        .exp_to(vacancies.getExp_to())
                        .is_active(vacancies.getIs_active())
                        .author_id(vacancies.getAuthor_id())
                        .created_date(vacancies.getCreated_date())
                        .update_time(vacancies.getUpdate_time())
                        .build())
                .toList();

    }


    @Override
    public List<VacancyDto> getVacancyByCategory(int categoryID){
        List<Vacancies> list = vacancyDao.getVacanciesByCategory(categoryID);
        return list.stream()
                .map(vacancies -> VacancyDto.builder()
                        .id(vacancies.getId())
                        .name(vacancies.getName())
                        .description(vacancies.getDescription())
                        .category_id(vacancies.getCategory_id())
                        .salary(vacancies.getSalary())
                        .exp_from(vacancies.getExp_from())
                        .exp_to(vacancies.getExp_to())
                        .is_active(vacancies.getIs_active())
                        .author_id(vacancies.getAuthor_id())
                        .created_date(vacancies.getCreated_date())
                        .update_time(vacancies.getUpdate_time())
                        .build())
                .toList();

    }
}
