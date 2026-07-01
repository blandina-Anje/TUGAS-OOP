/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.krsDAO;      
import model.KRS;
import java.util.List;
/**
 *
 * @author Hype GLK
 */
public class KRScontroller {
    private final krsDAO KRSDAO;

    public KRScontroller() {
        this.KRSDAO = new krsDAO();
    }
    
    public KRSDAO getKRSDAO() {
        return KRSDAO;
    }

    // CREATE
    public boolean tambahData(KRS krs) {
        return KRSDAO.simpan(krs);
    }

    // READ
    public List<KRS> tampilkanSemuaData() {
        return KRSDAO.ambilSemua();
    }

    // UPDATE
    public boolean ubahData(KRS krs) {
        return KRSDAO.update(krs);
    }

    
    
    public boolean hapusDataNilai(String nim, String kodeMk) {
        return KRSDAO.hapus(nim, kodeMk);
    }
}
