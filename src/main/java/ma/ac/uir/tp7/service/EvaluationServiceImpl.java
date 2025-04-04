package ma.ac.uir.tp7.service;
import java.util.List;
import ma.ac.uir.tp7.entity.Evaluation;
import ma.ac.uir.tp7.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Override
    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }
    @Override
    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }
    @Override
    public void deleteById(Long id) {
        evaluationRepository.deleteById(id);
    }

}