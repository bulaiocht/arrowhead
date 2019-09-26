package HomeTasks.HomeTaskTenth.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public interface ServerConfig {
    Properties EMAILCONFIG = ServerConfig.loader();
    String IP = EMAILCONFIG.getProperty("IP");
    InetAddress INET_ADDRESS = getInetAddress();
    int PORT = Integer.parseInt(EMAILCONFIG.getProperty("PORT"));

    static Properties loader (){
        try {
            Properties properties = new Properties();
            FileInputStream in = new FileInputStream(
                    String.format("bozhok-roman" +
                                    "%ssrc" +
                                    "%smain" +
                                    "%sresources" +
                                    "%sconfigurationServer" +
                                    "%sconfig.properties",
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator));

            properties.load(in);

            return properties;
        } catch (IOException e) {
            return null;
        }
    }
    static InetAddress getInetAddress (){
        try {

            return InetAddress.getByName(IP);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
