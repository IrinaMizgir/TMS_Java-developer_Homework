package by.tms.lesson33.web;

import by.tms.lesson33.model.User;
import by.tms.lesson33.repository.UsersRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Ирина Мизгир
 * @date 27.06.2026 19:20
 */
@WebServlet("/get")
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = UsersRepository.getInstance().getById(id);
            resp.getWriter().println(user.toString());
        } catch (NumberFormatException exception) {
            resp.getWriter().println("Идентификатор не является числом");
        }

    }


}
