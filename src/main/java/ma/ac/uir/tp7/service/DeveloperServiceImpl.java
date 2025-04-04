package ma.ac.uir.tp7.service;
import java.util.List;
import java.util.Optional;

import ma.ac.uir.tp7.entity.Developer;
import ma.ac.uir.tp7.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }
    @Override
    public Optional<Developer> getDeveloperByLogin(String login){
        return developerRepository.findByLogin(login);
    }
    @Override
    public Developer findById(Long id) {
        return developerRepository.findById(id).orElse(null);
    }
    @Override
    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }
    @Override
    public void deleteById(Long id) {
        this.developerRepository.deleteById(id);
    }
    @Override
    public List<Developer> findByRole(Developer.Role role) {
        return developerRepository.findByRole(role);}
    @Override
    public Developer findByLogin(String login){return developerRepository.findByLogin(login).orElse(null);}

}
