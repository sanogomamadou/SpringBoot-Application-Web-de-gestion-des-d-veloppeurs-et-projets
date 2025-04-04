package ma.ac.uir.tp7.service;
import java.util.List;
import java.util.Optional;

import ma.ac.uir.tp7.entity.Evaluation;

public interface EvaluationService {
    public List<Evaluation> findAll();
    public Evaluation save(Evaluation assignment);
    public void deleteById(Long id);
}
