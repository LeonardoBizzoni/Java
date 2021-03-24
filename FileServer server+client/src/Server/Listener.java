package Server;

import java.io.*;
import java.net.Socket;

public class Listener implements Runnable{
    private Socket client;
    private FileOutputStream fos;
    private DataInputStream dis;
    private int data;

    public Listener(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            dis = new DataInputStream(client.getInputStream());
            fos = new FileOutputStream(client.getRemoteSocketAddress().toString().replace("/", "") + ".png");

            while((data = dis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
