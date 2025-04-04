package ma.ac.uir.tp7.service;
import java.util.List;
import ma.ac.uir.tp7.entity.Assignment;
import ma.ac.uir.tp7.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }
    @Override
    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }
    @Override
    public void deleteById(Long id) {
        this.assignmentRepository.deleteById(id);
    }

}