package com.example.tp4.Conexion;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.example.tp4.Adapter.ProductosAdapter;
import com.example.tp4.Objetos.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListadoArticulos extends AsyncTask<String, Void, String> {


    private ListView lvArticulos;
    private Context context;

    private static String result2;
    private static ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    //Recibe por constructor el textview
    //Constructor
    public ListadoArticulos(ListView lv, Context ct)
    {
        lvArticulos = lv;
        context = ct;

    }

    @Override
    protected String doInBackground(String... urls) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Conexion.urlMySQL, Conexion.user, Conexion.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articulo");
            result2 = " ";

            Producto producto;
            while(rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoria(rs.getInt("idCategoria"));
                listaProductos.add(producto);
            }
            response = "Conexion exitosa";
        }
        catch(Exception e) {
            e.printStackTrace();
            result2 = "Conexion no exitosa";
        }
        return response;

    }

    @Override
    protected void onPostExecute(String response) {
        ProductosAdapter adapter = new ProductosAdapter(context, listaProductos);
        lvArticulos.setAdapter(adapter);
    }
}