package jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HikariExample {
    public static void main(String[] args) throws SQLException {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:h2:~/test2");
        config.setUsername("sa");
        config.setPassword("");
        config.setAutoCommit(false);
        config.setMaximumPoolSize(20);

        HikariPool pool = new HikariPool(config);

        Connection connection = pool.getConnection();

        Statement statement = connection.createStatement();
        ResultSet allSet = statement.executeQuery("SELECT * FROM USER");

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

    }
}
