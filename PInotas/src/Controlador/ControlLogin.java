package Controlador;

import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import javax.swing.JOptionPane;

public class ControlLogin implements ActionListener {

    Login log;
    LoginVerify pass;
    Administrador ad;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControlLogin() {

        this.log = new Login();
        this.ad = new Administrador();
        log.setVisible(true);
        log.setTitle("Sistema de notas");
        log.jbIngresar.addActionListener(this);
        log.Juser.addActionListener(this);
        log.JshowPass.addActionListener(this);
        log.Jpass.addActionListener(this);
        this.pass = new LoginVerify(log);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log.JshowPass) {
            if (log.JshowPass.isSelected()) {
                log.Jpass.setEchoChar((char) 0);
            } else {
                log.Jpass.setEchoChar('*');
            }
        }
        
        if (e.getSource() == log.jbIngresar) {         
            String username = log.Juser.getText();
            String password = String.valueOf(log.Jpass.getPassword());
            String rol = (String) log.jcRol.getSelectedItem();
            if (pass.verifyLogin(username, password, rol)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesion establecido", "Inicio de sesion", JOptionPane.INFORMATION_MESSAGE);
                // Realiza las acciones necesarias después del inicio de sesión exitoso
                log.dispose();
                ControlAdmin controlAdmin = new ControlAdmin();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario, contraseña o rol incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                // Realiza las acciones necesarias después de un inicio de sesión fallido
            }
        }
    }

}
