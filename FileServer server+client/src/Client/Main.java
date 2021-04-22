package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int data;

        try {
            Socket socket = new Socket("127.0.0.1", 8001);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            System.out.print("Inserire percorso al file: ");
            FileInputStream fis = new FileInputStream(input.nextLine());

            do{
                dos.writeByte((data = fis.read()));
            }while(data != -1);

            fis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
