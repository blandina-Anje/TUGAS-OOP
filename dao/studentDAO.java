/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import model.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import confing.DBconnection;
/**
 *
 * @author Hype GLK
 */
public class studentDAO {
    private Connection connection;
    public studentDAO() {
        try {
            connection = DBconnection.getConnection();
        }catch (SQLException ex){
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //create User
    public int create(student student){
        try{
            String sql = "INSERT INTO students (cardID, NIM, name, studiProgram) VALUES(?,?,?,?)";
            PreparedStatement stmt =connection.prepareStatement(sql);
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getNim());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getStudyProgram());
            stmt.executeUpdate();
            return 1;
            
        }catch(SQLException e){
            return 0;
        }
    }
    //Select/read Users
    public List<student> getStudent(){
        List<student> students = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM students";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("studentID");
                String cardID = rs.getString("cardID");
                String NIM = rs.getString("NIM");
                String name = rs.getString("name");
                String studiProgram = rs.getString("studiProgram");
                               
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }
    //update student
    public int update(studentDAO student, String nim){
        try{
            String sql = "UPDATE students SET cardID=?, name=?, studiProgram=? WHERE NIM=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getStudyProgram());
            stmt.setString(4, student.getNim());
            stmt.executeUpdate();
            return 1;
        }catch(SQLException e){
            return 0;
        }
        
    }
     //Delete User
    public int delete(String nim){
        try{
            String sql = "DELETE FROM students WHERE NIM=?";
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.executeUpdate();
            return 1;
            
        }catch(SQLException e){
            //e.printStackTrace();
            return 0;
        }
    }

    private String getCardID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getStudyProgram() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getNim() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

