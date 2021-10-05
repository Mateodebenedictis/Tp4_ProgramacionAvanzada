package com.example.tp4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FragmentModificacion extends Fragment {

    private EditText etId, etNombreProducto, etStock;
    private Spinner spinnerCategoria;
    private Button btnBuscar, btnModificar;
    private String id, nombreProducto, stock, categoria;

    public FragmentModificacion() {
    }


    public static FragmentModificacion newInstance() {
        FragmentModificacion fragment = new FragmentModificacion();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modificacion, container, false);

        etId = view.findViewById(R.id.etIdFragmentModificacion);
        etNombreProducto = view.findViewById(R.id.etNombreProductoFragmentModificacion);
        etStock = view.findViewById(R.id.etStockFragmentModificacion);
        spinnerCategoria = view.findViewById(R.id.spinnerModificacion);
        btnBuscar = view.findViewById(R.id.btnBuscar);
        btnModificar = view.findViewById(R.id.btnModificar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        buscarProducto();
                    }
                }).start();
                buscarProducto();
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modificarProducto();
            }
        });


        return view;
    }

    public void buscarProducto(){
        id = etId.getText().toString();
        if(id.length() > 0){

        } else {
            Toast.makeText(getActivity(), "Debe ingresar el id para buscar el producto", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificarProducto(){
        obtenerCampos();
        if(validarCampos()){
            //Aca se ejecuta la modificacion del producto
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
        //Aca se valida el id en la base de datos

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
        nombreProducto = etNombreProducto.getText().toString();
        stock = etStock.getText().toString();
        categoria = spinnerCategoria.getTransitionName();
    }
}