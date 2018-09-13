package cl.inacap.puntaarenas.frescosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GestionClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_cliente);
    }

    public void ingresarClienteOnClick(View view){
        Intent intent=new Intent(this,IngresarClienteActivity.class);
        startActivity(intent);
    }

    public void mostrarClienteOnClick(View view){
        Intent intent=new Intent(this,ListaClienteActivity.class);
        startActivity(intent);
    }

    public void modificarClienteOnClick(View view){
        Intent intent=new Intent(this,ModificarClienteActivity.class);
        startActivity(intent);
    }
}
