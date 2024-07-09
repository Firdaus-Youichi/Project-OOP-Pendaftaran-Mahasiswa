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
    private String namaDepan;
    private String namaBelakang;
    private String username;
    private String password;
    private String tanggalLahir;
    private String alamat;
    private String pertanyaanKeamanan;
    private String jawaban;

    // Getter methods
    public String getNamaDepan() { return namaDepan; }
    public String getNamaBelakang() { return namaBelakang; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getTanggalLahir() { return tanggalLahir; }
    public String getAlamat() { return alamat; }
    public String getPertanyaanKeamanan() { return pertanyaanKeamanan; }
    public String getJawaban() { return jawaban; }

    // Setter methods (if needed)
    public void setNamaDepan(String namaDepan) { this.namaDepan = namaDepan; }
    public void setNamaBelakang(String namaBelakang) { this.namaBelakang = namaBelakang; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setTanggalLahir(String tanggalLahir) { this.tanggalLahir = tanggalLahir; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public void setPertanyaanKeamanan(String pertanyaanKeamanan) { this.pertanyaanKeamanan = pertanyaanKeamanan; }
    public void setJawaban(String jawaban) { this.jawaban = jawaban; }

    
}
