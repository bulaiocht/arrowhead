package jdbc.repo;

import jdbc.test.ConnectionManager;
import jdbc.test.connection.ConnectionManagerFactory;

public class BasicDaoFactory {
    private static ConnectionManager h2ConnectionManager
            = ConnectionManagerFactory.getH2ConnectionManager();

    public static BasicUserDao getUserDao(){
        return new BasicUserDaoImpl(h2ConnectionManager);
    }



}
