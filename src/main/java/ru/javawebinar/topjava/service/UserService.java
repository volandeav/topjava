package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

public interface UserService {
    public User save(User user);
    public void delete (Integer id) throws NotFoundException;
    public User get(Integer id) throws NotFoundException;
    public User getByEmail(String email) throws NotFoundException;
    public Collection<User> getAll();
    public void update(User user) throws NotFoundException;

}
