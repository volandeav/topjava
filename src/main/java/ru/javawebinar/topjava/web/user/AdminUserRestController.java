package ru.javawebinar.topjava.web.user;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.web.meal.UserMealRestController;

import java.util.Collection;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class AdminUserRestController {
    private UserService service;
    private static final Logger log = getLogger( AdminUserRestController.class);

    public AdminUserRestController(UserService service) {
        this.service = service;
    }

    public User save(User user) {
        return service.save(user);
    }

    public void delete(Integer id) throws NotFoundException {
        service.delete(id);
    }

    public User get(Integer id) throws NotFoundException {
        return service.get(id);
    }

    public User getByEmail(String email) throws NotFoundException {
        return service.getByEmail(email);
    }

    public Collection<User> getAll() {
        return service.getAll();
    }

    public void update(User user) throws NotFoundException {
        service.update(user);
    }
}
