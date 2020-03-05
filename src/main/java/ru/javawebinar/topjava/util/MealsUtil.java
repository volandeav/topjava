package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class MealsUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 800;

    public static List<UserMealWithExceed> getFilteredWithExceed(Collection<UserMeal> mealList,LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = mealList.stream()
                .filter(ml-> !(ml.getDateTime().toLocalTime().isBefore(startTime)))
                .filter(ml-> !(ml.getDateTime().toLocalTime().isAfter(endTime)))
                .collect(Collectors.groupingBy(um->um.getDateTime().toLocalDate(),Collectors.summingInt(um->um.getCalories())));
        return mealList.stream()
                .filter(ml-> !(ml.getDateTime().toLocalTime().isBefore(startTime)))
                .filter(ml-> !(ml.getDateTime().toLocalTime().isAfter(endTime)))
                .map(ml->new UserMealWithExceed(ml.getId(),ml.getDateTime(),ml.getDescription(),ml.getCalories(),ml.getUserId(),caloriesSumByDate.get(ml.getDateTime().toLocalDate())>caloriesPerDay))
                .collect(Collectors.toList());

    }

}