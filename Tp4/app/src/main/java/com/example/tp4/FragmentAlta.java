package com.example.tp4;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FragmentAlta extends Fragment {

    private EditText etId, etNombreProducto, etStock;
    private Spinner spinnerCategoria;
    private Button btnAgregar;
    private String id, nombreProducto, stock, categoria;


    public FragmentAlta() {
    }

    public static FragmentAlta newInstance() {
        FragmentAlta fragment = new FragmentAlta();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alta, container, false);

        etId = view.findViewById(R.id.etIdFragmentAlta);
        etNombreProducto = view.findViewById(R.id.etNombreProductoFragmentAlta);
        etStock = view.findViewById(R.id.etStockFragmentAlta);
        spinnerCategoria = view.findViewById(R.id.spinnerAlta);
        btnAgregar = view.findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                altaProducto();
            }
        });

        return view;
    }

    public void altaProducto(){
        obtenerCampos();
        if(validarCampos()){
            //Aca se da de alta el producto
        }
    }

    public boolean validarCampos(){
        if(!nombreProducto.isEmpty() && !id.isEmpty() && !stock.isEmpty() && !categoria.isEmpty()){
            if(validarNombreProducto()){
                if(validarId()){
                    if(validarIdBaseDeDatos()){
                        if(validarStock()){
                            return true;
                        } else {
                            Toast.makeText(getActivity(), "Ingrese un stock valido", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "El id ingresado ya existe en el sistema, ingrese otro", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Ingrese un Id valido", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "Ingrese un nombre de producto sin numeros", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "Primero debe completar todos los campos", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public boolean validarIdBaseDeDatos(){
        //Aca se valida en la base de datos que no exista el id
        return false;
    }

    public boolean validarId(){
        for (int x = 0; x < id.length(); x++) {
            char c = id.charAt(x);
            if (!((c >= '0' && c <= '9') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    public boolean validarStock(){
        for (int x = 0; x < stock.length(); x++) {
            char c = stock.charAt(x);
            if (!((c >= '0' && c <= '9') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    public boolean validarNombreProducto(){
        for (int x = 0; x < nombreProducto.length(); x++) {
            char c = nombreProducto.charAt(x);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    public void obtenerCampos(){
        id = etId.getText().toString();
        nombreProducto = etNombreProducto.getText().toString();
        stock = etStock.getText().toString();
        categoria = spinnerCategoria.getTransitionName();
    }

}