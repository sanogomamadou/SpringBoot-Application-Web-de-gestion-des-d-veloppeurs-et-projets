package ma.ac.uir.tp7.repository;


import ma.ac.uir.tp7.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
