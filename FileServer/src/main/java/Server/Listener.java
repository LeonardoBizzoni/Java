package Server;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

public class Listener implements Runnable {
    private final Socket client;
    private int data;

    public Listener(final Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            final DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            final FileInputStream fis = new FileInputStream("file.jpg");

            do {
                dos.writeByte((data = fis.read()));
            } while (data != -1);

            fis.close();
            dos.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
