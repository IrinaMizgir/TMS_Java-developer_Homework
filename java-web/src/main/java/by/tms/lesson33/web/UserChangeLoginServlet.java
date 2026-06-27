package by.tms.lesson33.web;

import by.tms.lesson33.model.User;
import by.tms.lesson33.repository.UsersRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Ирина Мизгир
 * @date 27.06.2026 23:18
 */
@WebServlet("/change-login")
public class UserChangeLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirectToChangeLogin(req, resp);

    }

    /**
     * Перенаправление на страницу изменения логина.
     *
     * @param req Запрос
     * @param resp Ответ
     * @throws ServletException Исключения при доступе к сервлету.
     * @throws IOException Исключения ввода/вывода
     */
    private void redirectToChangeLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/change-login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String email = req.getParameter("email");
        if (email == null || email.isEmpty()) {
            req.setAttribute("message", "Заполните все поля");
            redirectToChangeLogin(req, resp);
        } else {
            String id = req.getParameter("id");
            if (id == null || id.isEmpty()) {
                UsersRepository.getInstance().findUserIdByEmail(email)
                        .ifPresentOrElse(
                                userId -> req.setAttribute("id", userId),
                                () -> req.setAttribute("message", "Не найден пользователь по логину")
                        );
                redirectToChangeLogin(req, resp);
            } else {
                var user = new User();
                user.setEmail(email);
                user.setId(Integer.parseInt(id));
                UsersRepository.getInstance().updateLogin(user);
                resp.getWriter().println("Логин успешно обновлён");
            }

        }

    }

}
