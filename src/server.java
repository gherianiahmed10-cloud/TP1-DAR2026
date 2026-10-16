
package serverPackage;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket serveur = new ServerSocket(5000);

            System.out.println("Serveur en attente...");

            Socket client = serveur.accept();
            System.out.println("Client connecté");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            int x = dis.readInt();
            System.out.println("Nombre reçu : " + x);

            int resultat = x * 5;
            System.out.println("Résultat : " + resultat);

            dos.writeInt(resultat);
            dos.flush();

            client.close();
            serveur.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
