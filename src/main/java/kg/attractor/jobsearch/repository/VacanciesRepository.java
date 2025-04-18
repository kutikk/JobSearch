package kg.attractor.jobsearch.repository;

import kg.attractor.jobsearch.models.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacanciesRepository extends JpaRepository<Vacancies , Integer> {
    List<Vacancies> findAllByAuthor_Id(Long authorId);
}
