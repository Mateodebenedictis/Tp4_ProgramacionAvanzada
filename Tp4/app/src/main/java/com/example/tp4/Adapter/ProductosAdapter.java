package com.example.tp4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.ViewGroup;

import com.example.tp4.R;

import androidx.annotation.NonNull;

import com.example.tp4.Objetos.Producto;

import java.util.List;

public class ProductosAdapter extends ArrayAdapter<Producto> {
    public ProductosAdapter(Context context, List<Producto> objetos) {
        super(context, R.layout.list_template, objetos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_template, null);

        TextView tvId = (TextView) item.findViewById(R.id.idArt);
        TextView tvProducto = (TextView) item.findViewById(R.id.producto);
        TextView tvStock = (TextView) item.findViewById(R.id.stock);
        TextView tvCategoria = (TextView) item.findViewById(R.id.categoria);

        tvId.setText(getItem(position).getId()+"");
        tvProducto.setText(getItem(position).getNombre()+"");
    //    tvStock.setText(getItem(position).getStock());
     //   tvCategoria.setText(getItem(position).getCategoria());

        return item;
    }
}
