
package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("Je suis un client pas encore connecté");

        try {
            Socket socket = new Socket("127.0.0.1", 5000);

            System.out.println("Je suis un client connecté");

            socket.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
