package HomeTasks.Socket.simpleChat.Chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    private boolean isWork = true;
    private BufferedReader inputReader;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;

    Client(Socket socketIn) {
        try {
            this.socket = socketIn;
            inputReader = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ReadMsg readMsg = new ReadMsg();
            readMsg.setName("Reading");
            WriteMsg writeMsg = new WriteMsg();
            writeMsg.setName("Writing");
            writeMsg.start();
            readMsg.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 9990));
        new Client(socket).go();

    }

    public void go() {
        System.out.println("Start work");
    }

    private static void showView() {
        System.out.println("1.Show all online users");
        System.out.println("2.Disconnect");
        System.out.println("3.Send message");
        System.out.println("Your choice : ");
    }

    //Thread that reads messages from server
    private class ReadMsg extends Thread {

        @Override
        public void run() {
            String str;
            try {
                String hi = reader.readLine();
                System.out.println(hi);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while (isWork) {
                    str = reader.readLine(); // ждем сообщения с сервера
                    if (str != null) {

                        if (str.equals("2")) {
                            Client.this.closeSocket(); // close
                            isWork = false;
                            break;
                        }

                        if (str.equals("4")) {
                            Client.this.closeSocket(); // close
                            isWork = false;
                            break;
                        }
                        System.out.println(str); // show message from server
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Thread that sends message from console to server
    private class WriteMsg extends Thread {

        @Override
        public void run() {

            try {

                pressNickname(inputReader);

                while (isWork) {
                    sleep(200);
                    showView();
                    String choice = inputReader.readLine();
                    sendCommand(choice);

                    if (choice.equalsIgnoreCase("2")) {
                        break;
                    }

                    if (choice.equalsIgnoreCase("3")) {
                        sendMessage();
                    }

                    if (choice.equalsIgnoreCase("4")) {
                        break;
                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void closeSocket() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                reader.close();
                writer.close();
                inputReader.close();
            }
        } catch (IOException ignored) {
        }
    }

    public void pressNickname(BufferedReader inputUser) {
        System.out.print("Press your nick: ");
        try {
            String nickname = inputUser.readLine();
            writer.write(nickname);
            writer.newLine();
            writer.flush();
        } catch (IOException ignored) {
        }

    }

    public void sendCommand(String choice) {

        try {
            writer.write(choice);
            writer.newLine();
            writer.flush();
        } catch (IOException ignored) {
        }

    }

    public void sendMessage() throws IOException {
        System.out.println("Enter nickname who u want to send a letter:");
        String adresat = inputReader.readLine();
        writer.write(adresat);
        writer.newLine();
        writer.flush();
        System.out.println("Your message : ");
        String message = inputReader.readLine();
        writer.write(message);
        writer.newLine();
        writer.flush();
    }


}


