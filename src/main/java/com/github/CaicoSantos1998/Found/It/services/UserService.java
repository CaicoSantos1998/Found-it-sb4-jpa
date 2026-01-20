package com.github.CaicoSantos1998.Found.It.services;

import com.github.CaicoSantos1998.Found.It.entities.User;
import com.github.CaicoSantos1998.Found.It.repositories.UserRepository;
import com.github.CaicoSantos1998.Found.It.resources.exceptions.DatabaseException;
import com.github.CaicoSantos1998.Found.It.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insertUser(User obj) {
        return repository.save(obj);
    }

    public void deleteUser(Long id) {
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        try {
            repository.deleteById(id);
            repository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
        repository.deleteById(id);
    }

    public User updateUser(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
