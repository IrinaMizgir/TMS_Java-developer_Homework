package by.tms.lesson33.web;

import by.tms.lesson33.repository.UsersRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Ирина Мизгир
 * @date 27.06.2026 22:54
 */
@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean result = UsersRepository.getInstance().deleteById(id);
            if (result) {
                resp.getWriter().println("Пользователь успешно удален");
            } else {
                resp.getWriter().println("Пользователь не найден");
            }

        } catch (NumberFormatException exception) {
            resp.getWriter().println("Идентификатор не является числом");
        }
    }
}

