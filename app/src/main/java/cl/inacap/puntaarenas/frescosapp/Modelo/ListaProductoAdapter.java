package cl.inacap.puntaarenas.frescosapp.Modelo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cl.inacap.puntaarenas.frescosapp.R;

/**
 * Created by Pablo on 25/11/2017.
 */

public class ListaProductoAdapter extends ArrayAdapter<String > {

    private final Activity context;
    private final List <String> nombre;
    private final List <Integer> imagen;

    public ListaProductoAdapter(Activity context, List<String> nombre, List<Integer> imagen) {
        super(context, R.layout.activity_lista_productos,nombre);
        this.context = context;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public View getView(int posicion, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_lista_productos,null,true);

        TextView txtNombre=(TextView) rowView.findViewById(R.id.nombre_producto);
        ImageView img=(ImageView) rowView.findViewById(R.id.imagen_producto);

        txtNombre.setText(nombre.get(posicion));
        img.setImageResource(imagen.get(posicion));

        return rowView;
    }
}
