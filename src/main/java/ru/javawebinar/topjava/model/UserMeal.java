package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserMeal extends AbstractBaseEntity {
    private LocalDateTime dateTime;
    private String description;
    private Integer calories;
    private Integer userId;

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories,Integer userId) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.userId=userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getDate(){
        return dateTime.toLocalDate();
    }
}
