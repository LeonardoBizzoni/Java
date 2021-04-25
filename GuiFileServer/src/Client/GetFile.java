package Client;

import java.io.*;
import java.net.Socket;

public class GetFile implements Runnable {
    private DataInputStream receiver;
    private FileOutputStream fileWriter;
    private Socket sock;

    public GetFile(Socket sock, String fileName) {
            this.sock = sock;

        try {
            fileWriter = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        int data;

        try {
            receiver = new DataInputStream(sock.getInputStream());

            while ((data = receiver.read()) != -1) {
                fileWriter.write(data);
            }

            fileWriter.flush();
            fileWriter.close();
            receiver.close();
            sock.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
