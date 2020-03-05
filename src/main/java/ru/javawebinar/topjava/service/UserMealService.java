package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

public interface UserMealService {
    public UserMeal save(UserMeal userMeal);
    public void delete (Integer id) throws NotFoundException;
    public UserMeal get(Integer id) throws NotFoundException;
    public Collection<UserMeal> getAll();
    public void update(UserMeal userMeal) throws NotFoundException;
}
