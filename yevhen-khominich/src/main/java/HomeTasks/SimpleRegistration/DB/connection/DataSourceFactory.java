package HomeTasks.SimpleRegistration.DB.connection;


import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {

    public static DataSource getH2() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setJdbcUrl("jdbc:h2:~/test2");
        dataSource.setMinimumIdle(2);
        dataSource.setMaximumPoolSize(5);
        return dataSource;

    }

}
