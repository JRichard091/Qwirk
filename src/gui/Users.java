package gui;

import java.sql.*;

/**
 * Created by Carlo on 27/03/2017.
 */
public abstract class Users {
    private static String nome;
    private static String cognome;
    //private static String email;
    private static String username;
    private static String password;


//INSERT USER
    public static void set_user(String nome, String cognome, String email, String username, String password) {
        JDBC.connessione();

        try {
            Statement cmd = JDBC.ret_con().createStatement();
            cmd.executeUpdate("INSERT into users(Nome, Cognome, Email, Username, Password) values('" + nome + "','" + cognome + "','" + email + "','" + username + "','" + password + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.close_con();
    }
//SELECT NOME USER
    public static String get_user_nome(String email) {
        JDBC.connessione();

        try {
            Statement cmd = JDBC.ret_con().createStatement();
            String query = "SELECT Nome FROM users WHERE Email= '" + email + "'";
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                nome = res.getString("Nome");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return nome;
       //gui.JDBC.close_con();

    }

    //SELECT COGNOME USER
    public static String get_user_cognome(String email) {
        JDBC.connessione();

        try {
            Statement cmd = JDBC.ret_con().createStatement();
            String query = "SELECT Cognome FROM users WHERE Email= '" + email + "'";
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                cognome = res.getString("Cognome");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cognome;
        //gui.JDBC.close_con();
    }
    //SELECT EMAIL
    public static int check_email(String email_insert){
        JDBC.connessione();
        int sizeEmail=0;
        try {
            Statement cmd = JDBC.ret_con().createStatement();
            String query = "SELECT * FROM users WHERE Email = '" + email_insert + "'";
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                sizeEmail = res.getRow();
            }

            System.out.println("numero record email: "+sizeEmail);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizeEmail;
    }

    //SELECT USERNAME USER
    public static String get_user_username(String email) {
        JDBC.connessione();

        try {
            Statement cmd = JDBC.ret_con().createStatement();
            String query = "SELECT Username FROM users WHERE Email= '" + email + "'";
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                username = res.getString("Username");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return username;
        //gui.JDBC.close_con();
    }

    //SELECT ALL USERNAME USER
    public static int check_username(String username_insert) {
        JDBC.connessione();
        int sizeUsername =0;
        try {
            Statement cmd = JDBC.ret_con().createStatement();
            String query = "SELECT * FROM users WHERE USERNAME = '" + username_insert + "'";
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                sizeUsername = res.getRow();
            }

            System.out.println("numero record username: "+sizeUsername);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sizeUsername;
        //gui.JDBC.close_con();
    }

    //SELECT PASSWORD USER
    public static String get_user_password(String email) {
        JDBC.connessione();

        try {
            Statement cmd = JDBC.ret_con().createStatement();
            String query = "SELECT Password FROM users WHERE Email= '" + email + "'";
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                password = res.getString("Password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return password;
        //gui.JDBC.close_con();
    }
}