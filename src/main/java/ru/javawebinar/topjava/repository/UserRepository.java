package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.User;

import java.util.Collection;
import java.util.Set;

public interface UserRepository {
    User save(User user);
    boolean delete(int id);
    User get(int id);
    User getByEmail(String email);
    Collection<User> getAll();
}
