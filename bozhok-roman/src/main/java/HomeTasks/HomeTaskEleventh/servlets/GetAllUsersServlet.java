package HomeTasks.HomeTaskEleventh.servlets;


import HomeTasks.HomeTaskEleventh.dao.User;
import HomeTasks.HomeTaskEleventh.dao.UserDaoInit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet
public class GetAllUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
         writer.write(getJSONResponse());
         writer.flush();
         writer.close();
    }

    private String getJSONResponse (){
        StringBuilder sb = new StringBuilder();
        UserDaoInit userDaoInit = new UserDaoInit();
        List<User> userList = userDaoInit.selectAllUser();
        ObjectMapper objectMapper = new ObjectMapper();
        sb.append("[");
        userList.forEach(user -> {
            try {
                sb.append(objectMapper.writeValueAsString(user));
                sb.append(",");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");

        return sb.toString();

    }
}
