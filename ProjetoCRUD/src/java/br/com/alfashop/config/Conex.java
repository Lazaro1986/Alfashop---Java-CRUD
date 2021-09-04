package br.com.alfashop.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lázaro
 */
public class Conex {
    
    public static Connection getConnection(){
        Connection conn;
        try{
            //conectar com o banco de dados
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost/alfashop";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(host, user, pass);
        }
        catch(Exception e){
            conn = null;
        }
        return conn;
    }
}
