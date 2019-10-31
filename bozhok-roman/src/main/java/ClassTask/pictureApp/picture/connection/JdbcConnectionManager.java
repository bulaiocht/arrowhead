package ClassTask.pictureApp.picture.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcConnectionManager implements ConnectionManager {
    private static final int INITIAL_POOL_SIZE = 10;

    private String url;
    private String user;
    private String password;
    private int poolSize;

    private List<Connection> connectionPool;
    private List<Connection> usedConnections;

    private JdbcConnectionManager(String url, String user, String password) {
        this(url, user, password, INITIAL_POOL_SIZE);
    }

    private JdbcConnectionManager(String url, String user, String password, int poolSize) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.poolSize = poolSize;
        this.connectionPool = new ArrayList<>(poolSize);
        this.usedConnections = new ArrayList<>();

        try {
            initPool();
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create connection pool", e);
        }
    }

    private void initPool() throws SQLException {
        for (int i = 0; i < poolSize; i++) {
            Connection connection = createConnection(url, user, password);
            connectionPool.add(connection);
        }
    }

    private static Connection createConnection(String url,
                                               String user,
                                               String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public Connection getConnection() {
        int size = connectionPool.size();
        if (size == 0) {
            throw new RuntimeException("No more connections left!");
        }
        Connection connection = connectionPool.remove(size - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    @Override
    public void shutDown() {

        List<Connection> connections =
                new ArrayList<>();
        connections.addAll(usedConnections);
        connections.addAll(connectionPool);
        for (Connection connection : connections) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String url;
        private String user;
        private String password;
        private int poolSize;

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setUser(String user) {
            this.user = user;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPoolSize(int poolSize) {
            this.poolSize = poolSize;
            return this;
        }

        public ConnectionManager build() {
            return new JdbcConnectionManager(this.url, this.user, this.password, this.poolSize);
        }
    }
}
