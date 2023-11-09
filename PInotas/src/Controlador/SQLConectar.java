package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;


public class SQLConectar {
    String bd = "proyecto2";
    String url = "jdbc:mysql://localhost:3306/";
    String user ="root";
    String pass = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public SQLConectar(){
        
        }
        public Connection conectar(){
            try {
                Class.forName(driver);
                cx = DriverManager.getConnection(url+bd, user, pass);
                //System.out.println("Conexion Establecida con la base de datos: " + bd);
            } catch (Exception ex) {
                System.out.println("Conexion interrumpida con la base de datos: " + bd);
            }
            return cx;
        }
               
    }

