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

    public List<Work_Experience_Info_Dto> getWork_Experience_InfoByID(int resume_id) {
        String sql = "SELECT * FROM work_experience_info WHERE resume_id = ?;";
        return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Work_Experience_Info_Dto.class),resume_id);

    }
    public void saveWorkExperienceInfo(List<Work_Experience_Info_Dto> list) {
        String sql = "INSERT INTO work_experience_info (years,company_name,position,responsibilities,resume_id)"+ "VALUES (?, ?, ?, ?,?)";
        for (Work_Experience_Info_Dto work_experience_info_dto: list) {
            jdbcTemplate.update(sql,work_experience_info_dto.getYears(),
                    work_experience_info_dto.getCompany_name(),
                    work_experience_info_dto.getPosition(),
                    work_experience_info_dto.getResponsibilities(),
                    work_experience_info_dto.getResume_id());
        }
    }
}
