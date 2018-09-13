package cl.inacap.puntaarenas.frescosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.puntaarenas.frescosapp.Modelo.Cliente;
import cl.inacap.puntaarenas.frescosapp.Modelo.ListaProducto;
import cl.inacap.puntaarenas.frescosapp.Modelo.Pedido;
import cl.inacap.puntaarenas.frescosapp.Modelo.TiendaDataBaseHelper;

public class RealizarPedidoActivity extends AppCompatActivity {

    TiendaDataBaseHelper helper=new TiendaDataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_pedido);
        //Spinner Clientes
        List<String> listaClientes=helper.listaLocal(helper.getReadableDatabase());
        Spinner seleccionCliente=(Spinner)findViewById(R.id.seleccionClientes);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                listaClientes);
        seleccionCliente.setAdapter(adapter);

        //Spinner Productos

        List<String> listaProductos=helper.listaProducto(helper.getReadableDatabase());
        Spinner seleccionProducto=(Spinner)findViewById(R.id.seleccionProducto);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaProductos);
        seleccionProducto.setAdapter(adapter2);

        //Spinner Estado
        List<String> estado=new ArrayList<>();
        estado.add("Entregado");
        estado.add("Pendiente");
        Spinner estadoPedidos=(Spinner)findViewById(R.id.estado);
        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,estado);
        estadoPedidos.setAdapter(adapter3);


    }

    public void cambiarRut(View view){
        Spinner seleccionCliente=(Spinner)findViewById(R.id.seleccionClientes);
        String local=seleccionCliente.getSelectedItem().toString();

        TextView rut=(TextView)findViewById(R.id.rut);
        rut.setText(helper.rutCliente(helper.getReadableDatabase(),local));

    }

    public void ingresarLista(View view){
        String numPedido=((EditText)findViewById(R.id.numPedido)).getText().toString();
        String selecProducto=((Spinner)findViewById(R.id.seleccionProducto)).getSelectedItem().toString();
        String cantidad=((EditText)findViewById(R.id.cantidad)).getText().toString();
        TextView precioTotal=(TextView)findViewById(R.id.total);
        int cantProduct=Integer.parseInt(cantidad);
        int precio = helper.precioProductoPedido(helper.getReadableDatabase(),selecProducto);

        if (numPedido.compareTo("")!=0 && cantidad.compareTo("")!=0){

            ListaProducto listaProducto=new ListaProducto(numPedido,selecProducto,cantProduct,precio);
            helper.ingresarProductoPedido(helper.getWritableDatabase(),listaProducto);

            int precioInt= helper.sumaProductoPedido(helper.getReadableDatabase(),selecProducto,cantProduct);

            String txtPrecio=Integer.toString(precioInt);

            precioTotal.setText(txtPrecio);

            Toast toast=Toast.makeText(this,"Producto ingresado al pedido",Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast=Toast.makeText(this,"Falta ingresar datos!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void agregarPedido(View view){

        String numPedido=((EditText)findViewById(R.id.numPedido)).getText().toString();
        String rut=((TextView)findViewById(R.id.rut)).getText().toString();
        String fecha=((EditText)findViewById(R.id.fecha)).getText().toString();
        String total=((TextView)findViewById(R.id.total)).getText().toString();
        String estado=((Spinner)findViewById(R.id.estado)).getSelectedItem().toString();
        int totalPedido;

        if(numPedido.compareTo("")!=0&& !rut.equals("Rut del cliente") && fecha.compareTo("")!=0){
            totalPedido=Integer.parseInt(total);

            Pedido pedido=new Pedido(numPedido,rut,fecha,totalPedido,estado);
            helper.ingresarPedido(helper.getWritableDatabase(),pedido);

            if(estado.equals("Entregado")) {
                Toast toast = Toast.makeText(this, "Pedido registrado y entregado", Toast.LENGTH_SHORT);
                toast.show();
            }else {
                Toast toast = Toast.makeText(this, "Pedido registrado y pendiente", Toast.LENGTH_SHORT);
                toast.show();
            }
        }else {
            Toast toast = Toast.makeText(this, "Falta ingresar datos!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
