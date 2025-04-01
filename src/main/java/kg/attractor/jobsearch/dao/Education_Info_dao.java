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


   public List<Education_InfoDto> getEducation_Info_ByResumeId(int resume_id) {
       String sql = "SELECT * FROM education_info WHERE resume_id = ?;";
     return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Education_InfoDto.class),resume_id);

   }
    public void saveEducation_Info(List<Education_InfoDto> list) {
        String sql = "INSERT INTO education_info (institution,program,start_date,end_date,degree,resume_id)"+ "VALUES (?, ?, ?, ?, ?,?)";
        for (Education_InfoDto education_InfoDto : list) {
           jdbcTemplate.update(sql,education_InfoDto.getInstitution(),
                   education_InfoDto.getProgram(),
                   education_InfoDto.getStart_date(),
                   education_InfoDto.getEnd_date(),
                   education_InfoDto.getDegree(),
                   education_InfoDto.getResume_id());
        }
    }
}
