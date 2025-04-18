package kg.attractor.jobsearch.repository;

import kg.attractor.jobsearch.models.Resumes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository <Resumes, Long> {
}
