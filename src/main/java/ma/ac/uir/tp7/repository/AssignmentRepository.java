package ma.ac.uir.tp7.repository;

import ma.ac.uir.tp7.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
