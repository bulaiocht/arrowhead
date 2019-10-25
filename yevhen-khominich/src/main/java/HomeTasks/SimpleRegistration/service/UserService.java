package HomeTasks.SimpleRegistration.service;


import HomeTasks.SimpleRegistration.DB.DAO.impl.UserDao;
import HomeTasks.SimpleRegistration.DB.connection.DataSourceFactory;
import HomeTasks.SimpleRegistration.entity.User;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserService {

    private static final DataSource h2 = DataSourceFactory.getH2();
    private static final UserDao userDao = new UserDao(h2);

    public static void initialize() {
        userDao.createTableUser();
    }

    public static User saveUser(User user){
       return userDao.create(user);
    }

    public static boolean isUserWithEmail(String email){
        return userDao.isUserWithEmailExist(email);
    }

    public static List<User> getAll(){
        return userDao.getAll();
    }


}
