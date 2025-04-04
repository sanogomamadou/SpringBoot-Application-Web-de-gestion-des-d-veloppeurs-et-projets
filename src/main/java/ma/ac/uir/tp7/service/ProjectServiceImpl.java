package ma.ac.uir.tp7.service;

import ma.ac.uir.tp7.entity.Project;
import ma.ac.uir.tp7.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
    @Override
    public void deleteById(Long id) {
        this.projectRepository.deleteById(id);
    }
}
