package HomeTasks.Socket.simpleChat.Chat;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Server {

    private static List<ProcessSocket> users = new LinkedList<>();
    private static boolean isClientWork = true;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket();

        try {
            server.bind(new InetSocketAddress("localhost", 9990));
            while (true) {
                Socket client = server.accept();
                users.add(new ProcessSocket(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
            server.close();
        } finally {
            server.close();
        }

    }

    private static class ProcessSocket extends Thread {

        private BufferedReader reader;
        private BufferedWriter writer;
        private Socket clientSocket;
        private String nick;

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        private ProcessSocket(Socket clientSocket) throws IOException {
            isClientWork = true;
            this.clientSocket = clientSocket;
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            start();
        }

        @Override
        public void run() {

            int port = clientSocket.getPort();
            InetAddress inetAddress = clientSocket.getInetAddress();
            String hostName = inetAddress.getHostName();
            System.out.println("connection from " + hostName + ":" + port);

            String nick = initializeNick();
            setNick(nick);
            System.out.println(nick + " is connected");
            sayHiToUser(nick);

            while (isClientWork) {
                try {
                    chooseVar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public String initializeNick() {
            String nick = null;
            try {
                nick = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return nick;
        }

        public void sayHiToUser(String nick) {
            try {
                writer.write("hello, " + nick);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void showAllUsers() throws IOException {

            System.out.println("Users: ");
            write("Available users : ");

            for (ProcessSocket user : users) {
                System.out.println(user.getNick());
                write(user.getNick());

            }

        }

        private void chooseVar() throws IOException {

            switch ((reader.readLine())) {
                case "1":
                    showAllUsers();
                    break;
                case "2":
                    System.out.println(this.getNick() + " is disconnected");
                    write("2");
                    isClientWork = false;
                    this.closeClient();
                    break;
                case "3":
                    sendMessage();
                    break;
                default:
                    break;
            }


        }

        private void closeClient() {
            try {
                if (!clientSocket.isClosed()) {
                    clientSocket.close();
                    reader.close();
                    writer.close();
                    for (ProcessSocket user : users) {
                        if (user.equals(this)) {
                            user.interrupt();
                            Server.users.remove(this);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendTo(String msg) throws IOException {
            Date time = new Date(); //
            SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm:ss"); // time
            String dTime = dt1.format(time); //
            write(dTime + " " + this.getNick() + " : " + msg);
        }

        private void write(String s) throws IOException {
            writer.write(s);
            writer.newLine();
            writer.flush();
        }

        //send message to some user
        private void sendMessage() throws IOException {
            String adresat = reader.readLine();
            String msg = reader.readLine();
            for (ProcessSocket user : users) {
                if (adresat.equalsIgnoreCase(user.getNick())) {
                    user.sendTo(msg);
                    System.out.println("sending to " + user.getNick());
                }
            }
        }
    }
}