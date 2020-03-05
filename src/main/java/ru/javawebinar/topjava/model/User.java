package ru.javawebinar.topjava.model;

import java.util.Date;
import java.util.Set;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

public class User extends AbstractNamedEntity{
    private String email;
    private String password;
    private Set<Role> roles;


    public User(Integer id, String name, String email, String password, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public boolean isNew(){
        return id==null;
    }

    @Override
    public String toString() {
        return "User (" +
                "id=" + id +
                ", email=" + email +
                ", name=" + this.Name +
                ')';
    }

}
