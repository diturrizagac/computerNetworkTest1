package client;

import server.tcpServer;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tcpClient {
    public static void main(String[] args) {

        final String HOST = "127.0.0.1";
        final int PORT = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket socket = new Socket(HOST,PORT);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("hola mundo desde el cliente");
            String message = in.readUTF();

            System.out.println(message);

            socket.close();
        } catch (IOException e) {
            Logger.getLogger(tcpClient.class.getName()).log(Level.SEVERE,null,e);
        }

//        String clientPhrase;
//        String serverPhrase;
//
//        BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));
//        Socket clientSocket = new Socket("localhost", 5000);
//        DataOutputStream outputToServer = new DataOutputStream(clientSocket.getOutputStream());
//        BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        clientPhrase = inputFromServer.readLine();
//        outputToServer.writeBytes(clientPhrase + '\n');
//        serverPhrase = inputFromServer.readLine();
//        System.out.println("FROM SERVER: " + serverPhrase);
//        clientSocket.close();

    }
}
