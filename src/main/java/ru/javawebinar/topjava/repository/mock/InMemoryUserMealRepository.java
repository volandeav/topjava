package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.repository.mock.InMemoryUserRepository.ADMIN_ID;
import static ru.javawebinar.topjava.repository.mock.InMemoryUserRepository.USER_ID;

@Repository
public class InMemoryUserMealRepository implements UserMealRepository {
    private static final Logger log = getLogger( InMemoryUserRepository.class);
    public static final Comparator<UserMeal> USER_MEAL_COMPARATOR = (um1,um2)->um1.getDateTime().compareTo(um2.getDateTime());
    private Map<Integer, UserMeal> repository=new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    {
        this.save(new UserMeal(null, LocalDateTime.of(2015, Month.MAY, 30, 10, 0),"meal1",100,USER_ID));
        this.save(new UserMeal(null, LocalDateTime.of(2015, Month.MAY, 30, 15, 0),"meal2",100,USER_ID));
        this.save(new UserMeal(null, LocalDateTime.of(2015, Month.MAY, 30, 21, 0),"meal3",100,USER_ID));
        this.save(new UserMeal(null, LocalDateTime.of(2015, Month.MAY, 31, 10, 0),"еда 1",100,USER_ID));
        this.save(new UserMeal(null, LocalDateTime.of(2015, Month.MAY, 31, 15, 0),"еда 2",200,USER_ID));
        this.save(new UserMeal(null, LocalDateTime.of(2015, Month.MAY, 31, 21, 0),"еда 3",300,USER_ID));

        this.save(new UserMeal(null, LocalDateTime.of(2015, Month.MAY, 30, 15, 0),"еда админа 2",200,ADMIN_ID));
        this.save(new UserMeal(null, LocalDateTime.of(2015, Month.MAY, 31, 21, 0),"еда админа 3",300,ADMIN_ID));

    }


    @Override
    public UserMeal save(UserMeal userMeal) {
        if (userMeal.isNew()){
            userMeal.setId(counter.incrementAndGet());
        }
        return repository.put(userMeal.getId(),userMeal);
    }

    @Override
    public boolean delete(Integer id) {
        return repository.remove(id)!=null;
    }

    @Override
    public UserMeal get(Integer id) {
        return repository.get(id);
    }

    @Override
    public Collection<UserMeal> getAll() {
        return repository.values().stream().sorted(USER_MEAL_COMPARATOR).collect(Collectors.toList());
    }
}
