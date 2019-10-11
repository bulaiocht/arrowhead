package HomeTask.TenthTask.server;

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

    private String nick;
    private String recipient = null;

    private final Server server;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public ClientConnectionThread(String id, Socket socket, Server server) {
        this.id = id;
        this.socket = socket;
        this.server = server;
        this.nick = id;
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
                System.out.println(line);

                if (line != null) {
                    if (!isHaveRecipient()) {
                        this.recipient = null;
                    }

                    if ("/quit".equalsIgnoreCase(line)) {
                        server.sendMessageToAll(id, "disconnected!");
                        break;
                    }

                    if ("/list".equalsIgnoreCase(line)) {
                        server.getClientList().forEach(client -> writer.println(client.getNick()));
                        continue;
                    }

                    if (line.contains("/changeNick")) {

                        String[] split = line.split(" ");
                        String nick = split[1];

                        ClientConnectionThread client1 = server.getClientList()
                                .stream()
                                .filter(client -> client.getNick().equals(nick))
                                .findAny()
                                .orElse(null);

                        if (client1 == null) {
                            server.sendMessageToAll(this.nick, String.format("changed his nickname to %s", nick));
                            this.nick = nick;
                        }
                        continue;


                    }

                    if (line.contains("/sendTo")) {
                        String[] split = line.split(" ");
                        server.getClientList()
                                .stream()
                                .filter(client -> !client.getNick().equals(split[1]))
                                .findAny().ifPresent(client1 -> this.recipient = split[1]);
                        continue;
                    }

                    if (this.recipient != null && !line.matches(MESSAGE_REGEX)) {
                        ClientConnectionThread client = server.getClientList()
                                .stream()
                                .filter(c -> c.getNick().equals(this.recipient))
                                .findAny()
                                .orElse(null);
                        String recipient = client.getID();
                        String text = line;
                        System.out.println(recipient);
                        server.sendClientMessage(nick, recipient, text);
                        continue;
                    }

                    if (line.matches(MESSAGE_REGEX)) {
                        String[] split = line.split("#");
                        ClientConnectionThread client = server.getClientList()
                                .stream()
                                .filter(c -> c.getNick().equals(split[0]))
                                .findAny()
                                .orElse(null);
                        String recipient = client.getID();
                        String text = split[1].trim();
                        server.sendClientMessage(nick, recipient, text);
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

    private boolean isHaveRecipient() {
        return server.getClientList()
                .stream()
                .anyMatch(client -> client.getNick().equals(recipient));
    }

    public Socket getSocket() {
        return socket;
    }

    public String getID() {
        return id;
    }

    public String getNick() {
        return nick;
    }
}