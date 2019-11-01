package jdbs;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class JdbsConnectionManager implements ConnectionManager {

    private static final int INITIAL_POOL_SIZE = 10;

    private String url;
    private String user;
    private String password;
    private int poolSize;

    private List<Connection> connectionPool;
    private List<Connection> usedConnections;

    private JdbsConnectionManager(String url, String user, String password) {
        this(url, user, password, INITIAL_POOL_SIZE);
    }

    private JdbsConnectionManager(String url, String user, String password, int poolSize) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.poolSize = poolSize;
        this.connectionPool = new ArrayList<>(poolSize);
        this.usedConnections = new ArrayList<>();
    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        return false;
    }

    @Override
    public void shutDown() {

    }
}
