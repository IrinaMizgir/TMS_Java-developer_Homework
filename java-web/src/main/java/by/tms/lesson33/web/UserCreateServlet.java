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
 * @date 27.06.2026 20:43
 */
@WebServlet("/create")
public class UserCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirectToCreateUser(req, resp);
    }

    /**
     * Перенаправление на страницу создания пользователя.
     *
     * @param req Запрос
     * @param resp Ответ
     * @throws ServletException Исключения при доступе к сервлету.
     * @throws IOException Исключения ввода/вывода
     */
    private void redirectToCreateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/create-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        if (email == null || userName == null || email.isEmpty() || userName.isEmpty()) {
            req.setAttribute("message", "Заполните все поля");
            redirectToCreateUser(req, resp);
        } else {
            User user = new User();
            user.setUserName(userName);
            user.setEmail(email);
            UsersRepository.getInstance().save(user);
            req.setAttribute("userName", userName);
            req.setAttribute("email", email);
            getServletContext().getRequestDispatcher("/pages/user-save.jsp").forward(req, resp);
        }
    }
}
