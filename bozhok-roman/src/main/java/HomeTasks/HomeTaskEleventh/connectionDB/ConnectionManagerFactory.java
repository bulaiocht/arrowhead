package HomeTasks.HomeTaskEleventh.connectionDB;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionManagerFactory {

    private static final String H2_PATH_CONFIG =
            String.format("bozhok-roman" +
                    "%ssrc" +
                    "%smain" +
                    "%sresources" +
                    "%sconfigurationServletApp" +
                    "%sh2_config.properties",
            File.separator,
            File.separator,
            File.separator,
            File.separator,
            File.separator);


    public static ConnectionManager getH2ConnectionManager() {

        Properties loader = loader();


        String url = loader.getProperty("url");
        String user = loader.getProperty("username");
        String password = loader.getProperty("password");

        return JdbcConnectionManager
                .builder()
                .setUrl(url)
                .setUser(user)
                .setPassword(password)
                .setPoolSize(5)
                .build();

    }
    private static Properties loader (){
        try {
            FileInputStream in = new FileInputStream(H2_PATH_CONFIG);
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            return null;
        }
    }

}
