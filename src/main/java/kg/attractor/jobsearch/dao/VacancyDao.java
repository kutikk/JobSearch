package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.models.Responded_Applicants;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.models.Vacancies;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Vacancies> getVacancyRespondedApplicant(int applicant_id){
        String sql = "SELECT v.*\n" +
                "FROM vacancies v\n" +
                "JOIN responded_applicants ra ON v.id = ra.vacancy_id\n" +
                "JOIN resumes r ON ra.resume_id = r.id\n" +
                "WHERE r.applicant_id = ?;\n";
       return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Vacancies.class),applicant_id);
    }
    public List<Vacancies> getAllVacancies(){
        String sql = "select * from vacancies";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Vacancies.class));
    }
    public List<Vacancies> getVacanciesByCategory(int categoryID){
        String sql = "select * from vacancies where category_id = ?;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Vacancies.class),categoryID);
    }
    public Long getVacancyIdByName(String name) {
        String sql = "SELECT id FROM vacancies WHERE name = ?";
        List<Long> result = jdbcTemplate.queryForList(sql, new Object[]{name}, Long.class);

        if (result.size() == 1) {
            return result.get(0);
        } else {
            return null;
        }
    }



}
