package HomeTasks.HomeTaskEleventh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:h2:~/IdeaProjects/arrowhead" +
            "/bozhok-roman/src/main/resources/Users";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "sa";

    private static Connection connection = getConnection();

    private static Connection getConnection() {
        try {
            return DriverManager.
                    getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getDataBaseConnection(){
        return connection;
    }


}
