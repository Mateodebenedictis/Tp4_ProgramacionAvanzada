package com.example.tp4.Objetos;

public class Categoria {

    private String Nombre;
    private int Id;

    public Categoria() {
    }

    public Categoria(String nombre, int id) {
        Nombre = nombre;
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "Nombre='" + Nombre + '\'' +
                ", Id=" + Id +
                '}';
    }
}
