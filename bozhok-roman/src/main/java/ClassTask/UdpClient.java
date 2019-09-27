package ClassTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class UdpClient {
    public static void main(String[] args) throws LineUnavailableException {
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, true);
//        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 1, 2, 44100, false);
        SourceDataLine speakers = AudioSystem.getSourceDataLine(format);
        speakers.open(format);
        speakers.start();
        try {
//            DatagramSocket receiverSocket = new DatagramSocket(5555, InetAddress.getByName("192.168.0.105"));
            DatagramSocket receiverSocket = new DatagramSocket(5555, InetAddress.getByName("192.168.1.44"));
            while (true) {
                byte[] buff = new byte[1024];
                DatagramPacket response = new DatagramPacket(buff, buff.length);
                receiverSocket.receive(response);
                int numRead = response.getData().length;
//                int offset = 0;
//
//                while (offset < numRead) {
//                    offset += speakers.write(buff, offset, numRead - offset);
//                }
//
                System.out.println(numRead);
                speakers.write(response.getData(), 0, numRead);
            }
        } catch (SocketTimeoutException ex) {
            System.out.println("Timeout error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
