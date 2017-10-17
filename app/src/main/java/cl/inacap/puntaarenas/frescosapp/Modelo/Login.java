package cl.inacap.puntaarenas.frescosapp.Modelo;

import java.util.ArrayList;

/**
 * Created by 16652403-2 on 16/10/2017.
 */

public class Login {
    ArrayList<Usuario> usuarios;
    private int posicion;

    public Login() {

        usuarios = new ArrayList<Usuario>();
        usuarios.add(0,new Usuario("gmancilla","galmier123"));
        usuarios.add(1,new Usuario("ptomey","pablo123"));
    }
}
