package pl.edu.pja.s27591.tpo04blog.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s27591.tpo04blog.entities.Role;
import pl.edu.pja.s27591.tpo04blog.repositories.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    public void deleteRole(Long articleId) {
        if (roleRepository.existsById(articleId)) {
            roleRepository.deleteById(articleId);
        } else {
            throw new EntityNotFoundException("There is no such role is our database;(");
        }
    }

    public void viewRoles() {
        for(Role r : roleRepository.findAll()){
            System.out.println(r);
        }
    }
}
