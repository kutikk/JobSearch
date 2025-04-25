package kg.attractor.jobsearch.repository;

import kg.attractor.jobsearch.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {
   Optional<Users>  findByEmail(String email);
}
