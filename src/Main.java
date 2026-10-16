
package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serveur = new ServerSocket(5000);

            System.out.println("Je suis un serveur en attente de la connexion d'un client");

            Socket client = serveur.accept();

            System.out.println("Un client est connecté");

            client.close();
            serveur.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
