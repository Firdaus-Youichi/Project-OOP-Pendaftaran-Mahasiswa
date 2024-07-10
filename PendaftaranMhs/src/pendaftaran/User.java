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
 * @author azriel17
 */
public class User {
    private int ID;
    private String username;
    private String password;


    // Getter methods
    public int getID() { return ID; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    // Setter methods (if needed)
    public void setID(int ID) { this.ID = ID; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }    
}
