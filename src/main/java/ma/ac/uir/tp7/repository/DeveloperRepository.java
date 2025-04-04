package ma.ac.uir.tp7.repository;

import ma.ac.uir.tp7.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Optional<Developer> findByLogin(String login);
    List<Developer> findByRole(Developer.Role role);
    Developer save(Developer developer);
}
