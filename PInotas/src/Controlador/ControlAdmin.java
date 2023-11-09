package Controlador;

import Vistas.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.InsertData;
import Modelo.LoginVerify;
import Vistas.Login;

public class ControlAdmin implements ActionListener {
    
    Login log;
    Administrador adi;
    InsertData ins;
    LoginVerify loginverify;

    @SuppressWarnings("LeakingThisInConstructor")
    public ControlAdmin() {
        this.loginverify = new LoginVerify(log);
        this.adi = new Administrador();
        this.ins = new InsertData();
        adi.setVisible(true);
        adi.setTitle("Administrador");
        adi.gg.addActionListener(this);
        adi.jbAsignarE.addActionListener(this);
        adi.jbGuardarP.addActionListener(this);
        adi.jbAsignarP.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adi.gg) {
            String nombre = adi.txtNombreE.getText();
            String rol = adi.txtRolE.getText();
            String usuario = adi.txtUsuarioE.getText();
            int identificacion = Integer.parseInt(adi.txtIdenE.getText());
            String programa = adi.txtProgrE.getText();
            ins.registerStudent(nombre, rol, usuario, identificacion, programa);
        }else{}
    }

}
 