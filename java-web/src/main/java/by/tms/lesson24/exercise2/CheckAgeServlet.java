package by.tms.lesson24.exercise2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Ирина Мизгир
 * @date 06.06.2026 15:11
 */
@WebServlet ("/check-age")
public class CheckAgeServlet extends HttpServlet {

    @Override // http://localhost:8080/check-age?age=24
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String age = req.getParameter("age");
        if (age == null || age.isBlank()) {
            resp.getWriter().println("Не задан возраст");
            return;
        }
        try {
            if (Integer.parseInt(age) < 18) {
                resp.getWriter().println("Несовершеннолетний");
            }    else {
                resp.getWriter().println("Совершеннолетний");
            }
        } catch (NumberFormatException exception) {
            resp.getWriter().println("Возраст не является числом");
        }
    }
}
