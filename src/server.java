
package serverPackage;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {

        try {
            InetAddress adresse = InetAddress.getByName("192.168.1.159");

            ServerSocket serveur = new ServerSocket();
            serveur.bind(new InetSocketAddress(adresse, 5000));

            System.out.println("Serveur en attente...");

            Socket client = serveur.accept();
            System.out.println("Client connecté");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            int choix, x;
            double resultat;

            do {
                choix = dis.readInt();

                if (choix != 0) {
                    x = dis.readInt();

                    switch (choix) {
                        case 1:
                            resultat = x + 5;
                            break;

                        case 2:
                            resultat = x - 5;
                            break;

                        case 3:
                            resultat = x * 5.0;
                            break;

                        case 4:
                            resultat = x / 5.0;
                            break;

                        default:
                            resultat = 0;
                    }

                    System.out.println("Choix : " + choix);
                    System.out.println("Nombre : " + x);
                    System.out.println("Résultat : " + resultat);

                    dos.writeDouble(resultat);
                    dos.flush();
                }

            } while (choix != 0);

            System.out.println("Fin de communication");

            dis.close();
            dos.close();
            client.close();
            serveur.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
