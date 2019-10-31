package HomeTasks.HomeTaskEleventh.servlets;

import HomeTasks.HomeTaskEleventh.dao.User;
import HomeTasks.HomeTaskEleventh.dao.UserDaoInit;
import HomeTasks.HomeTaskEleventh.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static HomeTasks.HomeTaskEleventh.service.Service.getUserForReq;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
    private static final Service service = new Service(new UserDaoInit());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            User user = getUserForReq(req);
            Service.insertUser(user);

            req.setAttribute("newUser","Congratulations new User!!!");


        }catch (IllegalArgumentException e){
            req.setAttribute("errorMessage","Error:"+e.toString().split(": ")[1]+"!!!");


        }finally {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);


        }


    }


}
