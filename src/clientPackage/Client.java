
package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            InetAddress adresse = InetAddress.getByName("192.168.1.159");

            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(adresse, 5000));

            System.out.println("Client connecté");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            int choix, x;

            do {
                System.out.println("\n===== CALCULATRICE =====");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("0. Quitter");

                System.out.print("Votre choix : ");
                choix = sc.nextInt();

                if (choix >= 0 && choix <= 4) {
                    dos.writeInt(choix);
                    dos.flush();

                    if (choix != 0) {
                        System.out.print("Saisir x : ");
                        x = sc.nextInt();

                        dos.writeInt(x);
                        dos.flush();

                        double resultat = dis.readDouble();
                        System.out.println("Résultat = " + resultat);
                    }
                } else {
                    System.out.println("Choix invalide");
                }

            } while (choix != 0);

            System.out.println("Fin de communication");

            dis.close();
            dos.close();
            socket.close();
            sc.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
