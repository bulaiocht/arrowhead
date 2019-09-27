package HomeTasks.HomeTaskTenth.server;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server implements ServerConfig {

    private static final ServerSocket serverSocket = getServerSocket();
    private static final  int MAX_USERS = 10;
    private static Map<String, List<String>> pullMessage ;
    private static Map<String, String> pullClient;

    private static ServerSocket getServerSocket(){
        pullMessage = new HashMap<>();
        pullClient = new HashMap<>();
        try {
            return new ServerSocket(PORT,MAX_USERS,INET_ADDRESS);
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
            clientToThread(accept);
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
    }
    private void clientToThread(Socket accept){
        Thread thread = new Thread(() -> {
            StringBuilder stringBuilder = new StringBuilder();
            if (accept.isInputShutdown()) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()))){
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line==null){
                            break;
                        }
                        stringBuilder.append(line);
                    }
                    String[] $s = stringBuilder.toString().split("$");
                    if ($s.length==1){
                        pullMessage.put($s[0],null);
                        pullClient.put(accept.getInetAddress().getHostName(),$s[0]);
                    }else {
                        String[] receiver = $s[0].split("->");
                        List<String> listMessage = pullMessage.get(receiver[1]);
                        listMessage.add("From: "+receiver[0]+"\n"+$s[1]);
                        pullMessage.put($s[0],listMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (accept.isOutputShutdown()){
                String hostName = accept.getInetAddress().getHostName();
                String clientName = pullClient.get(hostName);
                if (clientName!=null){

                    List<String> strings = pullMessage.get(clientName);
                    if (!strings.isEmpty()||strings!=null){
                        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()))){
                            for (String string : strings) {
                                bufferedWriter.write(string);
                                bufferedWriter.flush();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        });
        thread.start();
    }



}
