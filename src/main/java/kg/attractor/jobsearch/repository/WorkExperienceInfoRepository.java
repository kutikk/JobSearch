package kg.attractor.jobsearch.repository;

import kg.attractor.jobsearch.models.Vacancies;
import kg.attractor.jobsearch.models.Work_Experience_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkExperienceInfoRepository extends
        JpaRepository<Work_Experience_Info, Long> {
    List<Work_Experience_Info> findAllByResumeId(Long resumeId);


}
