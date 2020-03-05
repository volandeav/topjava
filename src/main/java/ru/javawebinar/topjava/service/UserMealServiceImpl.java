package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

public class UserMealServiceImpl implements UserMealService {
    protected UserMealRepository repository;

    public UserMealServiceImpl(UserMealRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserMeal save(UserMeal userMeal) {
        repository.save(userMeal);
        return userMeal;
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        repository.delete(id);
    }


    @Override
    public UserMeal get(Integer id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public Collection<UserMeal> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(UserMeal userMeal) throws NotFoundException {
        repository.save(userMeal);
    }
}
