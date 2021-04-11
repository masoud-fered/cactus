package me.fered.cactus.controller;

import com.google.gson.Gson;
import me.fered.cactus.dao.TableDao;
import me.fered.cactus.entity.CoffeeTable;

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
@WebServlet("/api/v1/table/*")
public class TableController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final TableDao tableDao = new TableDao();
    private final Gson gson = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();

        try {
            String pathInfo = request.getPathInfo();
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length > 1) {
                long id = Long.parseLong(pathParts[1]);

                CoffeeTable table = tableDao.read(id);
                gson.toJson(table, printWriter);
            } else {
                List<CoffeeTable> tables = tableDao.readAll();
                gson.toJson(tables, printWriter);
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
            String chairCount = request.getParameter("chairCount");
            int integerVIP = Integer.parseInt(request.getParameter("VIP"));
            boolean VIP = integerVIP > 0;

            CoffeeTable table = new CoffeeTable(Integer.parseInt(chairCount), VIP);
            table = tableDao.create(table);

            gson.toJson(table, printWriter);

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
            String chairCount = request.getParameter("chairCount");
            int integerVIP = Integer.parseInt(request.getParameter("VIP"));
            boolean VIP = integerVIP > 0;
            String pathInfo = request.getPathInfo();
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length > 1) {
                long id = Long.parseLong(pathParts[1]);

                CoffeeTable table = tableDao.read(id);
                table.setChairCount(Integer.parseInt(chairCount));
                table.setVIP(VIP);

                table = tableDao.update(table);

                gson.toJson(table, printWriter);
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

                CoffeeTable table = tableDao.read(id);
                table.setRemoved(true);

                table = tableDao.update(table);

                gson.toJson(table, printWriter);
            }

        } catch (Throwable throwable) {
            response.setStatus(500);
            printWriter = response.getWriter();
            printWriter.write("{\"error\":\"" + throwable.getLocalizedMessage() + "\"}");
        }
    }
}