package Modelo;

import Vistas.Login;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlador.SQLConectar;

public class LoginVerify {

    Login log;
    SQLConectar cx;

    public LoginVerify(Login log) {
        this.log = new Login();
        this.cx = new SQLConectar();
        
    }

    public void showPass() {
        if (log.JshowPass.isEnabled()) {
            if (log.JshowPass.isSelected()) {
                log.Jpass.setEchoChar((char) 0);
            } else {
                log.Jpass.setEchoChar('*');
            }
        }
    }

 public boolean verifyLogin(String username, String password, String rol) {
        try {
            String query = "SELECT * FROM login WHERE Usuario = ? AND Contraseña = ? AND Rol = ?";
            PreparedStatement ps = cx.conectar().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, rol);

            ResultSet rs = ps.executeQuery();

            return rs.next(); // Si hay un resultado, significa que las credenciales son válidas.

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
        }
        return false; // Si hay algún error o no hay resultados, consideramos las credenciales como inválidas.
    }
}