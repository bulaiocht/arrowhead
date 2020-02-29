package jdbs;

import java.sql.Connection;

public interface ConnectionManager {

    Connection getConnection();

    boolean releaseConnection(Connection connection);

    void shutDown();
}
