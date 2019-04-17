package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class udpServer {
    public static void main(String[] args) {
        final int PORT = 5000;
        byte[] buffer = new byte[1024];
        DatagramSocket socketUDP;

        try {
            System.out.println("UDP server ready !");
            socketUDP = new DatagramSocket(PORT);

            while(true){
                DatagramPacket request = new DatagramPacket(buffer,buffer.length);
                socketUDP.receive(request);
                System.out.println("Receiving information from Client");
                String message = new String(request.getData());
                System.out.println(message);

                int clientPort = request.getPort();
                InetAddress address = request.getAddress();

                message = "Hello world, from server";
                buffer = message.getBytes();

                DatagramPacket response = new DatagramPacket(buffer,buffer.length,address,clientPort);
                socketUDP.send(response);
                System.out.println("Sending information from Client");
            }


        } catch (IOException e) {
            Logger.getLogger(udpServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }





}
