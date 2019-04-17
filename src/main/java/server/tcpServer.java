package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tcpServer {

    public static void main(String[] args) {
        ServerSocket server;
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        final int PORT = 5000;


        try{
            server = new ServerSocket(PORT);
            System.out.println("Server ready!!");
            // always listening
            while (true) {
                socket = server.accept();

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                String message = in.readUTF();

                System.out.println(message);

                out.writeUTF("Hola mundo desde el servidor");

                socket.close();

                System.out.println("cliente desconectado");
//                BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
//                DataOutputStream outputToClient = new DataOutputStream(socketConnection.getOutputStream());
//                clientPhrase = inputFromClient.readLine();
//                phraseToCapital = clientPhrase.toUpperCase() + '\n';
//                outputToClient.writeBytes(phraseToCapital);
            }
        } catch (IOException e) {
            Logger.getLogger(tcpServer.class.getName()).log(Level.SEVERE,null,e);
        }

    }
}
