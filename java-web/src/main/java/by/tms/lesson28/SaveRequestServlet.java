package by.tms.lesson28;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/save-request") //http://localhost:8080/save-request
public class SaveRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirectToSaveRequest(req, resp);
    }

    private void redirectToSaveRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/save-request.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String text = req.getParameter("text");
        if (email == null || text == null || email.isEmpty() || text.isEmpty()) {
            req.setAttribute("message", "Заполните все поля");
            redirectToSaveRequest(req, resp);
        } else {
            req.setAttribute("email", email);
            req.setAttribute("text", text);
            getServletContext().getRequestDispatcher("/pages/order-accept.jsp").forward(req, resp);
        }
    }
}
