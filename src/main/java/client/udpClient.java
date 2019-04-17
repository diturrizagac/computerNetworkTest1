package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class udpClient {
    public static void main(String[] args) {
        final int SERVER_PORT = 5000;
        byte[] buffer = new byte[1024];

        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramSocket socketUDP = new DatagramSocket();
            String message = "Hello world from Client";
            buffer = message.getBytes();

            DatagramPacket answer = new DatagramPacket(buffer,buffer.length,serverAddress,SERVER_PORT);
            System.out.println("Send datagram");
            socketUDP.send(answer);

            DatagramPacket request = new DatagramPacket(buffer,buffer.length);
            System.out.println("Receive datagram");
            socketUDP.receive(request);
            message = new String(request.getData());
            System.out.println(message);
            socketUDP.close();
        } catch (IOException e) {
            Logger.getLogger(udpClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
