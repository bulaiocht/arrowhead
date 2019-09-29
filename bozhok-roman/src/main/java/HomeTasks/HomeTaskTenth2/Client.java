package HomeTasks.HomeTaskTenth2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public abstract class Client {
    private  final String QUIT = "QUIT";
    private  final String TERMINATE = "X";
    private  String IP ;


    public  void starter(String ip) throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(ip, 5000));

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer =  new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String name = this.getClass().getName();
                String[] splPoint = name.split("\\.");
                name = splPoint[splPoint.length-1];
                writer.write(name);
                writer.newLine();
                writer.flush();
            String response = reader.readLine();
            System.out.println(response);

            while (true) {

                String userInput = inputReader.readLine();
                StringBuilder sb = new StringBuilder();
                if (QUIT.equalsIgnoreCase(userInput) || TERMINATE.equalsIgnoreCase(userInput)) {
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

                String response1 = reader.readLine();
                System.out.println(response1);
            }




        } finally {
            socket.close();
        }


    }

}
