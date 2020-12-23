package CopiaBinaryFile;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file;
        File nuovoFile = new File("copia");
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci percorso al file: ");
        file = new File(input.nextLine());

        writeBinary(nuovoFile, readBinary(file));
    }

    static void writeBinary(File file, byte[] bytes){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] readBinary(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream reader = new BufferedInputStream(fis);

            byte[] bytes = reader.readAllBytes();

            reader.close();
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
