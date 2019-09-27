package HomeTasks.HomeTaskTenth.client;

import HomeTasks.HomeTaskTenth.server.ServerConfig;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;


abstract class Client {

    private Socket socket;
    private final String EXIT = "Exit";
    private final Scanner scanner = new Scanner(System.in);


    protected void getConnection(){
        try {
             socket = new Socket(ServerConfig.IP,ServerConfig.PORT);
            try (BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
                bf.write(this.getClass().getName());
                bf.flush();
            }catch (IOException e ){
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    protected String readUserInput(){
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase(EXIT)){
            try {
                socket.close();
                return socket.getInetAddress().getHostName()+"Client dead";
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }else {
            return s;
        }

    }

    protected void sendJsonMessage (){
        StringBuilder sb = new StringBuilder();
        sb.append("{"+"\n");
        String userInput = readUserInput();
        String[] field = userInput.split(",");
        for (String s : field) {
            String[] split = s.split("=");
            sb.append("\""+split[0]+"\"");
            sb.append(": ");
            try {
                int i = Integer.parseInt(split[1]);
                sb.append(i);
            }catch (Exception e){
                sb.append("\""+split[1]+"\"");
            }
            sb.append("\n");

        }
        sb.append("\n");
        sb.append("}");

        try (BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
                bf.write(sb.toString());
                bf.flush();
        }catch (IOException e ){
            e.printStackTrace();
        }


    }
    protected void getMessage (){
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            while (true) {
                String line = br.readLine();
                if (line==null){
                    break;
                }
                stringBuilder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }





}
