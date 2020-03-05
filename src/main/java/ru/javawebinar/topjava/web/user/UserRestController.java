package ru.javawebinar.topjava.web.user;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.web.MealServlet;

import java.util.Collection;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class UserRestController {

    private UserService service;
    private static final Logger log = getLogger( UserRestController.class);

    public UserRestController(UserService service) {
        this.service = service;
    }

    public User get(){
        Integer userID=LoggedUser.id();
        log.info("get "+userID);
        return service.get(userID);
    }

    public void delete() throws NotFoundException {
        Integer userID=LoggedUser.id();
        log.info("delete "+userID);
        service.delete(userID);
    }

    public void update(User user) throws NotFoundException {
        log.info("update "+user.getId());
        service.update(user);
    }
}
