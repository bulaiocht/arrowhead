package HomeTasks.HomeTaskEleventh.dao;

import HomeTasks.HomeTaskEleventh.connectionDB.ConnectionManager;
import HomeTasks.HomeTaskEleventh.connectionDB.ConnectionManagerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoInit implements UserDao {
    private static final ConnectionManager CONNECTION_MANAGER =
            ConnectionManagerFactory.getH2ConnectionManager();


    @Override
    public void creatTable() {
        Connection connection = CONNECTION_MANAGER.getConnection();
        Statement statement = null;
        try {


            statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS USER(" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "FIRST_NAME VARCHAR(45)," +
                    "SECOND_NAME VARCHAR(45)," +
                    "AGE INT," +
                    "EMAIL VARCHAR(55)," +
                    "PASSWORD VARCHAR(44));");


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void insert(User user) {
        Connection connection = CONNECTION_MANAGER.getConnection();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement =
                    connection.prepareStatement("INSERT INTO USER(" +
                            "FIRST_NAME, " +
                            "SECOND_NAME," +
                            "AGE, " +
                            "EMAIL," +
                            "PASSWORD) " +
                            "VALUES (?,?,?,?,?);");

            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getSecondName());
            preparedStatement.setInt(3,user.getAge());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getPassword());


            preparedStatement.execute();


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
    }

    @Override
    public List<User> selectAll() {
        Connection connection = CONNECTION_MANAGER.getConnection();
        Statement statement = null;
        List<User> users = new ArrayList<>();
        try {

            statement =
                    connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery("SELECT * FROM USER");
             while (resultSet.next()){

                  User user = User.newBuilder()
                         .setFirstName(resultSet.getString("FIRST_NAME"))
                         .setSecondName(resultSet.getString("SECOND_NAME"))
                         .setAge(resultSet.getInt("AGE"))
                         .setEmail(resultSet.getString("EMAIL"))
                         .setPassword(resultSet.getString("PASSWORD"))
                         .build();
                  users.add(user);

             }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return users;
    }

    @Override
    public boolean selectType1WhereHaveType2(String email) {
        Connection connection = CONNECTION_MANAGER.getConnection();
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
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
