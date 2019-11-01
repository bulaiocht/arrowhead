package HomeTasks.SimpleRegistration.service;


import HomeTasks.SimpleRegistration.DB.DAO.impl.UserDao;
import HomeTasks.SimpleRegistration.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    private UserDao mockUserDao = Mockito.mock(UserDao.class);
    private UserService userService = new UserService(mockUserDao);
    private User user = new User(1, "firstName", "lastName", "secondName", "email", 11);


    @Test
    public void whenSaveUserReturnUser() {

        Mockito.when(mockUserDao.create(ArgumentMatchers.any())).thenReturn(user);
        User actual = userService.saveUser(user);
        Assertions.assertEquals(user, actual);

    }

    @Test
    public void whenIsUserWithEmailIsTrue() {
        String expected = "someEmail";

        Mockito.when(mockUserDao.isUserWithEmailExist(expected)).thenReturn(true);

        Assertions.assertTrue(userService.isUserWithEmail(expected));
    }

    @Test
    public void whenGetAllReturnListOfUsersTest() {

        List<User> expected = new ArrayList<>();
        expected.add(user);

        Mockito.when(mockUserDao.getAll()).thenReturn(expected);

        List<User> actual = userService.getAll();

        Assertions.assertEquals(expected, actual);


    }
}
