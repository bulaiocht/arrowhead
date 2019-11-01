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

    private UserDao userDao;

    public UserService( UserDao userDao) {
        this.userDao = userDao;
    }

    public void initialize() {
        userDao.createTableUser();
    }

    public User saveUser(User user){
       return userDao.create(user);
    }

    public boolean isUserWithEmail(String email){
        return userDao.isUserWithEmailExist(email);
    }

    public List<User> getAll(){
        return userDao.getAll();
    }


}
