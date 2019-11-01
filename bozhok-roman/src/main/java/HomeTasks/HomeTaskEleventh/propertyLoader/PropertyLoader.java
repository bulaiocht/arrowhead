package HomeTasks.HomeTaskEleventh.propertyLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public abstract class PropertyLoader {

    private static Properties CONFIG_APP;
    private static Properties SERVER_CONFIG;

    static {
        try {
            Path appConfigPath = Paths.get("src", "main", "resources",
                    "configurationServletApp", "configServlApp.properties");
            InputStream appConfIs = Files.newInputStream(appConfigPath);
            Properties properties = new Properties();
            properties.load(appConfIs);
            CONFIG_APP = properties;

            Path serverConfigPath = Paths.get("src", "main", "resources",
                    "configurationServletApp", "serverConfig.properties");
            InputStream servConfIs = Files.newInputStream(serverConfigPath);
            Properties serverConfigProperties = new Properties();
            serverConfigProperties.load(servConfIs);
            SERVER_CONFIG = serverConfigProperties;

        } catch (IOException e) {
            throw new IllegalStateException("No configuration found", e);
        }
    }

    public static int PORT = Integer.parseInt(SERVER_CONFIG.getProperty("port"));
    public static String REGEX_EMAIL = CONFIG_APP.getProperty("regexEmail");
    public static String APP_BASE = SERVER_CONFIG.getProperty("appBase");
    public static String DOC_BASE = SERVER_CONFIG.getProperty("docBase");
    public static String CONTEXT_PATH = SERVER_CONFIG.getProperty("contextPath");

}
