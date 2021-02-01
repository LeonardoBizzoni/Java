package modificaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner inputNum = new Scanner(System.in);
    static Scanner inputStr = new Scanner(System.in);

    public static void main(String[] args) {
	    int input;

        File file = new File("testo");

        try {
            Scanner fr = new Scanner(file);

            List<String> righe = new ArrayList<>();

            while(fr.hasNextLine()){
                righe.add(fr.nextLine());
            }

            do {
                System.out.print("1) visualizza righe numerate\n" +
                        "2) modifica una riga\n" +
                        "3) cancella una riga\n" +
                        "4) salva nel file\n" +
                        "0) chiudi\n> ");

                input = inputNum.nextInt();

                switch (input){
                    case 1:
                        printFile(righe);
                        break;
                    case 2:
                        editLine(righe);
                        break;
                    case 3:
                        delLine(righe);
                        break;
                    case 4:
                        saveFile(file, righe);
                        break;
                }
            }while (input != 0);

            inputNum.close();
            inputStr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void saveFile(File file, List<String> righe) {
        try {
            FileWriter fw = new FileWriter(file);

            for (int i=0;i<righe.size();i++){
                fw.append(righe.get(i)+"\n");
            }

            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void delLine(List<String> file) {
        System.out.print("Numero della riga: ");
        file.remove(inputNum.nextInt()-1);
    }

    private static void editLine(List<String> file) {
        System.out.print("Numero della riga: ");
        int ln = inputNum.nextInt()-1;
        System.out.println("Nuova riga: ");
        file.set(ln, inputStr.nextLine());
    }

    private static void printFile(List<String> file) {
        for (int i=0;i<file.size();i++){
            System.out.println(i+1 + " " + file.get(i));
        }
    }
}
