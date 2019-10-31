package HomeTasks.HomeTaskEleventh.servlets;


import HomeTasks.HomeTaskEleventh.dao.UserDaoInit;
import HomeTasks.HomeTaskEleventh.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "GetAllUsersServlet",
        urlPatterns = {"/list"}
        )
public class GetAllUsersServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "application/json";
    private static final String CHARACTER_ENCODING ="UTF-8";
    private static final Service service = new Service(new UserDaoInit());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         PrintWriter writer = resp.getWriter();
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(CHARACTER_ENCODING);
         writer.write(Service.getJSONResponse());
         writer.flush();
         writer.close();
    }


}
