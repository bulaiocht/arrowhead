package HomeTask.EleventhTask.servlet;

import HomeTask.EleventhTask.srevice.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "userServlet",
        urlPatterns = "/user"
)
public class UserServlet extends HttpServlet {

    public static final String APPLICATION_JSON = "application/json";
    Service service = new Service();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(APPLICATION_JSON);
        PrintWriter writer = resp.getWriter();
        String userJson = service.getUserJson();
        writer.write(userJson);
        writer.flush();
        writer.close();
    }
}
