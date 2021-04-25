package Server;

import java.io.IOException;
import java.net.Socket;

public class Listener2 implements Runnable {
    private final Socket client;

    public Listener2(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Main.sendFile(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
