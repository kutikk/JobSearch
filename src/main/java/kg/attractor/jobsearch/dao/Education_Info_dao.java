package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.dto.Education_InfoDto;
import kg.attractor.jobsearch.models.Education_Info;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Education_Info_dao {
    private final JdbcTemplate jdbcTemplate;


   public List<Education_InfoDto> getEducation_Info_ByResumeId(Long resume_id) {
       String sql = "SELECT * FROM education_info WHERE resume_id = ?;";
     return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Education_InfoDto.class),resume_id);

   }
    public String getProgramName(Long resume_id, String program_name) {
        String sql = "SELECT program FROM education_info WHERE resume_id = ? AND program = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, resume_id, program_name);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return "";
        }
    }

    public void saveEducation_Info(List<Education_InfoDto> list,Long resume_id) {
        String sql = "INSERT INTO education_info (institution,program,start_date,end_date,degree,resume_id)"+ "VALUES (?, ?, ?, ?, ?,?)";
        for (Education_InfoDto education_InfoDto : list) {
         if (education_InfoDto.getInstitution() != null && !getProgramName(resume_id,education_InfoDto.getProgram()).equalsIgnoreCase(education_InfoDto.getProgram())) {
             jdbcTemplate.update(sql,
                     education_InfoDto.getInstitution(),
                     education_InfoDto.getProgram(),
                     education_InfoDto.getStart_date(),
                     education_InfoDto.getEnd_date(),
                     education_InfoDto.getDegree(),
                     resume_id);
         }
         return;
        }
    }
}
