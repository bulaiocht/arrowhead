package jdbs;


import org.apache.commons.lang3.RandomStringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServerRunner {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("org.h2.Driver");

        String url = "jdbc:h2:~/test2";
        String username = "sa";
        String password = "";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
//            connection.setAutoCommit(false);

            String databaseProductName = connection.getMetaData().getDatabaseProductName();
            System.out.println("Connected to: " + databaseProductName);

            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS USER (" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "NAME VARCHAR(250)," +
                    "SECOND_NAME VARCHAR(250)," +
                    "ADDRESS VARCHAR(250));");


            String insertSQL = "INSERT INTO USER(NAME,SECOND_NAME,ADDRESS) VALUES(?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < 10; i++) {
                preparedStatement.setString(1, "Billy");
                preparedStatement.setString(2, "Bob");
                preparedStatement.setString(3, RandomStringUtils.randomAlphabetic(10));

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            while (generatedKeys.next()) {
                long id = generatedKeys.getLong(1);
                System.out.println("User id : " + id);
            }

            String selectAllSQL = "SELECT * FROM USER";

            Statement selectStatement = connection.createStatement();

            ResultSet selectAllResults = selectStatement.executeQuery(selectAllSQL);

            List<BasicUser> users = new ArrayList<>();

            while (selectAllResults.next()) {
                long id = selectAllResults.getLong(1);
                String name = selectAllResults.getString("NAME");
                String second_name = selectAllResults.getString("SECOND_NAME");
                String address = selectAllResults.getString("ADDRESS");

                BasicUser basicUser = new BasicUser();
                basicUser.setId(id);
                basicUser.setName(name);
                basicUser.setAddress(address);
                basicUser.setSecond_name(second_name);
                users.add(basicUser);

            }

            users.stream().forEach(System.out::println);

            preparedStatement.close();
            statement.close();
            connection.commit();
            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();

            try {
                if (connection != null) {
                    System.out.println("Rolling back transaction.");
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
