package socket.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnectionThread extends Thread {

    private static final String MESSAGE_REGEX = "[a-zA-Z0-9_\\-\\s]{1,}#.*";
    private final String id;
    private final Socket socket;

    public Socket getSocket() {
        return socket;
    }

    private final ChatServer server;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public ClientConnectionThread(String id,Socket socket, ChatServer server) {
        this.id = id;
        this.socket = socket;
        this.server = server;
        try {
            this.writer =
                    new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            this.reader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            writer.println("Your ID is: " + id);

            while (true) {

                String line = reader.readLine();

                if (line != null) {

                    if ("/quit".equalsIgnoreCase(line)) {
                        break;
                    }

                    if ("/list".equalsIgnoreCase(line)) {

                        server.getClientList()
                                .stream()
                                .filter(c -> !c.equalsIgnoreCase(id))
                                .forEach(writer::println);

                        continue;
                    }

                    if (line.matches(MESSAGE_REGEX)) {

                        String[] split = line.split("#");
                        String recipient = split[0].trim();
                        String text = split[1].trim();

                        server.sendClientMessage(id, recipient, text);
                    }


                }

            }

            server.deleteClient(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }
}
