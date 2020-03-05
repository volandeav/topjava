package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;

import java.util.Collection;

public interface UserMealRepository {
    UserMeal save(UserMeal userMeal);
    boolean delete(Integer id);
    UserMeal get(Integer id);
    Collection<UserMeal> getAll();
}
