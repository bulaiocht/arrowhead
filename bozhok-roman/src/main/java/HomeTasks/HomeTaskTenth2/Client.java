package HomeTasks.HomeTaskTenth2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public abstract class Client {
    private final String QUIT = "QUIT";
    private final String TERMINATE = "X";
    private String IP;
    private BufferedReader inputReader;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;
    private String name;
    private String ip;


    private void init(String ip) {
        try {


            this.socket = new Socket();
            socket.connect(new InetSocketAddress(ip, 5000));
            this.inputReader = new BufferedReader(new InputStreamReader(System.in));
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {

        }
    }


    public void starter(String ip) throws IOException {
        init(ip);


        try {
            this.name = this.getClass().getName();
            String[] splPoint = name.split("\\.");
            name = splPoint[splPoint.length - 1];
            writer.write(name);
            writer.newLine();
            writer.flush();
            String response = reader.readLine();
            System.out.println(response);
            new Sender().start();
            new Reader().start();

            while (true) {


                String response1 = reader.readLine();
                System.out.println(response1);
            }


        } finally {
            socket.close();
        }


    }

    private class Reader extends Thread {

        @Override
        public void run() {


            try {
                while (true) {
                    String str = reader.readLine();
                    if (str != null) {
                        System.out.println(str);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private class Sender extends Thread {

        @Override
        public void run() {

            try {

                while (true) {
                    String userInput = inputReader.readLine();
                    StringBuilder sb = new StringBuilder();
                    if (QUIT.equalsIgnoreCase(userInput) || TERMINATE.equalsIgnoreCase(userInput)) {
                        writer.write(userInput);
                        writer.newLine();
                        writer.flush();
                        socket.close();
                        System.exit(1);
                        break;
                    }
                    sb.append(name + "->" + userInput + "@");
                    userInput = inputReader.readLine();
                    sb.append("{");
                    String[] field = userInput.split(",");
                    for (String s : field) {
                        String[] split = s.split("=");
                        sb.append("\"" + split[0] + "\"");
                        sb.append(": ");
                        try {
                            int i = Integer.parseInt(split[1]);
                            sb.append(i);
                        } catch (Exception e) {
                            sb.append("\"" + split[1] + "\"");
                        }


                    }

                    sb.append("}");
                    System.out.println(sb.toString());
                    writer.write(sb.toString());
                    writer.newLine();
                    writer.flush();


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
