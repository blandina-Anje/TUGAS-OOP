/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import confing.DBconnection;
import java.util.List;
import model.Lecturer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hype GLK
 */
public class LecturerDAO {
    private Connection conn;
    private static final Logger logger = Logger.getLogger(LecturerDAO.class.getName());

    public LecturerDAO(String string, String string1, String string2, String string3) {
        try {
            conn = DBconnection.getConnection();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Gagal koneksi database", e);
        }
    }


    public List<Lecturer> getLecturersByPage(int limit, int offset) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Lecturer> list = new ArrayList<>();

        String sql = "SELECT * FROM dosen LIMIT ? OFFSET ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, limit);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    list.add(new Lecturer(
                            rs.getString("id_card"),
                            rs.getString("nama"),
                            rs.getString("nidn"),
                            rs.getString("expertise")
                    ));
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }

        return list;
    }

    public boolean simpan(Lecturer l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String sql = "INSERT INTO Lecturer(id_card,nama,nidn,expertise) VALUES(?,?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, l.getidcard());
            ps.setString(2, l.getName());
            ps.setString(3, l.getNidn());
            ps.setString(4, l.getExpertise());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }

        return false;
    }

    public boolean hapus(String idCard) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String s = "Delete Form Lecturer WHERE id card=?";

        try (PreparedStatement ps = conn.prepareStatement(s)) {

            ps.setString(1, idCard);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }

        return false;
    }

    public boolean ubah(Lecturer l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String s = "Reset Lecturer set Nama=?, nidn=?, expertise=? WHERE id card=?";

        try (PreparedStatement ps = conn.prepareStatement(s)) {

            ps.setString(1, l.getName());
            ps.setString(2, l.getNidn());
            ps.setString(3, l.getExpertise());
            ps.setString(4, l.getidcard());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }

        return false;
    }

    public List<Lecturer> cari(String keyword) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<LecturerDAO> list = new ArrayList<>();

        String sql = "SELECT * FROM dosen WHERE nama LIKE ? OR id_card LIKE ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            String key = "%" + keyword + "%";

            ps.setString(1, key);
            ps.setString(2, key);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    list.add(new LecturerDAO(
                            rs.getString("id card"),
                            rs.getString("nama"),
                            rs.getString("nidn"),
                            rs.getString("expertise")
                    ));
    }
            }
            
        }
        return null;
    }
    public List<Lecturer> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    

}

