package ma.ac.uir.tp7.repository;

import ma.ac.uir.tp7.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
