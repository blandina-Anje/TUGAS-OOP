/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hype GLK
 */
public class Lecturer  extends person{
    
    private  String nidn;
    private  String expertise;
    
    public Lecturer(String idCard,
                     String name,
                     String nidn,
                     String expertise){
        super(idCard, name);
        
        this.nidn = nidn;
        this.expertise = expertise;
    }
    public String toString(){
        return this.name;
    }
    public String getName() {
        return this.name;
    }
    public String getNidn() {
        return nidn;
    }
    public String getExpertise() {
        return expertise;
    }

    public String getidcard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
