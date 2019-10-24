package HomeTasks.HomeTaskEleventh.propertyLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class PropertyLoader {
    public static final Properties CONFIG_APP = loaderConfigApp();
    public static final Properties SERVER_CONFIG = loaderServerConfig();
    public static final String REGEX_EMAIL = CONFIG_APP.getProperty("regexEmail");
    public static final String APP_BASE = SERVER_CONFIG.getProperty("appBase");
    public static final String DOC_BASE = SERVER_CONFIG.getProperty("docBase");
    public static final String CONTEXT_PATH = SERVER_CONFIG.getProperty("contextPath");
    public static final int PORT = Integer.parseInt(SERVER_CONFIG.getProperty("port"));
    private static Properties loaderConfigApp (){
        try {
            FileInputStream in = new FileInputStream(
                    String.format("bozhok-roman" +
                                    "%ssrc" +
                                    "%smain" +
                                    "%sresources" +
                                    "%sconfigurationServletApp" +
                                    "%sconfigServlApp.properties",
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator));
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            return null;
        }
    }
    private static Properties loaderServerConfig (){
        try {
            FileInputStream in = new FileInputStream(
                    String.format("bozhok-roman" +
                                    "%ssrc" +
                                    "%smain" +
                                    "%sresources" +
                                    "%sconfigurationServletApp" +
                                    "%sserverConfig.properties",
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator));
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            return null;
        }
    }
}
