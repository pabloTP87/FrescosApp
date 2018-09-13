package cl.inacap.puntaarenas.frescosapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InicioActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);



    }

    public void clientesOnClick(View view){
        Intent intent=new Intent(this,GestionClienteActivity.class);
        startActivity(intent);
    }

    public void pedidosOnClick(View view){
        Intent intent=new Intent(this,IngresarPedidoActivity.class);
        startActivity(intent);
    }


}
