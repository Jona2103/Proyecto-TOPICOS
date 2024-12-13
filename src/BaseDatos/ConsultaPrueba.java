/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;


import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 52311
 */
public class ConsultaPrueba {
    private static Connection con;
    
    public static void main(String[] args) {
        Conectar();
        Consulta();
        
    }
    
    public static void Conectar(){
        
        String url = "jdbc:sqlserver://OswaldoDiaz:1433;databaseName=TAP;encrypt=true;trustServerCertificate=true;";
        
        try {
            con = DriverManager.getConnection(url, "UsuarioTAP", "123");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al conectar");
        }
        System.out.println("Conexión exitosa");
    }
    
    public static void Consulta(){
        String url = "jdbc:sqlserver://OswaldoDiaz:1433;databaseName=TAP;encrypt=true;trustServerCertificate=true;";
         String nombreBuscado = "Oswaldo";

        try {
             // Crear la consulta SQL
             try ( // Establecer la conexión
                     Connection connection = DriverManager.getConnection(url, "UsuarioTAP", "123")) {
                 // Crear la consulta SQL
                 String consulta = "SELECT * FROM Persona WHERE nombre = '" + nombreBuscado + "'";
                 
                 // Crear un Statement para ejecutar la consulta
                 Statement statement = connection.createStatement();
                 
                 // Ejecutar la consulta
                 ResultSet resultado = statement.executeQuery(consulta);
                 
                 // Verificar y mostrar los resultados
                 System.out.println("Resultados de la búsqueda:");
                 while (resultado.next()) {
                     // Supongamos que la tabla tiene columnas: id, nombre, edad
                     int id = resultado.getInt("PersonaID");
                     String nombre = resultado.getString("Nombre");
                     String no = resultado.getString("NoControl");
                
                     
                     System.out.println("ID: " + id + ", Nombre: " + nombre + ", Número de control: " + no);
                 }
                 
                 // Cerrar la conexión
                 resultado.close();
                 statement.close();
             }
            System.out.println("Conexión cerrada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    }
 

