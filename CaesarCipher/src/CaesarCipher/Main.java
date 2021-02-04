package CaesarCipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static String[] caratteri;
    static String riga;
    static int ascii;

    public static void main(String[] args) throws IOException {
        File file = new File("testo.txt");
        Scanner fr;
        List<String> righe = new ArrayList<>();
        Scanner inputStr = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);

        String userIn;
        int in;

        if (!file.exists())
            file.createNewFile();

        try {
            fr = new Scanner(file);

            do {
                System.out.print("""
                        1) leggi file e decifra
                        2) stampa file
                        3) aggiungi riga
                        4) salva
                        0) uscire
                        >\s""");
                in = inputNum.nextInt();

                if (in == 1) {
                    decripta(righe, fr);
                } else if (in == 2) {
                    for (String s : righe) {
                        System.out.println(s);
                    }
                } else if (in == 3) {
                    System.out.print("Inserisci nuove righe: ");
                    while (true) {
                        userIn = inputStr.nextLine();
                        if (!userIn.equals("exit"))
                            righe.add(userIn);
                        else
                            break;
                    }
                } else if (in == 4) {
                    cripta(righe, file);
                }
            } while (in != 0);

            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void cripta(List<String> righe, File file) throws IOException {
        FileWriter fw = new FileWriter(file);

        for (String value : righe) {
            caratteri = value.split("");
            riga = "";
            for (String s : caratteri) {
                if (!s.equals(" ")) {
                    ascii = ((int) s.charAt(0) - 3);
                    ascii = ascii < 97 ? 122 - (96 - ascii) : ascii;
                    riga += ((char) ascii);
                } else {
                    riga += " ";
                }
            }

            fw.append(riga + "\n");
        }

        fw.flush();
        fw.close();
    }

    private static void decripta(List<String> righe, Scanner fr) {
        while (fr.hasNextLine()) {
            caratteri = fr.nextLine().toLowerCase().split("");
            riga = "";

            for (String s : caratteri) {
                if (!s.equals(" ")) {
                    ascii = ((int) s.charAt(0) + 3);
                    ascii = ascii > 122 ? 96 + (ascii - 122) : ascii;
                    riga += String.valueOf((char) ascii);
                } else {
                    riga += " ";
                }
            }

            righe.add(riga);
        }
    }

}
