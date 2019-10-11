package HomeTask.TenthTask.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocket {
    private static final String QUIT = "/quit";
    private boolean isWork = true;

    Socket socket = new Socket();

    private BufferedReader inputReader;
    private BufferedWriter writer;
    private BufferedReader reader;

    public static void main(String[] args) {
        try {
            new ClientSocket().turnOn();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void turnOn() throws IOException {

        socket.connect(new InetSocketAddress("localhost", 8080));

        inputReader = new BufferedReader(new InputStreamReader(System.in));
        writer =  new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        new Write().start();
        new Read().start();

    }

    private class Read extends Thread {
        @Override
        public void run() {
            while (isWork) {
                String response = null;
                try {
                    response = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(response);
            }
        }
    }

    private class Write extends Thread {
        @Override
        public void run() {
            while (isWork) {
                try {
                    String str = inputReader.readLine();
                    if (str.equalsIgnoreCase(QUIT)) {
                        write(str);

                        turnOff();
                        break;
                    } else {
                        write(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void turnOff() throws IOException {
            isWork = false;
            reader.close();
            writer.close();
            inputReader.close();
            socket.close();
        }

        public void write(String str) throws IOException {
            writer.write(str);
            writer.newLine();
            writer.flush();
        }
    }
}