package HomeTasks.HomeTaskEleventh.servlets;


import HomeTasks.HomeTaskEleventh.dao.DataBase;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet
public class BasicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         PrintWriter writer = resp.getWriter();

         writer.write(DataBase.getUserList().toString());
         writer.flush();
         writer.close();
    }
}
