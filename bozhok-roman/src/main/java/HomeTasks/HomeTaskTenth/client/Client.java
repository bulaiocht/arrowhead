package HomeTasks.HomeTaskTenth.client;

import HomeTasks.HomeTaskTenth.server.ServerConfig;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;


abstract class Client {

    private static Socket socket;
    private final String EXIT = "Exit";
    private String IP;
    private final Scanner scanner = new Scanner(System.in);


    protected void getConnection(String IP){
        this.IP = IP;
        try {
             socket = new Socket();
             socket.connect(new InetSocketAddress(IP,ServerConfig.PORT));
            try (BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
                String name = this.getClass().getName();
                String[] split = name.split("\\.");
                bf.write(split[split.length-1]);
                bf.flush();
            }catch (IOException e ){
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    protected void getConnection2(){
        try {
            socket = new Socket(IP,ServerConfig.PORT);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    protected String readUserInput(){
        String s = scanner.nextLine();
        if (EXIT.equalsIgnoreCase(s)){

            try {
                socket.close();
                System.out.println(socket.getInetAddress().getHostName()+"Client dead");
                System.exit(1);
                return null;
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
        String userInput = readUserInput();
        sb.append(userInput+"@");
        userInput = readUserInput();
        sb.append("{"+"\n");
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
        getConnection2();
        try (BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
                bf.write(sb.toString());

                bf.flush();
        }catch (IOException e ){
            e.printStackTrace();
        }


    }
    protected void getMessage (){
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";

        getConnection2();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(line);


    }





}
