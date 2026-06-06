package by.tms.lesson24.exercise1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Ирина Мизгир
 * @date 06.06.2026 14:20
 */
@WebServlet("/washington")
public class WashingtonTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
     resp.getWriter().println(DateUtils.getDateStringByTimeZoneString("America/Los_Angeles"));

    }
}
