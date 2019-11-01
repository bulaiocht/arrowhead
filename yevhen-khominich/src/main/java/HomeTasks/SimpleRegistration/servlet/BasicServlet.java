package HomeTasks.SimpleRegistration.servlet;

import HomeTasks.SimpleRegistration.DB.DAO.impl.UserDao;
import HomeTasks.SimpleRegistration.entity.User;
import HomeTasks.SimpleRegistration.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(
        name = "BasicServlet",
        urlPatterns = {"/api"}
)
public class BasicServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(BasicServlet.class);
    private Gson gson = new Gson();
    UserService userService = new UserService(new UserDao());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        final List<User> users = userService.getAll();
        final PrintWriter out = resp.getWriter();

        String responce = gson.toJson(users);
        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(responce);
        out.flush();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (userService.isUserWithEmail(req.getParameter("email"))) {
            try {throw new IllegalArgumentException("Already exist");}
            catch (IllegalArgumentException e){
                resp.getWriter().write("Email is already exist");
            }
        }

        User user = new User(req.getParameter("firstname"),
                req.getParameter("lastname"),
                req.getParameter("email"),
                req.getParameter("password"),
                Integer.parseInt(req.getParameter("age")));

        userService.saveUser(user);
        resp.getWriter().write("User is saved successfully");
        req.getRequestDispatcher("menu.html").forward(req, resp);

    }

}


