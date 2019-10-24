package HomeTasks.HomeTaskEleventh.servlets;

import HomeTasks.HomeTaskEleventh.dao.User;
import HomeTasks.HomeTaskEleventh.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static HomeTasks.HomeTaskEleventh.service.Service.getUserForReq;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        try {
            User user = getUserForReq(req);
            Service.insertUser(user);

            req.setAttribute("newUser","Congratulations new User!!!");


        }catch (IllegalArgumentException e){
            req.setAttribute("errorMessage","Error:"+e.toString().split(": ")[1]+"!!!");


        }finally {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

            writer.close();
        }


    }


}
