package Server;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Listener implements Runnable {
    private Socket client;
    private File folder;
    private File[] listaFile;
    private DataOutputStream sender;
    private FileInputStream fileReader;
    private int data;

    public Listener(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            Scanner clientInput = new Scanner(client.getInputStream());

            // lista dei nomi dei file
            folder = new File("/home/leo/Docs/School/Java/GuiFileServer/Files/");
            listaFile = folder.listFiles();

            // invia la lista di file al client
            for (int i = 0; i < listaFile.length; i++) {
                pw.println(listaFile[i].getName());
                pw.flush();
            }
            pw.println("finito");
            pw.flush();

            // invia il file al client
            sender = new DataOutputStream(client.getOutputStream());
            fileReader = new FileInputStream("/home/leo/Docs/School/Java/GuiFileServer/Files/" + clientInput.nextLine());

            do {
                sender.write((data = fileReader.read()));
            } while ((data != -1));
            sender.write(-1);
            System.out.println("File inviato");

            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
