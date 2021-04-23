package Server;

import java.io.*;
import java.net.Socket;

public class Listener implements Runnable {
    private final Socket client;
    private File folder;
    private File[] listaFile;
    private PrintWriter pw;


    public Listener(Socket client) {
        this.client = client;

        try {
            this.pw = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // lista dei nomi dei file
            folder = new File("Files/");
            listaFile = folder.listFiles();

            // invia la lista di file al client
            for (File file : listaFile) {
                pw.println(file.getName());
                pw.flush();
            }
            pw.println("");
            pw.flush();

            Main.sendFile(client);

            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
