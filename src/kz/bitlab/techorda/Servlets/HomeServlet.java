package kz.bitlab.techorda.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.Tasks;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ArrayList<Tasks> tasks = DBConnection.getTasks();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
