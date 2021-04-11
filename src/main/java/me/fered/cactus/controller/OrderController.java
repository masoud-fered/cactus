package me.fered.cactus.controller;

import com.google.gson.Gson;
import me.fered.cactus.dao.OrderDao;
import me.fered.cactus.entity.Orderr;

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
@WebServlet("/api/v1/order/*")
public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final OrderDao orderDao = new OrderDao();
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

                Orderr orderr = orderDao.read(id);
                gson.toJson(orderr, printWriter);
            } else {
                List<Orderr> orderrs = orderDao.readAll();
                gson.toJson(orderrs, printWriter);
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
            String coffeeId = request.getParameter("coffeeId");
            String tableId = request.getParameter("tableId");

            Orderr orderr = new Orderr(Integer.parseInt(coffeeId), Integer.parseInt(tableId));
            orderr = orderDao.create(orderr);

            gson.toJson(orderr, printWriter);

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
            String pathInfo = request.getPathInfo();
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length > 1) {
                long id = Long.parseLong(pathParts[1]);
                Orderr orderr = orderDao.read(id);

                String stringPaid = request.getParameter("paid");
                boolean paid = false;
                if (stringPaid != null) {
                    int integerPaid = Integer.parseInt(stringPaid);
                    paid = integerPaid > 0;
                    orderr.setPaid(paid);

                }

                String stringDelivered = request.getParameter("delivered");
                boolean delivered = false;
                if (stringDelivered != null) {
                    int integerDelivered = Integer.parseInt(stringDelivered);
                    delivered = integerDelivered > 0;
                    orderr.setDelivered(delivered);
                }

                orderr = orderDao.update(orderr);

                gson.toJson(orderr, printWriter);
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

                Orderr orderr = orderDao.read(id);
                orderr.setRemoved(true);

                orderr = orderDao.update(orderr);

                gson.toJson(orderr, printWriter);
            }

        } catch (Throwable throwable) {
            response.setStatus(500);
            printWriter = response.getWriter();
            printWriter.write("{\"error\":\"" + throwable.getLocalizedMessage() + "\"}");
        }
    }
}