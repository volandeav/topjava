package ru.javawebinar.topjava.web.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.web.user.AdminUserRestController;

import java.util.Collections;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminSpringMockTest {
    @Autowired
    private AdminUserRestController controller;
    @Test
    public void testCreate() throws Exception{
        controller.save(new User(null,"user","user@mail.ru","user_password",  Collections.singleton(Role.ROLE_USER)));
    }

    @Test
    public void  testDelete() throws Exception{
        controller.delete(7);
    }

    @Test
    public void  testDeleteNotFound() throws Exception{
        controller.delete(0);
    }
}
