package Server;

import java.net.Socket;

public class Listener2 implements Runnable {
    private final Socket client;

    public Listener2(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        Main.sendFile(client);
        try {
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
