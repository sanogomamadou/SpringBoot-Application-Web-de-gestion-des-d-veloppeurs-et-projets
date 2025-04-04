package ma.ac.uir.tp7.service;

import ma.ac.uir.tp7.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public List<Project> findAll();
    public Project findById(Long id);
    void deleteById(Long id);
    public Project save(Project project);
}
