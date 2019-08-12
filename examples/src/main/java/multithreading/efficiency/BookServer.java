package multithreading.efficiency;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BookServer {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("examples/src/main/resources/war_and_peace.txt");
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        int processors = Runtime.getRuntime().availableProcessors();
//        int processors = 1;
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/search", new WordSearchHandler(text));
        Executor executor = Executors.newFixedThreadPool(processors);
        server.setExecutor(executor);
        server.start();
    }

}
