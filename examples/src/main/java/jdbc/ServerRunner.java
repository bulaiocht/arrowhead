package jdbc;

import org.apache.commons.lang3.RandomStringUtils;
import socket.chat.NameCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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
//            statement.execute("DROP TABLE IF EXISTS USER");
            statement.execute("CREATE TABLE IF NOT EXISTS USER (" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "NAME VARCHAR(250)," +
                    "SECOND_NAME VARCHAR(250)," +
                    "ADDRESS VARCHAR(250));");



            new java.sql.Date(System.currentTimeMillis());


            String insertSql = "INSERT INTO USER(NAME, SECOND_NAME, ADDRESS) VALUES ( ?, ?, ? );";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < 10; i++) {
                preparedStatement.setString(1, NameCreator.getRandomNickName());
                preparedStatement.setString(2, NameCreator.getRandomNickName());
                preparedStatement.setString(3, RandomStringUtils.randomAlphabetic(10));

                preparedStatement.addBatch();
            }

            int[] ints = preparedStatement.executeBatch();

            System.out.println(Arrays.toString(ints));

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            while (generatedKeys.next()) {
                long id = generatedKeys.getLong("ID");
                System.out.println("User id: " + id);
            }

            String selectAllSql = "SELECT * FROM USER";

            Statement selectStatement = connection.createStatement();
            ResultSet allSet = selectStatement.executeQuery(selectAllSql);

            List<BasicUser> userList = new ArrayList<>();

            while (allSet.next()) {

                long id = allSet.getLong("ID");
                String name = allSet.getString("NAME");
                String second_name = allSet.getString("SECOND_NAME");
                String address = allSet.getString("ADDRESS");

                BasicUser basicUser = new BasicUser();
                basicUser.setId(id);
                basicUser.setName(name);
                basicUser.setSecondName(second_name);
                basicUser.setAddress(address);

                userList.add(basicUser);
            }

            userList.forEach(System.out::println);

//            Statement stmnt = connection.createStatement();
//            stmnt.execute("INSERT INTO USR(NAME) VALUES ( 'bobby' )");

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


////        Class.forName("org.h2.Driver");
//
//        Connection conn = null;
//
//        try {
//            Enumeration<Driver> drivers = DriverManager.getDrivers();
//            while (drivers.hasMoreElements()) {
//                Driver driver = drivers.nextElement();
//                System.out.println(driver);
//            }
//
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/test", "root", "root");
//            conn.setAutoCommit(true);
//
//            System.out.println("Connection Established: "
//                    + conn.getMetaData().getDatabaseProductName() + "/" + conn.getCatalog());
//
////            Statement stmnt = conn.createStatement();
////            stmnt.execute("DROP TABLE IF EXISTS TEST_TABLE;");
////            stmnt.execute("CREATE TABLE TEST_TABLE (" +
////                    "id INT PRIMARY KEY AUTO_INCREMENT," +
////                    "name VARCHAR(250)," +
////                    "second_name VARCHAR(250));");
////
////            stmnt.close();
//
//            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO TEST_TABLE(NAME, SECOND_NAME) VALUES (?, ?);");
//
//            for (int i = 0; i < 5; i++) {
//
//                preparedStatement.setString(1, NameCreator.getRandomNickName());
//                preparedStatement.setString(2, NameCreator.getRandomNickName());
//
//                preparedStatement.execute();
//            }
//
////            Statement statement = conn.createStatement();
////            statement.execute("INSERT INTO ababab (id) VALUES ( 2 )");
//
//            preparedStatement.close();
//
//            PreparedStatement nameLike = conn.prepareStatement("SELECT * FROM TEST_TABLE WHERE NAME LIKE ? ORDER BY NAME DESC");
//            nameLike.setString(1,"a%");
//            ResultSet set = nameLike.executeQuery();
//
//            while (set.next()) {
//                int id = set.getInt("ID");
//                String name = set.getString("NAME");
//                String second_name = set.getString("SECOND_NAME");
//
//                System.out.printf("id: %s name: %s second name: %s\n", id, name, second_name);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            if (conn != null) {
//                try {
//                    System.out.println("rolling back all changes");
//                    conn.rollback();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
    }
}
