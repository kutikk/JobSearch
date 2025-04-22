package kg.attractor.jobsearch.repository;

import kg.attractor.jobsearch.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role  findByRoleName(String roleName);
}
