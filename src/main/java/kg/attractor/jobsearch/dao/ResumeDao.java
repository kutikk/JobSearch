package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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



   public List<Resumes> getResumes(Long applicant_id){
       String sql = "select * from resumes where applicant_id like ?";
       return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Resumes.class),applicant_id);
   }
    public Optional<Resumes> getResumeByCategory(Long category_id){
        String sql = "select * from resumes where category_id like ? LIMIT 1";
        Resumes resumes = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Resumes.class),category_id);
        return Optional.ofNullable(resumes);
    }
    public Optional<Resumes> getResumeByApplicant(Long applicant_id){
        String sql = "select * from resumes where applicant_id like ? LIMIT 1";
        Resumes resumes = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Resumes.class),applicant_id);
        return Optional.ofNullable(resumes);
    }
     public Optional<Resumes> getResumeById(Long  resume_id){
       String sql = "select * from resumes where id like ? ";
         try {
             Resumes resumes = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Resumes.class),resume_id);
             return Optional.ofNullable(resumes);
         } catch (EmptyResultDataAccessException e) {
             return Optional.empty();
         }
    }
    public void updateResume(Resumes resumes) {
        String sql = "UPDATE resumes SET name = ?, category_id = ?, salary = ?, is_active = ?, applicant_id = ? WHERE id = ?;\n";
        jdbcTemplate.update(sql,
                resumes.getName(),
                resumes.getCategoryId(),
                resumes.getSalary(),
                resumes.is_active(),
                resumes.getApplicant(),
                resumes.getId());
    }

    public void save(Resumes resume) {
        String sql = "INSERT INTO resumes (name, category_id, salary, is_active, created_date, update_time, applicant_id) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                resume.getName(),
                resume.getCategoryId(),
                resume.getSalary(),
                resume.is_active(),
                resume.getCreated_date(),
                resume.getUpdate_time(),
                resume.getApplicant());
    }

    public void deleteResumeById(Long resume_id){
       String sql = "delete from resumes where id = ?";
       jdbcTemplate.update(sql,resume_id);
    }

    public List<Resumes> getAllResumes(){
       String sql = "select * from resumes";
       return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Resumes.class));
    }

    public List<Resumes> getAllResumesByApplicantId(long applicant_id){
       String sql = "select * from resumes where applicant_id like ? ";
       return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Resumes.class),applicant_id);
    }

    public Long getResumeIDByName(String name) {
        String sql = "SELECT id FROM resumes WHERE name = ?";
        List<Long> result = jdbcTemplate.queryForList(sql, new Object[]{name}, Long.class);

        if (result.size() == 1) {
            return result.get(0);
        } else {
            return null;
        }
    }

}
