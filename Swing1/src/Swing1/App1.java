package Swing1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App1 {
    private JPanel mainPanel;
    private JLabel req;
    private JButton calc;
    private JLabel res;
    private JTextField resValue;
    private JTextField n1;
    private JTextArea textArea1;

    public App1() {
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num = Double.parseDouble(n1.getText());
                    resValue.setText(String.valueOf(num * 2));
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "Deve essere un numero!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App1().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
