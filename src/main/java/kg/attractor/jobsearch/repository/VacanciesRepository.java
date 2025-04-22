package kg.attractor.jobsearch.repository;

import kg.attractor.jobsearch.models.Vacancies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacanciesRepository extends JpaRepository<Vacancies , Integer> {
    Page<Vacancies> findAllByAuthorEmail(String authorId,Pageable pageable);
}
