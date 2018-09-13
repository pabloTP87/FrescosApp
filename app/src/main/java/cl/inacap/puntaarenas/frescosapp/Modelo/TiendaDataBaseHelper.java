package cl.inacap.puntaarenas.frescosapp.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.puntaarenas.frescosapp.R;

/**
 * Created by Pablo on 21/11/2017.
 */

public class TiendaDataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "tienda.db";
    private static final int DB_VERSION = 1;

    public TiendaDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlClientes = "CREATE TABLE CLIENTES("
                + "id_ INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "RUT_CLIENTE TEXT, NOMBRE_LOCAL TEXT, NOMBRE_CONTACTO TEXT, "
                + "DIRECCION TEXT, TELEFONO TEXT, ACTIVO TEXT);";

        db.execSQL(sqlClientes);

        String sqlPedidos = "CREATE TABLE PEDIDOS("
                + "id_ INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NUMERO_PEDIDO TEXT, RUT_CLIENTE TEXT, FECHA_ENTREGA DATE, "
                + "TOTAL INTEGER, ESTADO TEXT);";

        db.execSQL(sqlPedidos);

        String sqlListaProductos = "CREATE TABLE LISTA_PRODUCTOS("
                + "id_ INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NUMERO_PEDIDO TEXT, PRODUCTO TEXT, CANTIDAD INTEGER, PRECIO INTEGER);";

        db.execSQL(sqlListaProductos);

        String sqlProductos = "CREATE TABLE PRODUCTOS("
                + "id_ INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NOMBRE TEXT, PRECIO INTEGER, IMAGEN INTEGER);";

        db.execSQL(sqlProductos);

        ingresarProducto(db,new Producto("Palta",990,R.drawable.palta));
        ingresarProducto(db,new Producto("Tomate",1200,R.drawable.tomate));
        ingresarProducto(db,new Producto("Naranja", 1100,R.drawable.naranja));
        ingresarProducto(db,new Producto("Frutilla", 2500,R.drawable.frutilla));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS CLIENTES");
        db.execSQL("DROP TABLE IF EXISTS PRODUCTOS");
        db.execSQL("DROP TABLE IF EXISTS PEDIDOS");
        db.execSQL("DROP TABLE IF EXISTS LISTA_PRODUCTOS");
        onCreate(db);

    }

    public void ingresarProducto(SQLiteDatabase db, Producto producto){
        ContentValues valores=new ContentValues();
        valores.put("NOMBRE",producto.getNomProducto());
        valores.put("PRECIO",producto.getPrecio());
        valores.put("IMAGEN",producto.getImagen());
        db.insert("PRODUCTOS",null,valores);
    }

    public List <Integer> listaImagenes (SQLiteDatabase db){
        List<Integer> imagenes=new ArrayList<>();
        Cursor cursor=db.rawQuery("select IMAGEN FROM PRODUCTOS",null);
        cursor.moveToFirst();
        do{
            imagenes.add(cursor.getInt(0));
        }while (cursor.moveToNext());
        return imagenes;
    }

    public List<String> listaNombres(SQLiteDatabase db){
        List<String> productos=new ArrayList<>();
        Cursor cursor=db.rawQuery("select NOMBRE ,PRECIO FROM PRODUCTOS",null);
        cursor.moveToFirst();
        do{
            productos.add(cursor.getString(0));
        }while (cursor.moveToNext());
        return productos;
    }

    public void ingresarCliente(SQLiteDatabase db, Cliente cliente){
        ContentValues valores=new ContentValues();
        valores.put("RUT_CLIENTE",cliente.getRutCliente());
        valores.put("NOMBRE_LOCAL",cliente.getNombreLocal());
        valores.put("NOMBRE_CONTACTO",cliente.getNombreContacto());
        valores.put("DIRECCION",cliente.getDireccion());
        valores.put("TELEFONO",cliente.getTelefono());
        valores.put("ACTIVO",cliente.getActivo());
        db.insert("CLIENTES",null,valores);
    }

    public List<Cliente> listaCliente(SQLiteDatabase db){
        List<Cliente> clientes=new ArrayList<>();

        try {
            Cursor cursor = db.query("CLIENTES", new String[]{"RUT_CLIENTE", "NOMBRE_LOCAL",
                            "NOMBRE_CONTACTO", "DIRECCION", "TELEFONO", "ACTIVO"},
                    "ACTIVO='activo'", null, null, null, null);
            cursor.moveToFirst();


            do {
                clientes.add(new Cliente(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                        cursor.getString(4), cursor.getString(5)));
            } while (cursor.moveToNext());
        }catch (CursorIndexOutOfBoundsException e){
            clientes=null;
        }
        //cursor.close();
        db.close();
        return  clientes;
    }

    public List<String> listaLocal(SQLiteDatabase db){
        List<String> local=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT NOMBRE_LOCAL FROM CLIENTES WHERE ACTIVO='activo'",null);
        cursor.moveToFirst();

        do{
            local.add(cursor.getString(0));
        }while (cursor.moveToNext());

        return local;
    }

    public List<String> listaProducto(SQLiteDatabase db){
        List<String> producto=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT NOMBRE FROM PRODUCTOS",null);
        cursor.moveToFirst();

        do {
            producto.add(cursor.getString(0));
        }while (cursor.moveToNext());
        return producto;
    }

    public String desactivarLocal(String local){
        String mensaje="Cliente Inhabilitado";
        String sqlTxt="UPDATE CLIENTES SET ACTIVO = 'inactivo' "+
                "WHERE NOMBRE_LOCAL = ?";

        Object[] argumentos=new Object[]{local};

        try{
            getWritableDatabase().execSQL(sqlTxt,argumentos);
        }catch (SQLException e){
            mensaje="Error al Inhabilitar cliente";
            return mensaje;
        }

        return mensaje;
    }

    public void ingresarPedido(SQLiteDatabase db, Pedido pedido){
        ContentValues valores=new ContentValues();
        valores.put("NUMERO_PEDIDO",pedido.getNumPedido());
        valores.put("RUT_CLIENTE",pedido.getRutCliente());
        valores.put("FECHA_ENTREGA",pedido.getFechaEntrega());
        valores.put("TOTAL",pedido.getTotal());
        valores.put("ESTADO",pedido.getEstado());

        db.insert("PEDIDOS",null,valores);
    }

    public void ingresarProductoPedido(SQLiteDatabase db, ListaProducto listaProducto){
        ContentValues valores=new ContentValues();
        valores.put("NUMERO_PEDIDO",listaProducto.getNumPedido());
        valores.put("PRODUCTO",listaProducto.getProducto());
        valores.put("CANTIDAD",listaProducto.getCantidad());
        valores.put("PRECIO",listaProducto.getPrecio());

        db.insert("LISTA_PRODUCTOS",null,valores);
    }

    public String rutCliente(SQLiteDatabase db, String local){
        String rut;
        Cursor cursor=db.rawQuery("SELECT RUT_CLIENTE FROM CLIENTES WHERE NOMBRE_LOCAL='"+local+"'",null);
        cursor.moveToFirst();
        do {
            rut = cursor.getString(0);
        }while (cursor.moveToNext());

        return rut;
    }

    public int precioProductoPedido(SQLiteDatabase db, String producto){
        int precio;
        Cursor cursor=db.rawQuery("SELECT PRECIO FROM PRODUCTOS WHERE NOMBRE='"+producto+"'",null);
        cursor.moveToFirst();

        do {
            precio = cursor.getInt(0);
        }while (cursor.moveToNext());

        return precio;
    }

    public int sumaProductoPedido(SQLiteDatabase db, String producto, int cantidad){
        int precio;
        int suma=0;
        Cursor cursor=db.rawQuery("SELECT PRECIO FROM PRODUCTOS WHERE NOMBRE='"+producto+"'",null);
        cursor.moveToFirst();

        do {
            precio = cursor.getInt(0);
            suma=suma+(precio*cantidad);
        }while (cursor.moveToNext());

        return suma;
    }

    public List<Pedido> listaPedidosEntregados (SQLiteDatabase db){
        List<Pedido> pedidos=new ArrayList<>();

        try{
            Cursor cursor=db.query("PEDIDOS",new String[]{"NUMERO_PEDIDO","RUT_CLIENTE","FECHA_ENTREGA",
            "TOTAL","ESTADO"},"ESTADO='Entregado'",null,null,null,null);
            cursor.moveToFirst();

            do{
                pedidos.add(new Pedido(cursor.getString(0),cursor.getString(1),cursor.getString(2),
                        cursor.getInt(3),cursor.getString(4)));
            }while (cursor.moveToNext());

        }catch (CursorIndexOutOfBoundsException e){
            pedidos=null;
        }
        db.close();
        return pedidos;
    }
}
