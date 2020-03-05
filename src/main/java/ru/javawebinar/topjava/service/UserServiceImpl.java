package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;
@Service
public class UserServiceImpl implements UserService {

    protected UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        repository.save(user);
        return null;
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public User get(Integer id) throws NotFoundException {
        return null;
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) throws NotFoundException {
        repository.save(user);
    }
}
