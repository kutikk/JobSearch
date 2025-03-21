package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class ResumeDao {
    private final JdbcTemplate jdbcTemplate;


   public List<Resumes> getResumes(int applicant_id){
       String sql = "select * from resumes where applicant_id like ?";
       return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Resumes.class),applicant_id);
   }
    public Optional<Resumes> getResumeByCategory(int category_id){
        String sql = "select * from resumes where category_id like ? LIMIT 1";
        Resumes resumes = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Resumes.class),category_id);
        return Optional.ofNullable(resumes);
    }
    public Optional<Resumes> getResumeByApplicant(int applicant_id){
        String sql = "select * from resumes where applicant_id like ? LIMIT 1";
        Resumes resumes = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Resumes.class),applicant_id);
        return Optional.ofNullable(resumes);
    }
}
