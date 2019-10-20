package HomeTasks.HomeTaskEleventh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoInit implements UserDao {
    private static final Connection CONNECTION = DataBaseConnection
            .getDataBaseConnection();

    @Override
    public void creatTableUser() {
        try {


            Statement statement = CONNECTION.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS USER(" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "FIRSTNAME VARCHAR(45)," +
                    "SECONDNAME VARCHAR(45)," +
                    "AGE INT," +
                    "EMAIL VARCHAR(55)," +
                    "PASSWORD VARCHAR(44));");

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(User user) {
        try {

            PreparedStatement preparedStatement =
                    CONNECTION.prepareStatement("INSERT INTO USER(" +
                            "FIRSTNAME, " +
                            "SECONDNAME," +
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

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        try {

            Statement statement =
                    CONNECTION.createStatement();
             ResultSet resultSet =
                     statement.executeQuery("SELECT * FROM USER");
             while (resultSet.next()){

                  User user = User.newBuilder()
                         .setFirstName(resultSet.getString("FIRSTNAME"))
                         .setSecondName(resultSet.getString("SECONDNAME"))
                         .setAge(resultSet.getInt("AGE"))
                         .setEmail(resultSet.getString("EMAIL"))
                         .setPassword(resultSet.getString("PASSWORD"))
                         .build();
                 System.out.println(user);
                  users.add(user);

             }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean isUserByEmailPresent(String email) {
        try {
            PreparedStatement preparedStatement =
                    CONNECTION.prepareStatement("SELECT *" +
                            " FROM USER" +
                            " WHERE EMAIL = ?");

            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;

            }else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
}
