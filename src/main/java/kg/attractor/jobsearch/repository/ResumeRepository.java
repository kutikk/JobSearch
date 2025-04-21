package kg.attractor.jobsearch.repository;

import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeRepository extends JpaRepository <Resumes, Long> {
    Resumes  getResumeByCategoryId(String categoryID);
    Resumes getResumeByApplicantEmail(String applicant_id);
    @Query("SELECT r FROM Resumes r WHERE r.applicant.email = :email")
    Page<Resumes> findByApplicantEmail(@Param("email") String email, Pageable pageable);
    Resumes getResumeByName(@Param("name") String name);
}
