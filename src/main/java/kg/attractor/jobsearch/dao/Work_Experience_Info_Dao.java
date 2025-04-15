package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.dto.Education_InfoDto;
import kg.attractor.jobsearch.dto.Work_Experience_Info_Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Work_Experience_Info_Dao {
    private final JdbcTemplate jdbcTemplate;

    public List<Work_Experience_Info_Dto> getWork_Experience_InfoByID(Long resume_id) {
        String sql = "SELECT * FROM work_experience_info WHERE resume_id = ?;";
        return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Work_Experience_Info_Dto.class),resume_id);

    }
    public String getCompany(Long resume_id,String company_name) {
        String sql = "SELECT company_name FROM work_experience_info WHERE resume_id = ?" +
                "and company_name = ?;";
        try {
            return jdbcTemplate.queryForObject(sql,String.class,resume_id,company_name);
        }catch (org.springframework.dao.EmptyResultDataAccessException e){
            return "";
        }
    }
    public void saveWorkExperienceInfo(List<Work_Experience_Info_Dto> list, Long resume_id) {
        String sql = "INSERT INTO work_experience_info (years,company_name,position,responsibilities,resume_id)"+ "VALUES (?, ?, ?, ?,?)";
        for (Work_Experience_Info_Dto work_experience_info_dto: list) {
            if (work_experience_info_dto.getYears() != null && !getCompany(resume_id,work_experience_info_dto.getCompany_name())
                    .equalsIgnoreCase(work_experience_info_dto.getCompany_name()) ) {
                jdbcTemplate.update(sql,work_experience_info_dto.getYears(),
                        work_experience_info_dto.getCompany_name(),
                        work_experience_info_dto.getPosition(),
                        work_experience_info_dto.getResponsibilities(),
                        resume_id);
            }
            else return ;

        }
    }
}
