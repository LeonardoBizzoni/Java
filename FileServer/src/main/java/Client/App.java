package Client;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        FileOutputStream fos;
        DataInputStream dis;
        int data;

        try {
            Socket socket = new Socket("127.0.0.1", 8001);

            dis = new DataInputStream(socket.getInputStream());
            fos = new FileOutputStream("file");

            while((data = dis.read()) != -1) {
                fos.write(data);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
