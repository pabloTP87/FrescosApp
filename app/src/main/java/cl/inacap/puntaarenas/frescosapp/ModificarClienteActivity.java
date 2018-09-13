package cl.inacap.puntaarenas.frescosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import cl.inacap.puntaarenas.frescosapp.Modelo.TiendaDataBaseHelper;

public class ModificarClienteActivity extends AppCompatActivity {

    TiendaDataBaseHelper helper=new TiendaDataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cliente);

        List<String> nombres=helper.listaLocal(helper.getReadableDatabase());
        Spinner listaLocal=(Spinner)findViewById(R.id.listaEmpresas);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres);
        listaLocal.setAdapter(adapter);
    }

    public void desactivarClienteOnClick(View view){
        String mensaje;
        String nombreLocal=((Spinner)findViewById(R.id.listaEmpresas)).getSelectedItem().toString();

        mensaje=helper.desactivarLocal(nombreLocal);
        Toast toast=Toast.makeText(this,mensaje,Toast.LENGTH_SHORT);
        toast.show();
        finish();

    }
}
