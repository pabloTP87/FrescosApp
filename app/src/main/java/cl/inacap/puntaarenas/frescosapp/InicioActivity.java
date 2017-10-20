package cl.inacap.puntaarenas.frescosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cl.inacap.puntaarenas.frescosapp.Modelo.Cliente;

public class InicioActivity extends AppCompatActivity {
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


    }
    public void crear(View view){
        ArrayList<Cliente> listaClientes=new ArrayList<>();
        EditText txtCrear=(EditText)findViewById(R.id.ingresoCliente);
        String cliente=txtCrear.getText().toString();
        ListView list=(ListView) findViewById(R.id.listaClientes);

        if(listaClientes.isEmpty()){
            listaClientes.add(i,new Cliente(cliente));
            i++;
        }
        ArrayAdapter<Cliente> listaAdapter=new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1,listaClientes);
        list.setAdapter(listaAdapter);


    }
}
