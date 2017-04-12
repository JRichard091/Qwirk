package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Fabrizio on 23/12/2016.
 */
public class PasswordScreen extends JFrame implements ActionListener {

    private JPanel rootPassword;
    private JButton btnConfirm;
    private JLabel imgLogo;
    private JLabel lblEmail;
    private JTextField textField1;
    private JButton btnBack;

    public PasswordScreen(){
        super("Quirk IM");
        this.setSize(380, 680);
        setContentPane(rootPassword);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        btnBack.addActionListener(this);
        setVisible(true);
        setResizable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            this.dispose();
            new LandingScreen();
        }
    }
}
