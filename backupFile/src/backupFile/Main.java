package backupFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("originale");
        File copia = new File("copia");

        try {
            FileWriter fw = new FileWriter(copia);
            Scanner fileReader = new Scanner(file);

            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            while(fileReader.hasNextLine()){
                fw.write(fileReader.nextLine()+"\n");
            }

            fw.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
