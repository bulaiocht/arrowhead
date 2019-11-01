package HomeTasks.SimpleRegistration.DB.DAO.impl;

import HomeTasks.SimpleRegistration.DB.DAO.BasicUserDao;
import HomeTasks.SimpleRegistration.DB.connection.DataSourceFactory;
import HomeTasks.SimpleRegistration.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BasicUserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    private static final String MAIN_EXCEPTION_MESSAGE = "Exception occurred";

    private DataSource dataSource;

    public UserDao() {
        dataSource = DataSourceFactory.getH2();
    }

    @Override
    public User create(User user) {
        try (Connection connection = dataSource.getConnection()
        ) {
            PreparedStatement pst = connection.prepareStatement("INSERT INTO USER (FIRSTNAME, SECONDNAME, AGE, EMAIL, PASSWORD) VALUES (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setInt(3, user.getAge());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getPassword());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void saveAll(List<User> list) {

    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public List<User> getAll() {

        List<User> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement("SELECT * FROM USER;", Statement.RETURN_GENERATED_KEYS);
        ) {
            final ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                users.add(toUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }


    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    public boolean isUserWithEmailExist(String email) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT EMAIL" +
                             " FROM USER;")
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("EMAIL").equals(email)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public void createTableUser() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.execute("CREATE TABLE IF NOT EXISTS USER(" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "FIRSTNAME VARCHAR(50)," +
                    "SECONDNAME VARCHAR(50)," +
                    "AGE INT," +
                    "EMAIL VARCHAR(50)," +
                    "PASSWORD VARCHAR(50));");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User toUser(ResultSet rs) throws SQLException {
        return new User(

                rs.getInt("ID"),
                rs.getString("FIRSTNAME"),
                rs.getString("SECONDNAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getInt("AGE")
        );

    }
}
