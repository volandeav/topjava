package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.meal.UserMealRestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends javax.servlet.http.HttpServlet  {
    private ConfigurableApplicationContext context;
    private UserMealRestController controller;
    private static final Logger log = getLogger( MealServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        context=new ClassPathXmlApplicationContext("spring/spring-app.xml");
        controller=context.getBean(UserMealRestController.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id=Objects.requireNonNull(request.getParameter("id"));
        UserMeal meal = new UserMeal(id.isEmpty()?null:Integer.valueOf(id),
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("calories")),1);
        controller.save(meal);
        response.sendRedirect("meals");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null) {
            //log.debug("MealServletRedirect");
            request.setAttribute("mealList", MealsUtil.getFilteredWithExceed(controller.getAll(), LocalTime.MIN, LocalTime.MAX, 2000));
            request.getRequestDispatcher("/UserMeals.jsp").forward(request, response);
        } else if (action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            controller.delete(id);
            response.sendRedirect("meals");
        } else {
            UserMeal meal = action.equals("create") ?
                    new UserMeal(null,LocalDateTime.now(),"",100,1)
                    :controller.get(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("/EditMeals.jsp").forward(request, response);
        }
    }
}
