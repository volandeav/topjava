package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.mock.InMemoryUserMealRepository;
import ru.javawebinar.topjava.repository.mock.InMemoryUserRepository;
import ru.javawebinar.topjava.service.UserServiceImpl;
import ru.javawebinar.topjava.web.meal.UserMealRestController;
import ru.javawebinar.topjava.web.user.UserRestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.repository.mock.InMemoryUserRepository.ADMIN_ID;
import static ru.javawebinar.topjava.repository.mock.InMemoryUserRepository.USER_ID;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames())+"\n");
        InMemoryUserRepository inMemoryUserRepository = applicationContext.getBean(InMemoryUserRepository.class);
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        InMemoryUserMealRepository inMemoryUserMealRepository = applicationContext.getBean(InMemoryUserMealRepository.class);
        List userMealList = inMemoryUserMealRepository.getAll().stream().filter(userMeal -> userMeal.getUserId()==ADMIN_ID).collect(Collectors.toList());

        UserRestController userRestController = applicationContext.getBean(UserRestController.class);
        userRestController.update(new User(null,"user","user@mail.ru","user_password", Collections.singleton(Role.ROLE_USER)));
        userRestController.update(new User(null,"user","user@mail.ru","user_password", Collections.singleton(Role.ROLE_USER)));
        userRestController.update(new User(null,"user","user@mail.ru","user_password", Collections.singleton(Role.ROLE_USER)));

        UserMealRestController userMealRestControllerRestController = applicationContext.getBean(UserMealRestController.class);
        userMealRestControllerRestController.save(new UserMeal(null, LocalDateTime.of(2015, Month.MAY, 30, 15, 0),"еда нового 2",200,3));

        applicationContext.close();

    }
}
