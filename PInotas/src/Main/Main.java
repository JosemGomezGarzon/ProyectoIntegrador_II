package Main;

import Controlador.*;
import Modelo.*;
import Vistas.*;

public class Main {

    public static void main(String[] args) {    
        SQLConectar cx = new SQLConectar();
        cx.conectar();
        ControlLogin con = new ControlLogin();

    }
}
