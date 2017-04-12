import gui.JDBC;

import java.sql.*;


/**
 * Created by Carlo on 05/04/2017.
 */
public class Contacts {
    private static int ID_1;
    private static int ID_2;
    private static String nome;

    //INSERT CONTACT
    public static void set_contact(int ID_1, int ID_2, String nome) {
        JDBC.connessione();

        try {
            Statement cmd = JDBC.ret_con().createStatement();
            cmd.executeUpdate("INSERT into contacts(ID_US_1, ID_US_2, Nome) values('"+ ID_1 +"','"+ ID_2 +"','" + nome + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.close_con();
    }

    //SELECT ID_US_2
    public static int get_ID_US_2(int ID_1) {
        JDBC.connessione();

        try {
            Statement cmd = JDBC.ret_con().createStatement();
            String query = "SELECT ID_US_2 FROM contacts WHERE ID_US_1 = " + ID_1 + "";
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                ID_2 = res.getInt("ID_US_2");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return ID_2;
        //gui.JDBC.close_con();

    }

    //SELECT Nome CONTATTO
    public static String get_nome_contatto(int ID_1) {
        JDBC.connessione();

        try {
            Statement cmd = JDBC.ret_con().createStatement();
            String query = "SELECT Nome FROM contacts WHERE ID_US_1 = " + ID_1 + "";
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
}
