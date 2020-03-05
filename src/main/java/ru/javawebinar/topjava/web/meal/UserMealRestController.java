package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

import static org.slf4j.LoggerFactory.getLogger;

public class UserMealRestController {
    private static final Logger log = getLogger( UserMealRestController.class);
    private UserMealService service;

    public UserMealRestController(UserMealService service) {
        this.service = service;
    }

    public UserMeal save(UserMeal userMeal) {
        return service.save(userMeal);
    }

    public void delete(Integer id) throws NotFoundException {
        service.delete(id);
    }

    public UserMeal get(Integer id) throws NotFoundException {
        return service.get(id);
    }

    public Collection<UserMeal> getAll() {
        return service.getAll();
    }

    public void update(UserMeal userMeal) throws NotFoundException {
        service.update(userMeal);
    }
}
