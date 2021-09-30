package com.example.tp4.Objetos;

public class Producto {

    private String Nombre;
    private int Stock;
    private int Categoria;
    private int Id;

    public Producto(){

    }

    public Producto(String nombre, int stock, int categoria, int id) {
        Nombre = nombre;
        Stock = stock;
        Categoria = categoria;
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int categoria) {
        Categoria = categoria;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre='" + Nombre + '\'' +
                ", Stock=" + Stock +
                ", Categoria=" + Categoria +
                ", Id=" + Id +
                '}';
    }
}
