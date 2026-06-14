package by.tms.lesson24.exercise1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author Ирина Мизгир
 * @date 06.06.2026 14:20
 */
@WebServlet({"/beijing", "/washington"})
public class ZonedTimeServlet extends HttpServlet {

    private final Map<String, String> localeToTimeZoneMap = Map.of(
            "/minsk", "Europe/Minsk",
            "/beijing", "Asia/Shanghai",
            "/washington", "America/Los_Angeles"
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String dateTimeString = ZonedDateTime.now(ZoneId.of(localeToTimeZoneMap.get(req.getServletPath())))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

        resp.getWriter().println(dateTimeString);
    }
}
