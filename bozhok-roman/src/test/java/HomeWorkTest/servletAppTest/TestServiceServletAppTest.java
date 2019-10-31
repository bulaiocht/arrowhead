package HomeWorkTest.servletAppTest;

import HomeTasks.HomeTaskEleventh.dao.User;
import HomeTasks.HomeTaskEleventh.dao.UserDao;
import HomeTasks.HomeTaskEleventh.service.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class TestServiceServletAppTest {

    private static String email_valid = "romabos98@gmail.com";
    private String email_invalid = "romabos98gmail.com";

    private static String firstName = "roma";
    private static String secondName = "bozhok";
    private static String age_valid = "123";
    private static int age_valid_int = 123;
    private String age_invalid = "qwe";
    private static String password = "123123" ;

    private static HttpServletRequest request ;

    private static User user ;

    private static UserDao userDao;

    private static List<User> users;
    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void init(){
        userDao = Mockito.mock(UserDao.class);
        request = Mockito.mock(HttpServletRequest.class);
        user = User.newBuilder()
                .setFirstName(firstName)
                .setSecondName(secondName)
                .setAge(age_valid_int)
                .setEmail(email_valid)
                .setPassword(password)
                .build();
        Mockito.when(request.getParameter("firstName")).thenReturn(firstName);
        Mockito.when(request.getParameter("secondName")).thenReturn(secondName);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        new Service(userDao);
        users = new ArrayList<>();
        users.add(user);
        objectMapper = new ObjectMapper();
    }


    @Test
    void testGetUserForReq() {

        Mockito.when(request.getParameter("age")).thenReturn(age_invalid);

        Assertions.assertThrows(IllegalArgumentException.class,
                ()->Service.getUserForReq(request),"Invalid age");

        Mockito.when(request.getParameter("age")).thenReturn(age_valid);
        Mockito.when(request.getParameter("email")).thenReturn(email_invalid);

        Assertions.assertThrows(IllegalArgumentException.class,
                ()->Service.getUserForReq(request),"Invalid email");

        Mockito.when(request.getParameter("age")).thenReturn(age_valid);
        Mockito.when(request.getParameter("email")).thenReturn(email_valid);
        Assertions.assertEquals(Service.getUserForReq(request),user);






    }

    @Test
    void testGetJSON() throws JsonProcessingException {
        Mockito.when(userDao.selectAll()).thenReturn(users);
        Assertions.assertEquals(Service.getJSONResponse(),objectMapper.writeValueAsString(users));



    }
}
