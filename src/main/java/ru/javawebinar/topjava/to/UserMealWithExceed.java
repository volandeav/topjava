package ru.javawebinar.topjava.to;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;

public class UserMealWithExceed extends UserMeal {
    private boolean exceeded;
    public UserMealWithExceed(Integer id, LocalDateTime dateTime, String description, int calories, Integer userId, boolean exceeded) {
        super(id, dateTime, description, calories, userId);
        this.exceeded=exceeded;
    }

    public boolean isExceeded() {
        return exceeded;
    }

    public void setExceeded(boolean exceeded) {
        this.exceeded = exceeded;
    }
}
