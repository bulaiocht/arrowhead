package HomeTask.EleventhTask.dao;

import HomeTask.EleventhTask.connection.ConnectionManager;
import HomeTask.EleventhTask.connection.ConnectionManagerFactory;

public class BasicDaoFactory {

    private static ConnectionManager h2ConnectionManager = ConnectionManagerFactory.getH2ConnectionManager();

    public static UserDao getUserDao() {

        return new UserDaoImpl(h2ConnectionManager);
    }

}
