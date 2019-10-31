package ClassTask.pictureApp.userLogin.dao;


import ClassTask.pictureApp.picture.connection.ConnectionManager;
import ClassTask.pictureApp.picture.connection.ConnectionManagerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUserImpl implements DaoUser {
    private static final String SELECT_WHERE_USER_SQL =
                    "SELECT *" +
                    " FROM USER" +
                    " WHERE USER.USER_NAME = ?&USER.PASSWORD = ?;";
    private static final String CREATE_TABLE_USER_SQL =
            "CREATE TABLE IF NOT EXISTS USER (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT," +
            "USER_NAME VARCHAR(45)," +
            "PASSWORD VARCHAR(45));";
    private static final String INSERT_USER_SQL =
            "INSERT INTO USER (" +
            "USER_NAME, " +
            "PASSWORD)" +
            "VALUES (?,?);";
    private final ConnectionManager connectionManager = ConnectionManagerFactory.getH2ConnectionManager();
    @Override
    public void createTable() {
        Connection connection = connectionManager.getConnection();
        try {


            Statement statement = connection.createStatement();

            statement.execute(CREATE_TABLE_USER_SQL);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long insert(User user) {
        Connection connection = connectionManager.getConnection();
        Long ID = null;
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement =
                    connection.prepareStatement(INSERT_USER_SQL,Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());


            preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()){
                ID = generatedKeys.getLong("ID");
            }
            return ID;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public User selectByPassword(User user) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    connection.prepareStatement(SELECT_WHERE_USER_SQL);

            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();
            User userBuild = null;
            while (resultSet.next()) {
                userBuild = User.newBuilder()
                        .setID(resultSet.getLong("ID"))
                        .setUsername(resultSet.getString("USER_NAME"))
                        .setPassword(resultSet.getString("PASSWORD"))
                        .build();
            }




            return userBuild;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }finally {
            try {
                connection.close ();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
