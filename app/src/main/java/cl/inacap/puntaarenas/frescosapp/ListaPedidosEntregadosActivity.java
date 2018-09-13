package cl.inacap.puntaarenas.frescosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cl.inacap.puntaarenas.frescosapp.Modelo.Pedido;
import cl.inacap.puntaarenas.frescosapp.Modelo.TiendaDataBaseHelper;

public class ListaPedidosEntregadosActivity extends AppCompatActivity {

    TiendaDataBaseHelper helper=new TiendaDataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos_entregados);

        List<Pedido> pedidos=helper.listaPedidosEntregados(helper.getReadableDatabase());

        if (pedidos==null){
            TextView mensaje=(TextView)findViewById(R.id.mensajeEntregados);
            mensaje.setText("no hay pedidos entregados en el sistema");
        }else {
            ListView lista=(ListView)findViewById(R.id.listaPedidosEntregados);
            ArrayAdapter<Pedido> adapter=new ArrayAdapter<Pedido>(this,android.R.layout.simple_list_item_1,pedidos);
            lista.setAdapter(adapter);
        }
    }
}
