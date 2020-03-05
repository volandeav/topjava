package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Role;

import java.util.Collections;
import java.util.Set;

import static ru.javawebinar.topjava.repository.mock.InMemoryUserRepository.USER_ID;

public class LoggedUser {
    protected int id=USER_ID;
    protected Set<Role> roles = Collections.singleton(Role.ROLE_USER);
    protected boolean enabeled = true;

    private static LoggedUser LOGGED_USER=new LoggedUser();

    public static LoggedUser get(){return LOGGED_USER;}
    public static int id(){return get().id;}
    public Set<Role> getAuthorities(){return roles;}
    public boolean isEnabeled(){return enabeled;}

}
