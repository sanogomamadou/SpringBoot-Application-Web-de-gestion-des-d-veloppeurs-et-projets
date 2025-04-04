package ma.ac.uir.tp7.service;
import java.util.List;
import java.util.Optional;

import ma.ac.uir.tp7.entity.Developer;
public interface DeveloperService {
    public List<Developer> getAllDevelopers();
    public Optional<Developer> getDeveloperByLogin(String login);
    Developer findById(Long id);
    Developer findByLogin(String login);
    List<Developer> findByRole(Developer.Role role);
    void deleteById(Long id);
    public Developer save(Developer developer);
}
