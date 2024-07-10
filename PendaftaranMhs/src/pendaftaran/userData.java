/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pendaftaran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author azriel17
 */
public class userData {
    public boolean insertAdmin(User user) {
        String sql = "INSERT INTO admin (ID, username, password) VALUES (?, ?, ?)";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, user.getID());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return false;
    }

    public boolean validateAdmin(int ID, String username, String password) {
        String sql = "SELECT * FROM admin WHERE ID = ? AND username = ? AND password = ?";

        try (Connection conn = koneksi.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, ID);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean insertUser(User user) {
        String sql = "INSERT INTO daftar (ID, username, password) VALUES (?, ?, ?)";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, user.getID());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return false;
    }

    public boolean validateUser(int ID, String username, String password) {
        String sql = "SELECT * FROM daftar WHERE ID = ? AND username = ? AND password = ?";

        try (Connection conn = koneksi.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, ID);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private void handleSQLException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            System.out.println("Kesalahan integritas data: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Username sudah digunakan. Silakan gunakan username lain.");
        } else if (e instanceof SQLSyntaxErrorException) {
            System.out.println("Kesalahan sintaks SQL: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada query SQL. Silakan cek kembali.");
        } else {
            System.out.println("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data. Silakan coba lagi.");
        }
    }
    
    
}
