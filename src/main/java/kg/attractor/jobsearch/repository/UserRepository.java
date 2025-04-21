package kg.attractor.jobsearch.repository;

import kg.attractor.jobsearch.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<Users, String> {
}
