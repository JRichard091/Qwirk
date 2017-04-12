package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Fabrizio on 21/12/2016.
 */
public class LandingScreen extends JFrame implements ActionListener {
    private JPanel rootLanding;
    private JButton btnLogin;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnSignup;
    private JEditorPane lblForgotPassword;
    private JLabel imgLogo;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JButton button1;

    public LandingScreen() {
        super("Quirk IM");
        this.setSize(380, 680);
        ImageIcon logoWindow = new ImageIcon("src/img/QwirkLogoIcon.png");
        super.setIconImage(logoWindow.getImage());
        setContentPane(rootLanding);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblForgotPassword.setText("<HTML><a href=''>Forgot your password? Click here</a></HTML>");
        lblForgotPassword.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
            }
        });
        button1.addActionListener(this);
        btnLogin.addActionListener(this);
        btnLogin.setEnabled(false);
        btnSignup.addActionListener(this);
        lblForgotPassword.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new PasswordScreen();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        setVisible(true);
        setResizable(false);

        txtUsername.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Sto inserendo qualcosa al'username");
                changeBtnStatus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Sto togliendo qualcosa al'username");
                changeBtnStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Sto cambiando qualcosa al'username");
                changeBtnStatus();
            }
        });
        txtPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Sto inserendo qualcosa alla Password");
                changeBtnStatus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Sto togliendo qualcosa alla Password");
                changeBtnStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Sto cambiando qualcosa alla Password");
                changeBtnStatus();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            //JOptionPane.showConfirmDialog(LandingScreen.this, "LOGIN");

        }
        else if (e.getSource() == btnSignup) {
            this.dispose();
            new RegisterScreen("","","","","");
        }
        else if (e.getSource()==button1){
            this.dispose();
            new HomeScreen2();
        }
    }
    private void changeBtnStatus() {
        if (txtUsername.getText().isEmpty() || txtPassword.getPassword().length < 1) {
            btnLogin.setEnabled(false);
        } else {
            //if(password==repeatpassword){         //confrontare le 2 password
            btnLogin.setEnabled(true);
            //}
        }
    }

}