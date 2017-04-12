package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Fabrizio on 23/12/2016.
 */
public class RegisterScreen extends JFrame implements ActionListener {
    private JPanel rootRegister;
    //private Panel rootRegister2 = new Panel();
    private JButton btnConfirm;
    private JLabel lblUsername;
    private JTextField textUsername;
    private JLabel lblPassword;
    private JPasswordField textPassword;
    private JLabel lblRepeatPassword;
    private JPasswordField textRepeatPassword;
    private JButton btnBack;
    private JLabel lblEmail;
    private JTextField textEmail;
    private JLabel imgLogo;
    private JTextField textSurname;
    private JTextField textName;
    private String name = new String();
    private String surname = new String("");
    private String email = new String("");
    private String username = new String("");
    private String password = new String("");
    private String repeatpassword = new String("");

    public RegisterScreen(String status, String nameF, String surnameF, String emailF, String usernameF) {
        super("Quirk IM");
        this.setSize(380, 680);
        setContentPane(rootRegister);
        //rootRegister.add(rootRegister2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnConfirm.addActionListener(this);
        btnConfirm.setEnabled(false);
        btnBack.addActionListener(this);

        setVisible(true);
        setResizable(false);
        //status
       /* if (status=="NoMatchRepeat"){
            Border border = BorderFactory.createLineBorder(Color.red);
            textRepeatPassword.setBorder(border);
            textName.setText(nameF);
            textSurname.setText(surnameF);
            textEmail.setText(emailF);
            textUsername.setText(usernameF);
            JOptionPane.showMessageDialog(null, "Passwords do not match... Bitch!");
        }
        else if (status=="EmailAlreadyExists"){
            Border border = BorderFactory.createLineBorder(Color.red);
            textEmail.setBorder(border);
            textName.setText(nameF);
            textSurname.setText(surnameF);
            textUsername.setText(usernameF);
            JOptionPane.showMessageDialog(null, "E-mail is already used Bitch!");
        }
        else if (status=="UsernameAlreadyExists"){
            Border border = BorderFactory.createLineBorder(Color.red);
            textUsername.setBorder(border);
            textName.setText(nameF);
            textSurname.setText(surnameF);
            textEmail.setText(emailF);
            JOptionPane.showMessageDialog(null, "Username is already used Bitch!");
        }
        else if (status=="Username&EmailAlreadyExists"){
            Border border = BorderFactory.createLineBorder(Color.red);
            textUsername.setBorder(border);
            textName.setText(nameF);
            textSurname.setText(surnameF);
            textEmail.setBorder(border);
            JOptionPane.showMessageDialog(null, "Username and e-mail are already used. Fuck you and thanks for using Qwirk!");
        }
        else{
            //nothing
        }*/

        textName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //System.out.println("Sto inserendo qualcosa al nome");
                changeBtnStatus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //System.out.println("Sto togliendo qualcosa al nome");
                changeBtnStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //System.out.println("Sto cambiando qualcosa al nome");
                changeBtnStatus();
            }
        });
        textSurname.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //System.out.println("Sto inserendo qualcosa al cognome");
                changeBtnStatus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //System.out.println("Sto togliendo qualcosa al cognome");
                changeBtnStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //System.out.println("Sto cambiando qualcosa al cognome");
                changeBtnStatus();
            }
        });
        textEmail.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //System.out.println("Sto inserendo qualcosa all'email");
                changeBtnStatus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //System.out.println("Sto togliendo qualcosa all'email");
                changeBtnStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //System.out.println("Sto cambiando qualcosa all'email");
                changeBtnStatus();
            }
        });
        textUsername.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //System.out.println("Sto inserendo qualcosa all'username");
                changeBtnStatus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //System.out.println("Sto togliendo qualcosa all'username");
                changeBtnStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //System.out.println("Sto cambiando qualcosa all'username");
                changeBtnStatus();
            }
        });
        textPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //System.out.println("Sto inserendo qualcosa alla password");
                changeBtnStatus();
                password=String.valueOf(textPassword.getPassword());
                System.out.println("Password: " + password + "; textName: " + textPassword.getPassword());

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //System.out.println("Sto togliendo qualcosa alla password");
                changeBtnStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //System.out.println("Sto cambiando qualcosa alla password");
                changeBtnStatus();
            }
        });
        textRepeatPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //System.out.println("Sto inserendo qualcosa alla password 2");
                changeBtnStatus();
                repeatpassword=String.valueOf(textRepeatPassword.getPassword());
                System.out.println("Repeat Password: " + repeatpassword + "; textName: " + textRepeatPassword.getPassword());

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //System.out.println("Sto togliendo qualcosa alla password 2");
                changeBtnStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //System.out.println("Sto cambiando qualcosa alla password 2");
                changeBtnStatus();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            this.dispose();
            new LandingScreen();
        } else if (e.getSource() == btnConfirm) {
            System.out.println("Dentro ciclo confirm");
            //this.dispose();
            name = textName.getText();
            surname = textSurname.getText();
            email = textEmail.getText();
            username = textUsername.getText();
            //password=textPassword.getPassword().toString();
            //repeatpassword=textRepeatPassword.getPassword().toString();
            System.out.println("Nome: " + name + "; textName: " + textName.getText());
            System.out.println("Cognome: " + surname + "; textSurname: " + textSurname.getText());
            System.out.println("Email: " + email.toLowerCase() + "; textEmail: " + textEmail.getText());
            System.out.println("Username: " + username + "; textUsername: " + textUsername.getText());
            try{
                System.out.println("Password: " + password + "; textPSSHash: " + hashPassword(password));
                System.out.println("RepeatPassword: " + repeatpassword + "; textRePSSHash: " + hashPassword(repeatpassword));
            }
            catch (NoSuchAlgorithmException e1){
                System.out.println(e1);
            }

            int sizeUsername = Users.check_username(username);
            int sizeEmail = Users.check_email(email.toLowerCase());
            String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            if (sizeUsername>0 && sizeEmail>0){
                //Username&EmailAlreadyExists
                System.out.println("Username e password già presente");
                Border border = BorderFactory.createLineBorder(Color.red);
                textUsername.setBorder(border);
                textName.setText(name);
                textSurname.setText(surname);
                textEmail.setBorder(border);
                JOptionPane.showMessageDialog(null, "Username and e-mail are already used. Fuck you and thanks for using Qwirk!");
            }
            else if (sizeUsername>0){
                //UsernameAlreadyExists
                System.out.println("Username già presente");
                Border oldBorder= textName.getBorder();
                Border border = BorderFactory.createLineBorder(Color.red);
                textUsername.setBorder(border);
                textEmail.setBorder(oldBorder);
                textName.setText(name);
                textSurname.setText(surname);
                textEmail.setText(email);
                JOptionPane.showMessageDialog(null, "Username is already used Bitch!");
            }
            else if (sizeEmail>0){
                //EmailAlreadyExists
                System.out.println("Email già presente");
                Border oldBorder= textName.getBorder();
                Border border = BorderFactory.createLineBorder(Color.red);
                //Border border2 = BorderFactory.createLineBorder();
                textUsername.setBorder(oldBorder);
                textEmail.setBorder(border);
                textName.setText(name);
                textSurname.setText(surname);
                textUsername.setText(username);
                JOptionPane.showMessageDialog(null, "E-mail is already used Bitch!");
            }
//////////////////////////////SUCAa
            else if (email.matches(emailPattern)){
                Border oldBorder = textName.getBorder();
                textEmail.setBorder(oldBorder);
                textUsername.setBorder(oldBorder);
                System.out.println("Email valida");

                if (password.equals(repeatpassword)) {

                    try {
                        Users.set_user(name, surname, email.toLowerCase(), username, hashPassword(password));
                    } catch (NoSuchAlgorithmException e1) {
                        e1.printStackTrace();
                    }
                    new LandingScreen();
                    this.dispose();
                }
                else{
                    //NoMatchRepeat
                    System.out.println("Le password non corrispondono");
                    Border border = BorderFactory.createLineBorder(Color.red);
                    textRepeatPassword.setBorder(border);
                    textEmail.setBorder(oldBorder);
                    textUsername.setBorder(oldBorder);
                    textName.setText(name);
                    textSurname.setText(surname);
                    textEmail.setText(email);
                    textUsername.setText(username);
                    JOptionPane.showMessageDialog(null, "Passwords do not match... Bitch!");
                }
            }
            else {
                Border oldBorder = textName.getBorder();
                Border border = BorderFactory.createLineBorder(Color.red);
                textEmail.setBorder(border);
                textUsername.setBorder(oldBorder);
                System.out.println("Email non valida!");
                JOptionPane.showMessageDialog(null, "Enter a valid email address Bitch!");
            }
/////////////////////////////////////////
            /*else if (password.equals(repeatpassword)) {
                Border oldBorder= textName.getBorder();
                textRepeatPassword.setBorder(oldBorder);
                String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                if (email.matches(emailPattern)) {
                    textEmail.setBorder(oldBorder);
                    textUsername.setBorder(oldBorder);
                    System.out.println("Email valida");
                    Users.set_user(name, surname, email.toLowerCase(), username, password);
                    new LandingScreen();
                }
                else {

                    Border border = BorderFactory.createLineBorder(Color.red);
                    textEmail.setBorder(border);
                    System.out.println("Email non valida!");
                    JOptionPane.showMessageDialog(null, "Enter a valid email address Bitch!");
                }
            }
            else{
                //NoMatchRepeat
                System.out.println("Le password non corrispondono");
                Border oldBorder= textName.getBorder();
                Border border = BorderFactory.createLineBorder(Color.red);
                textRepeatPassword.setBorder(border);
                textEmail.setBorder(oldBorder);
                textUsername.setBorder(oldBorder);
                textName.setText(name);
                textSurname.setText(surname);
                textEmail.setText(email);
                textUsername.setText(username);
                JOptionPane.showMessageDialog(null, "Passwords do not match... Bitch!");

            }*/
        }
    }

    private void changeBtnStatus() {
        if (textName.getText().isEmpty() || textSurname.getText().isEmpty() || textEmail.getText().isEmpty()
                || textUsername.getText().isEmpty() || textPassword.getPassword().length < 1 || textRepeatPassword.getPassword().length < 1) {
            btnConfirm.setEnabled(false);
        } else {
                btnConfirm.setEnabled(true);
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }


}
