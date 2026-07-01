/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.CourseDAO;
import java.util.List;
import model.Course;
/**
 *
 * @author Hype GLK
 */
public class Coursecontroller {
   // Diperkecil: tidak perlu menulis "dao.CourseDAO" dua kali
    private final CourseDAO courseDAO = new CourseDAO();
    public List<Course> getAll() {
        return courseDAO.getAll();
    }
    public boolean insert(Course course) {
        return courseDAO.insert(course);
    }
     
}
