import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Scanner;

public class GuiLibreria {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTable author;
    private JTable editor;

    public GuiLibreria() {
        try {
            loadAuthor();
            loadEditor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAuthor() throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        File fileAuthor = new File("libri.csv");
        Scanner reader = new Scanner(fileAuthor);

        author.setModel(model);

        nameColumns(new String[] {"Titolo", "Autore", "Editor", "Numero Copie", "Prezzo"}, model);

        while(reader.hasNextLine()){
            model.insertRow(model.getRowCount(), reader.nextLine().split(","));
        }
    }

    private void loadEditor() throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        File fileEditor = new File("editor.csv");
        Scanner reader = new Scanner(fileEditor);

        editor.setModel(model);

        nameColumns(new String[] {"Nome Editor", "Indirizzo", "Numero Telefono"}, model);

        while(reader.hasNextLine()){
            model.insertRow(model.getRowCount(), reader.nextLine().split(","));
        }
    }

    private void nameColumns(String[] strings, DefaultTableModel model) {
        for (String s : strings) {
            model.addColumn(s);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new GuiLibreria().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
