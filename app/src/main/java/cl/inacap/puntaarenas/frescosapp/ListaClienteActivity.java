package cl.inacap.puntaarenas.frescosapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cl.inacap.puntaarenas.frescosapp.Modelo.Cliente;
import cl.inacap.puntaarenas.frescosapp.Modelo.TiendaDataBaseHelper;

public class ListaClienteActivity extends AppCompatActivity {

    TiendaDataBaseHelper helper=new TiendaDataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);

        List<Cliente> clientes=helper.listaCliente(helper.getReadableDatabase());

        if(clientes==null){
            TextView mensaje=(TextView)findViewById(R.id.mensaje);
            mensaje.setText("No existen Clientes Ingresados!");
        }else {

            ListView lista=(ListView)findViewById(R.id.listaClientes);
            ArrayAdapter<Cliente> adapter=new ArrayAdapter<Cliente>(this,android.R.layout.simple_list_item_1,clientes);
            lista.setAdapter(adapter);
        }
    }
}
