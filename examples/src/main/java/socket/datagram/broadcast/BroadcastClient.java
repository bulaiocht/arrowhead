package socket.datagram.broadcast;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BroadcastClient {
    public static void main(String[] args) throws IOException, LineUnavailableException {

        String hostname = "255.255.255.255";
        int port = 4555;
        InetAddress address = InetAddress.getByName(hostname);

        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, true);
        SourceDataLine speakers = AudioSystem.getSourceDataLine(format);
        speakers.open(format);
        speakers.start();

        DatagramSocket receiverSocket = new DatagramSocket(port, address);

        while (true) {
            byte[] buff = new byte[1024];
            DatagramPacket response = new DatagramPacket(buff, buff.length);
            receiverSocket.receive(response);
            int numRead = response.getData().length;
            System.out.println(numRead);
            speakers.write(response.getData(), 0, numRead);

        }

    }
}
