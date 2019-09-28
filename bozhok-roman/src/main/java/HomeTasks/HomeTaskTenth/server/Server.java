package HomeTasks.HomeTaskTenth.server;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server implements ServerConfig {

    private static final ServerSocket serverSocket = getServerSocket();
    private static final  int MAX_USERS = 10;
    private static volatile Map<String, List<String>> pullMessage = new HashMap<>() ;
    private static volatile Map<String, String> pullClient=new HashMap<>();

    private static ServerSocket getServerSocket(){

        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(PORT));
            return serverSocket;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void clientListener (){
        while (true){
            Socket accept ;
        try {
            accept = serverSocket.accept();
            new ClientToThread(accept).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
    }
    private class ClientToThread extends Thread {
        private final Socket accept;
        private final String ip;

        private ClientToThread(Socket accept) {
            this.accept = accept;
            this.ip = accept.getLocalAddress().toString();
        }

        @Override
        public void run() {
            
            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()))) {
                StringBuilder stringBuilder = new StringBuilder();
                if (!accept.isInputShutdown()) {

                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuilder.append(line);
                    }

                    String[] $s = stringBuilder.toString().split("@");
                    System.out.println($s[0]);
                    if ($s.length == 1) {
                        pullMessage.put($s[0], new ArrayList<>());
                        System.out.println(ip);
                        pullClient.put(ip, $s[0]);
                        System.out.println(pullClient);

                    } else {
                        String[] receiver = $s[0].split("->");
                        List<String> listMessage = pullMessage.get(receiver[1]);
                        listMessage.add("From: " + receiver[0] + "\n" + $s[1]);
                        pullMessage.put(receiver[1], listMessage);
                        System.out.println(receiver[1]);
                        System.out.println(listMessage);


                    }

                }
                if (true) {
                    List<String> asdd = new ArrayList<>();
                    asdd.add("asd");
                    asdd.add("asd");
                    asdd.add("asd");
                    pullMessage.put("Aliona", asdd);
                    String clientName = pullClient.get(ip);

                    System.out.println(clientName);
                    System.out.println(pullMessage.get(clientName));
                    if (clientName != null && !pullMessage.get(clientName).isEmpty()) {
                        System.out.println("asd");
                        List<String> strings = pullMessage.get(clientName);
                        if (!strings.isEmpty() || strings != null) {

                                for (String string : strings) {
                                    bufferedWriter.write(string);
                                    bufferedWriter.newLine();


                                }
                                bufferedWriter.flush();




                        }

                    }

                }


            }catch (IOException e){
            e.printStackTrace();
            }finally {
                try {
                    accept.close();
                } catch (IOException e) {


                }
            }
        }
        }




}
