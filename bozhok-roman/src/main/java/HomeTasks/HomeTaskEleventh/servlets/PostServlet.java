package HomeTasks.HomeTaskEleventh.servlets;

import HomeTasks.HomeTaskEleventh.dao.DataBase;
import HomeTasks.HomeTaskEleventh.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>HTML Forms</h2>\n" +
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



         User user = User
                 .newBuilder()
                 .setFirstName(req.getParameter("firstName"))
                 .setSecondName(req.getParameter("secondName"))
                 .setAge(Integer.parseInt(req.getParameter("age")))
                 .setEmail(req.getParameter("email"))
                 .setPassword(req.getParameter("password"))
                 .build();


        System.out.println(user);

        DataBase.addUser(user);
        PrintWriter writer = resp.getWriter();



        writer.write(user.toString());
        writer.flush();
        writer.close();



    }
}
