package com.example.tp4.Conexion;

public class Conexion {

    //Información de la BD
    public static String host="sql10.freesqldatabase.com";
    public static String port="3306";
    public static String nameBD="sql10439826";
    public static String user="sql10439826";
    public static String pass="a7n1YiIARA";

    //Información para la conexion
    public static String urlMySQL = "jdbc:mysql://" + host + ":" + port + "/"+nameBD;
    public static String driver = "com.mysql.jdbc.Driver";
}
