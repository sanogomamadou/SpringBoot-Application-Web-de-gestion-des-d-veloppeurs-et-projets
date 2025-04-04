package ma.ac.uir.tp7.service;
import java.util.List;
import java.util.Optional;

import ma.ac.uir.tp7.entity.Assignment;

public interface AssignmentService {
    public List<Assignment> findAll();
    public Assignment save(Assignment assignment);
    public void deleteById(Long id);
}
