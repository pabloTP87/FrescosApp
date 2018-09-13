package cl.inacap.puntaarenas.frescosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cl.inacap.puntaarenas.frescosapp.Modelo.Cliente;
import cl.inacap.puntaarenas.frescosapp.Modelo.TiendaDataBaseHelper;

public class IngresarClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_cliente);
    }

    public void ingresarClick(View view){
        String rut=((EditText)findViewById(R.id.rutCliente)).getText().toString();
        String nombreLocal=((EditText)findViewById(R.id.nombreLocal)).getText().toString();
        String nombreContacto=((EditText)findViewById(R.id.nombreContacto)).getText().toString();
        String direccion=((EditText)findViewById(R.id.direccion)).getText().toString();
        String telefono=((EditText)findViewById(R.id.telefono)).getText().toString();

        if(rut.compareTo("")!=0 && nombreLocal.compareTo("")!=0 && nombreContacto.compareTo("")!=0 &&
                direccion.compareTo("")!=0 && telefono.compareTo("")!=0){

            TiendaDataBaseHelper helper=new TiendaDataBaseHelper(this);
            Cliente cliente=new Cliente(rut,nombreLocal,nombreContacto,direccion,telefono,"activo");

            helper.ingresarCliente(helper.getWritableDatabase(),cliente);
            Toast toast=Toast.makeText(this,"Cliente ingresado",Toast.LENGTH_SHORT);
            toast.show();
            finish();

        }else {
            Toast toast=Toast.makeText(this,"Falta ingresar datos!",Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
