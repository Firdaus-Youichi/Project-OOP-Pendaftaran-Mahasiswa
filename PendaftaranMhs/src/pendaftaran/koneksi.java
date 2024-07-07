/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pendaftaran;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rendy
 */
public class koneksi {
    public static Connection getConnection(){
        Connection Koneksi = null;
        String url = "jdbc:mysql://localhost/db_pendaftaran";
        String user = "root";
        String password = "";
        try {
            Koneksi = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            System.out.println(e);
        }
        return Koneksi;
    }
}
