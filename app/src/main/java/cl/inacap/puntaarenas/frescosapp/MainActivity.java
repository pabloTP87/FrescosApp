package cl.inacap.puntaarenas.frescosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.puntaarenas.frescosapp.Modelo.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario;

    EditText txtContraseña;
    Button btnIngresar;
    String username;
    String password;
    Usuario user1;
    Usuario user2;
    ArrayList<Usuario> usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario=(EditText)findViewById(R.id.usuario);
        txtContraseña=(EditText) findViewById(R.id.password);
        btnIngresar=(Button) findViewById(R.id.ingresar);


        usuario= new ArrayList <Usuario>();
        user1=new Usuario("ptomey","pablo123");
        user2=new Usuario("gmancilla","galmier123");
        usuario.add(0,user1);
        usuario.add(1,user2);



    }
    public void enviar(View view){
        username=txtUsuario.getText().toString();
        password=txtContraseña.getText().toString();

        if(usuario.get(0).getNombre().equals(username) && usuario.get(0).getContraseña().equals(password)){
            Intent intent=new Intent(this,InicioActivity.class);
            startActivity(intent);
            Toast msg=Toast.makeText(this,"usuario correcto",Toast.LENGTH_LONG);
            msg.show();
        }
        else if(usuario.get(1).getNombre().equals(username) && usuario.get(1).getContraseña().equals(password)){
            Intent intent=new Intent(this,InicioActivity.class);
            startActivity(intent);
            Toast msg=Toast.makeText(this,"usuario correcto",Toast.LENGTH_LONG);
            msg.show();
        }
        else {
            Toast msg=Toast.makeText(this,"usuario incorrecto",Toast.LENGTH_LONG);
            msg.show();
        }
    }
}
