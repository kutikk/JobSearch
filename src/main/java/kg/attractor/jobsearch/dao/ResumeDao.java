package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
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
     public Optional<Resumes> getResumeById(int  resume_id){
       String sql = "select * from resumes where id like ? LIMIT 1";
       Resumes resumes = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Resumes.class),resume_id);
       return Optional.ofNullable(resumes);
    }
    public void updateResume(Resumes resumes) {
        String sql = "UPDATE resumes SET name = ?, category_id = ?, salary = ?, is_active = ?, applicant_id = ? WHERE id = ?;\n";
        jdbcTemplate.update(sql,
                resumes.getName(),
                resumes.getCategoryId(),
                resumes.getSalary(),
                resumes.isIs_active(),
                resumes.getApplicant_id(),
                resumes.getId());
    }

    public void save(Resumes resume) {
        String sql = "INSERT INTO resumes (name, category_id, salary, is_active, created_date, update_time, applicant_id) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                resume.getName(),
                resume.getCategoryId(),
                resume.getSalary(),
                resume.isIs_active(),
                resume.getCreated_date(),
                resume.getUpdate_time(),
                resume.getApplicant_id());
    }





}
