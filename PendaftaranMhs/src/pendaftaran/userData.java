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
    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (nama_depan, nama_belakang, username, password, tanggal_lahir, alamat, pertanyaan_keamanan, jawaban) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getNamaDepan());
            pstmt.setString(2, user.getNamaBelakang());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getTanggalLahir());
            pstmt.setString(6, user.getAlamat());
            pstmt.setString(7, user.getPertanyaanKeamanan());
            pstmt.setString(8, user.getJawaban());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return false;
    }

    public boolean validateUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
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
