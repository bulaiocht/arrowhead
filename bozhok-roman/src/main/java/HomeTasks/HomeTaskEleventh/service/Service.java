package HomeTasks.HomeTaskEleventh.service;

import HomeTasks.HomeTaskEleventh.dao.User;
import HomeTasks.HomeTaskEleventh.dao.UserDao;
import HomeTasks.HomeTaskEleventh.propertyLoader.PropertyLoader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Service {

    private static UserDao USER_DAO_INIT;

    public Service(UserDao userDao) {
        USER_DAO_INIT = userDao;
    }


    public static String getJSONResponse() {

        List<User> userList = USER_DAO_INIT.selectAll();
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            return objectMapper.writeValueAsString(userList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static int validAge(String age) {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    private static String validEmail(String email) {

        if (email != null && email.matches(PropertyLoader.REGEX_EMAIL)) {

            if (USER_DAO_INIT.selectType1WhereHaveType2(email)) {
                throw new IllegalArgumentException("Email is used");
            }

            return email;

        }

        throw new IllegalArgumentException("Invalid email");

    }

    public static User getUserForReq(HttpServletRequest req) {

        return User
                .newBuilder()
                .setFirstName(req.getParameter("firstName"))
                .setSecondName(req.getParameter("secondName"))
                .setAge(validAge(req.getParameter("age")))
                .setEmail(validEmail(req.getParameter("email")))
                .setPassword(req.getParameter("password"))
                .build();
    }

    public static void insertUser(User user) {

        USER_DAO_INIT.insert(user);
    }
}
