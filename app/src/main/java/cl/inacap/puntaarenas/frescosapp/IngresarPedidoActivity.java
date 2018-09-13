package cl.inacap.puntaarenas.frescosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import cl.inacap.puntaarenas.frescosapp.Modelo.ListaProductoAdapter;
import cl.inacap.puntaarenas.frescosapp.Modelo.TiendaDataBaseHelper;

public class IngresarPedidoActivity extends AppCompatActivity {

    TiendaDataBaseHelper helper=new TiendaDataBaseHelper(this);

    private String[] nombres=new String[]{"palta","tomate"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_pedido);

        final ListView lista=(ListView) findViewById(R.id.listaImg);
        ListaProductoAdapter adapter= new ListaProductoAdapter(this,helper.listaNombres(helper.getReadableDatabase()),
                helper.listaImagenes(helper.getReadableDatabase()));
        lista.setAdapter(adapter);
    }

    public void realizarPedidoOnClick(View view){
        Intent intent=new Intent(this,RealizarPedidoActivity.class);
        startActivity(intent);
    }

    public void entregadosOnClick(View view){
        Intent intent=new Intent(this,ListaPedidosEntregadosActivity.class);
        startActivity(intent);
    }
}
