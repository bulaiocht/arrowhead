package jdbc.test.dao;

import jdbc.test.ConnectionManager;
import jdbc.test.dao.impl.UserDao;
import jdbc.test.dao.impl.UserDaoImpl;

public class DaoFactory {

    public static UserDao createUserDao(ConnectionManager connectionManager) {
        return new UserDaoImpl(connectionManager);
    }
}
