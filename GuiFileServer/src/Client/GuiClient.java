package Client;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class GuiClient {
    private JPanel mainPanel;
    private JButton connectButton;
    private JList list1;
    private static DefaultListModel<String> model;

    private static Socket socket;
    private String tempName;
    private PrintWriter writeToServer;

    public GuiClient() {
        model = new DefaultListModel<>();
        list1.setModel(model);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (socket == null) {
                        socket = new Socket("127.0.0.1", 8001);
                        Scanner readFromServer = new Scanner(socket.getInputStream());

                        while (readFromServer.hasNextLine()) {
                            if ((tempName = readFromServer.nextLine()).equals(""))
                                break;
                            model.addElement(tempName);
                        }

                        readFromServer.close();
                    } else
                        JOptionPane.showMessageDialog(new JFrame(), "Già connesso al server");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    try {
                        socket = new Socket("127.0.0.1", 8001);
                        writeToServer = new PrintWriter(socket.getOutputStream(), true);

                        // invia il nome selezionato
                        tempName = list1.getSelectedValue().toString();
                        writeToServer.println(tempName);

                        // riceve il file
                        new Thread(new GetFile(socket, tempName)).start();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1", 8001);
            new PrintWriter(socket.getOutputStream(), true).println("");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket = null;

        JFrame frame = new JFrame("App");
        frame.setContentPane(new GuiClient().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
