package HomeTask.EleventhTask.dao;

import HomeTask.EleventhTask.connection.ConnectionManager;
import HomeTask.EleventhTask.pojo.User;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

//    private final ConnectionManager connectionManager;
    private final HikariConfig config;
    private final HikariPool hikariPool;

    public UserDaoImpl(ConnectionManager connectionManager) {
//        this.connectionManager = connectionManager;
        config = new HikariConfig();
//TODO вынести в проперти
        config.setJdbcUrl("jdbc:h2:~/user");
        config.setUsername("sa");
        config.setPassword("");
        config.setMaximumPoolSize(20);

        hikariPool = new HikariPool(config);

    }

    @Override
    public void createTable() {
        Connection connection = null;
        try {
            connection = hikariPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {


            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS USER(" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "FIRST_NAME VARCHAR(250)," +
                    "LAST_NAME VARCHAR(250)," +
                    "AGE INT," +
                    "EMAIL VARCHAR(250)," +
                    "PASSWORD VARCHAR(250));");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean findByEmail(String email) {
        Connection connection = null;
        try {
            connection = hikariPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    connection.prepareStatement("SELECT *" +
                            " FROM USER" +
                            " WHERE EMAIL = ?");

            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (preparedStatement != null)preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public <S extends User> void save(S entity) {
        Connection connection = null;
        try {
            connection = hikariPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO USER(" +
                            "FIRST_NAME, " +
                            "LAST_NAME," +
                            "AGE, " +
                            "EMAIL," +
                            "PASSWORD) " +
                            "VALUES (?,?,?,?,?);");

            preparedStatement.setString(1,entity.getFirstName());
            preparedStatement.setString(2,entity.getLastName());
            preparedStatement.setInt(3,entity.getAge());
            preparedStatement.setString(4,entity.getEmail());
            preparedStatement.setString(5,entity.getPassword());


            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectAll() {
        Connection connection = null;
        try {
            connection = hikariPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<User> users = new ArrayList<>();
        try {

            Statement statement =
                    connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM USER");
            while (resultSet.next()){

                User user = User.newBuilder()
                        .setFirstName(resultSet.getString("FIRST_NAME"))
                        .setLastName(resultSet.getString("LAST_NAME"))
                        .setAge(resultSet.getInt("AGE"))
                        .setEmail(resultSet.getString("EMAIL"))
                        .setPassword(resultSet.getString("PASSWORD"))
                        .build();
                users.add(user);

            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
