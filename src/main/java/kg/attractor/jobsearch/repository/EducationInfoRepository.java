package kg.attractor.jobsearch.repository;

import kg.attractor.jobsearch.models.Education_Info;
import kg.attractor.jobsearch.models.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationInfoRepository extends JpaRepository<Education_Info, Long> {
    List<Education_Info> findAllByResumeId(Long resumeId);

}
