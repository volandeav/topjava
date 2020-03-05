package ru.javawebinar.topjava.web.mock;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.web.user.AdminUserRestController;

import java.util.Collections;

public class UserAdminMockTest {
    private static ConfigurableApplicationContext applicationContext;
    private static AdminUserRestController controller;

    @Test
    public void testCreate() throws Exception{
        controller.save(new User(null,"user","user@mail.ru","user_password", Collections.singleton(Role.ROLE_USER)));
    }
}
