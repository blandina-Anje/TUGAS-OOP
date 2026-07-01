/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import confing.DBconnection;
import model.KRS;
import model.Course;
import model.student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

   

/**
 *
 * @author Hype GLK
 */
public class KRSDAO {

    public boolean simpan(KRS krs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     String sql = "INSERT INTO krs (nim,kode,mk,semester,nilai,sikap,nilai,uts,nilai uas,nilai akhir,nilai huruf) VALUE (?,?,?,?,?,?,?,?)" ;  

        try (Connection conn = confing.DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, krs.getstudent().getNim());
            ps.setString(2, krs.getCourse().getCode());
            ps.setString(3, String.valueOf(krs.getSemester()));
            ps.setDouble(4, krs.getNilaiSikap());
            ps.setDouble(5, krs.getNilaiUts());
            ps.setDouble(6, krs.getNilaiUas());
            ps.setDouble(7, krs.getNilaiAkhir());
            ps.setString(8, krs.getNilaiHuruf());

            int hasil = ps.executeUpdate();
            return hasil > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    

    public List<KRS> ambilSemua() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          List<krs> list = new ArrayList<>();
        String sql = "SELECT k.nim, k.kode_mk, k.semester, k.nilai_sikap, k.nilai_uts, k.nilai_uas, k.nilai_akhir, k.nilai_huruf, " +
                     "m.nama AS nama_mhs, m.prodi, mk.nama_mk FROM krs k " +
                     "INNER JOIN mahasiswa m ON k.nim=m.nim " +
                     "INNER JOIN matakuliah mk ON k.kode_mk=mk.kode_mk";

        try (Connection conn = confing.DBconnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                student Mhs = new student();
                Mhs.setNim(rs.getString("nim"));
                // Catatan: jika error di setNama/setProdi, sesuaikan dengan method di kelas Student kamu (misal setName/setStudyProgram)
                Mhs.setName(rs.getString("nama_mhs"));
                Mhs.setProdi(rs.getString("prodi"));
                 Course mk = new Course();
                mk.setKode(rs.getString("kode_mk"));
                mk.setNamaMK(rs.getString("nama_mk"));

                KRS k = new KRS();
                k.setstudent(Mhs);
                k.setCourse(mk);
                k.setSemester(rs.getInt("semester"));
                k.setNilaiSikap(rs.getDouble("nilai_sikap"));
                k.setNilaiUts(rs.getDouble("nilai_uts"));
                k.setNilaiUas(rs.getDouble("nilai_uas"));
                k.setNilaiAkhir(rs.getDouble("nilai_akhir"));
                k.setNilaiHuruf(rs.getString("nilai_huruf"));

                list.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    

    public boolean update(KRS krs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         
        try (Connection conn = confing.DBconnection.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, krs.getNilaiSikap());
            ps.setDouble(2, krs.getNilaiUts());
            ps.setDouble(3, krs.getNilaiUas());
            ps.setDouble(4, krs.getNilaiAkhir());
            ps.setString(5, krs.getNilaiHuruf());
            ps.setString(6, krs.getstudent().getNimProdi);
            ps.setString(7, krs.getCourse().getKode());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { 
             e.printStackTrace();
             return false; 
        }
    }

    public boolean hapus(String nim, String kodeMk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        
        try (Connection conn = confing.DBconnection.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, nim);
            ps.setString(2, kodeMk);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { 
             e.printStackTrace();
             return false; 
        }
    } 
    
}

