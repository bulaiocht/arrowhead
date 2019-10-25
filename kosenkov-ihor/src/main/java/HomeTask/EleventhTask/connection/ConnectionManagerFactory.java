package HomeTask.EleventhTask.connection;

import java.util.ResourceBundle;

public class ConnectionManagerFactory {

    private static final String H2_CONF = "h2_config";

    public static ConnectionManager getH2ConnectionManager() {
        ResourceBundle bundle = ResourceBundle.getBundle(H2_CONF);

        String url = bundle.getString("url");
        String user = bundle.getString("username");
        String password = bundle.getString("password");

        return JdbcConnectionManager
                .builder()
                .setUrl(url)
                .setUser(user)
                .setPassword(password)
                .setPoolSize(5)
                .build();
    }

}
