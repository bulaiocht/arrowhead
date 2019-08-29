package multithreading.efficiency.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class WordSearchHandler implements HttpHandler {

    private String text;

    public WordSearchHandler(String text) {
        this.text = text;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String query = exchange.getRequestURI().getQuery();
        String[] split = query.split("=");
        String action = split[0];
        String word = split[1];
        if (!"word".equalsIgnoreCase(action)) {
            exchange.sendResponseHeaders(400, 0);
            return;
        }
        long count = wordCount(word);
        byte[] bytes = Long.toString(count).getBytes();
        exchange.sendResponseHeaders(200, bytes.length);
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(bytes);
        responseBody.close();

    }

    private long wordCount(String word) {
        long count = 0;
        int index = 0;
        while (index >= 0) {
            index = text.indexOf(word, index);

            if (index >=0) {
                index++;
                count++;
            }
        }
        return count;
    }
}
