package gui;

import java.sql.*;

/**
 * Created by Carlo on 22/03/2017.
 */
public abstract class JDBC {
    //public static void main (String args[]){
    static Connection con;
    static ResultSet res;
    static Statement cmd;

    public static void connessione(){
        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost/qwirk", "root", "");

            System.out.println("Connessione database effettuata");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close_con(){

        try {
//            res.close(); // chiudo risorse DB
            //cmd.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection ret_con(){
        return con;
    }
    //}

}
