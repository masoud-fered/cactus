package me.fered.cactus.controller;

import com.google.gson.Gson;
import me.fered.cactus.dao.CoffeeDao;
import me.fered.cactus.entity.Coffee;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@MultipartConfig
@WebServlet("/api/v1/coffee/*")
public class CoffeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CoffeeDao coffeeDao = new CoffeeDao();
    private final Gson gson = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();

        try {
            String pathInfo = request.getPathInfo();
            String[] pathParts = pathInfo.split("/");

            log(coffeeDao.getCount() + "Get Alllllllllllllllllllllllllllllllllllllll");

            if (pathParts.length > 1) {
                long id = Long.parseLong(pathParts[1]);

                Coffee coffee = coffeeDao.read(id);
                gson.toJson(coffee, printWriter);
            } else {
                List<Coffee> coffees = coffeeDao.readAll();
                gson.toJson(coffees, printWriter);
            }

        } catch (Throwable throwable) {
            response.setStatus(500);
            printWriter = response.getWriter();
            printWriter.write("{\"error\":\"" + throwable.getLocalizedMessage() + "\"}");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();

        try {
            String name = request.getParameter("name");
            String price = request.getParameter("price");

            Coffee coffee = new Coffee(name, Integer.parseInt(price));
            coffee = coffeeDao.create(coffee);

            gson.toJson(coffee, printWriter);

        } catch (Throwable throwable) {
            response.setStatus(500);
            printWriter = response.getWriter();
            printWriter.write("{\"error\":\"" + throwable.getLocalizedMessage() + "\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();

        try {
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String pathInfo = request.getPathInfo();
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length > 1) {
                long id = Long.parseLong(pathParts[1]);

                Coffee coffee = coffeeDao.read(id);
                coffee.setName(name);
                coffee.setPrice(Integer.parseInt(price));

                coffee = coffeeDao.update(coffee);

                gson.toJson(coffee, printWriter);
            }

        } catch (Throwable throwable) {
            response.setStatus(500);
            printWriter = response.getWriter();
            printWriter.write("{\"error\":\"" + throwable.getLocalizedMessage() + "\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();

        try {
            String pathInfo = request.getPathInfo();
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length > 1) {
                long id = Long.parseLong(pathParts[1]);

                Coffee coffee = coffeeDao.read(id);
                coffee.setRemoved(true);

                coffee = coffeeDao.update(coffee);

                gson.toJson(coffee, printWriter);
            }

        } catch (Throwable throwable) {
            response.setStatus(500);
            printWriter = response.getWriter();
            printWriter.write("{\"error\":\"" + throwable.getLocalizedMessage() + "\"}");
        }
    }
}