package Modelo;

import Controlador.SQLConectar;
import Vistas.Administrador;
import Vistas.Login;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertData {

    Login log;
    Administrador ad;
    SQLConectar cx;
    LoginVerify loginVerify;

    public InsertData() {
        this.cx = new SQLConectar();
        this.ad = new Administrador();
        this.log = new Login();
        this.loginVerify = new LoginVerify(log);
    }

    public void registerStudent(String nombre, String rol, String usuario, int identificacion, String programa) {
        try {
            String username = log.Juser.getText();
            String password = String.valueOf(log.Jpass.getPassword());
            String rol1 = (String) log.jcRol.getSelectedItem();

            // Verificamos el inicio de sesión antes de realizar la inserción
            if (loginVerify.verifyLogin(username, password, rol1)) {
                // Si las credenciales son válidas, procedemos con la inserción
                String query = "INSERT INTO registro_estudiante(Nombre, Rol, Nombre_Usuario, Identificacion, Programa) values(?, ?, ?, ?, ?)";
                PreparedStatement ps = cx.conectar().prepareStatement(query);
                ps.setString(1, nombre);
                ps.setString(2, rol);
                ps.setString(3, usuario);
                ps.setInt(4, identificacion);
                ps.setString(5, programa);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro ingresado");
            } else {
                // Si las credenciales no son válidas, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Credenciales inválidas. No se puede realizar la inserción.");
            }

        } catch (Exception e) {
            System.out.println("Error al conectarse con la base de datos");
            e.printStackTrace();
        }
    }

    public void registerTeacher() {
        // Implementa la funcionalidad para registrar profesores aquí
    }

}
