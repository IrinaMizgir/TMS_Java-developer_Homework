package by.tms.lesson25;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

/**
 * @author Ирина Мизгир
 * @date 06.06.2026 16:01
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {

    private final List<String> books = List.of("Bone.txt", "Lion_and_Dog.txt");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bookName = books.get(new Random().nextInt(books.size()));
        try (InputStream is = getServletContext().getResourceAsStream("WEB-INF/" + bookName)) {
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment; filename=" + bookName);
            try (OutputStream os = resp.getOutputStream()) {
               is.transferTo(os);
            }
        }
    }
}
