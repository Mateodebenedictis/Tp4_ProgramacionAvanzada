package com.example.tp4.Conexion;

import android.os.AsyncTask;

import com.example.tp4.Objetos.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ObtenerArticulo extends AsyncTask<String, Void, String> {

    private Producto p;
    private static String result2;
    private static Producto producto = new Producto();

    public ObtenerArticulo(Producto produ) {
        p = produ;
    }

    @Override
    protected String doInBackground(String... strings) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Conexion.urlMySQL, Conexion.user, Conexion.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articulo where id = " + p.getId());
            result2 = "";

            if(rs.next()){
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoria(rs.getInt("idCategoria"));
            } else {
                producto.setId(-1);
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
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
