package HomeTasks.HomeTaskEleventh.servlets;

import HomeTasks.HomeTaskEleventh.dao.User;
import HomeTasks.HomeTaskEleventh.dao.UserDaoInit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class LoginServlet extends HttpServlet {
    private static final UserDaoInit USER_DAO_INIT = new UserDaoInit();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Login form</h2>\n" +
                "\n" +
                "<form method=\"post\" >\n" +
                "  First name:<br>\n" +
                "  <input type=\"text\" name=\"firstName\" >\n" +
                "  <br>\n" +
                "  Second name:<br>\n" +
                "  <input type=\"text\" name=\"secondName\" >\n" +
                "  <br>\n" +
                "  Age:<br>\n" +
                "  <input type=\"text\" name=\"age\" >\n" +
                "  <br>\n" +
                "  Email:<br>\n" +
                "  <input type=\"text\" name=\"email\" >\n" +
                "  <br>\n" +
                "  Password:<br>\n" +
                "  <input type=\"password\" name=\"password\" >\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        try {
            User user = getUserForReq(req);
//            System.out.println(user);

            USER_DAO_INIT.creatTableUser();
            USER_DAO_INIT.insertUser(user);
            writer.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h1>Congratulations new User!!!</h1>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
            writer.flush();



        }catch (IllegalArgumentException e){
            writer.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h1>Error:"+e.toString().split(": ")[1]+"!!!</h1>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
            writer.flush();

        }finally {
            writer.close();
        }










    }

    private User getUserForReq(HttpServletRequest req){
        boolean userByEmailPresent = USER_DAO_INIT
                .isUserByEmailPresent
                        (req.getParameter("email"));
        if (userByEmailPresent){
            throw new IllegalArgumentException("Email is used");
        }
        return User
                .newBuilder()
                .setFirstName(req.getParameter("firstName"))
                .setSecondName(req.getParameter("secondName"))
                .setAge(req.getParameter("age"))
                .setEmail(req.getParameter("email"))
                .setPassword(req.getParameter("password"))
                .build();
    }
}
