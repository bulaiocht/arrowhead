package HomeTasks.HomeTaskEleventh.service;

import HomeTasks.HomeTaskEleventh.dao.User;
import HomeTasks.HomeTaskEleventh.dao.UserDaoInit;
import HomeTasks.HomeTaskEleventh.propertyLoader.PropertyLoader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    private static final UserDaoInit USER_DAO_INIT = new UserDaoInit();


    public static String getJSONResponse (){
        StringBuilder sb = new StringBuilder();
        List<User> userList = USER_DAO_INIT.selectAll();
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
    public static int validAge (String age){
        try {
            int i = Integer.parseInt(age);
            return i;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid age");
        }
    }
    public static String validEmail(String email){
        Pattern pattern1 = Pattern
                .compile(PropertyLoader.REGEX_EMAIL
                        ,Pattern.CASE_INSENSITIVE);
        Matcher m1 = pattern1.matcher(email);

        try {

            if (!m1.find()) {

                throw new IllegalArgumentException("Invalid email");
            }
            if (USER_DAO_INIT.selectType1WhereHaveType2(email)){

                throw new IllegalArgumentException("Email is used");
            }
            return email;
        }catch (IllegalStateException e) {

            throw new IllegalArgumentException("Invalid email");
        }
    }
    public static User getUserForReq(HttpServletRequest req){

        return User
                .newBuilder()
                .setFirstName(req.getParameter("firstName"))
                .setSecondName(req.getParameter("secondName"))
                .setAge(validAge(req.getParameter("age")))
                .setEmail(validEmail(req.getParameter("email")))
                .setPassword(req.getParameter("password"))
                .build();
    }

    public static void insertUser (User user){
        USER_DAO_INIT.insert(user);
    }
}
