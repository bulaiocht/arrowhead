package jdbc.repo;

import jdbc.BasicUser;
import jdbc.test.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class BasicUserDaoImpl implements BasicUserDao {

    private final ConnectionManager connectionManager;

    public BasicUserDaoImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Optional<BasicUser> findById(Long id) {
        Connection connection = connectionManager.getConnection();
        try {
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionManager.releaseConnection(connection);
        return Optional.empty();
    }

    @Override
    public <S extends BasicUser> Long save(S entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
