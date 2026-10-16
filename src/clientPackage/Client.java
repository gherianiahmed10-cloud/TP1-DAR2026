
package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Saisir un entier : ");
            int x = sc.nextInt();

            Socket socket = new Socket("localhost", 5000);
            System.out.println("Client connecté");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            dos.writeInt(x);
            dos.flush();

            int resultat = dis.readInt();

            System.out.println("Résultat reçu : " + resultat);

            socket.close();
            sc.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
