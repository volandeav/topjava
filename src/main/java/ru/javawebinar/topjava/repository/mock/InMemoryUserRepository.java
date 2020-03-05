package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.web.MealServlet;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.slf4j.LoggerFactory.getLogger;
@Repository
public class InMemoryUserRepository implements UserRepository {
    private static final Logger log = getLogger( InMemoryUserRepository.class);
    private Map<Integer,User> repository=new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public static final int USER_ID=1;
    public static final int ADMIN_ID=2;
    {
        log.info("Init: InMemoryUserRepository");
        save(new User(USER_ID,"user","user@mail.ru","user_password",  Collections.singleton(Role.ROLE_USER)));
        save(new User(ADMIN_ID,"admin","admin@mail.ru","admin_password", Collections.singleton(Role.ROLE_ADMIN)));
    }
    @Override
    public User save(User user) {
        if (user.isNew()){
            user.setId(counter.incrementAndGet());
        }
        log.info("Saving user:"+user.toString());
        return repository.put(user.getId(),user);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id)!=null;
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return getAll().stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public Collection<User> getAll() {
        return repository.values();
    }
}
