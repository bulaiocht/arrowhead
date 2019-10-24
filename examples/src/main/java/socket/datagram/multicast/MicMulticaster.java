package socket.datagram.multicast;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MicMulticaster {

    public static void main(String[] args) throws IOException{
        String hostname = "230.0.0.0";
        int port = 5555;
        InetAddress address = InetAddress.getByName(hostname);

        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, true);
        TargetDataLine microphone;
        DatagramSocket socket = null;

        try {
            microphone = AudioSystem.getTargetDataLine(format);
            microphone.open(format);
            microphone.start();

            int numBytesRead;
            int chunkSize = 1024;
            byte[] buffer = new byte[microphone.getBufferSize()];

            socket = new DatagramSocket();

            while (true) {

                numBytesRead = microphone.read(buffer, 0, chunkSize);
                if (numBytesRead < 0) {
                    break;
                }

                DatagramPacket request = new DatagramPacket(buffer, numBytesRead, address, port);
                socket.send(request);
            }

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
