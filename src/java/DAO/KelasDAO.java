/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.disconnect;
import static DAO.DAO.getConnection;
import Model.Dosen;
import Model.Kelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kivla
 */
public class KelasDAO {
    public static List<Kelas> getAll(){
        List<Kelas> kelas = new ArrayList<>();
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM kelas");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Kelas klsObj = new Kelas();
                
                klsObj.setNAMA_KELAS(rs.getString("NAMA_KELAS"));
                klsObj.setPRODI(rs.getString("PRODI"));
                
                kelas.add(klsObj);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return kelas;
    }
    
    public static int save(Kelas _kelas){
        Integer stats = 0;
        try{
            Connection con = (Connection) getConnection();
            Statement st = con.createStatement();
            
            String nama_kelas = _kelas.getNAMA_KELAS();
            String prodi = _kelas.getPRODI();
            
            String sql = "INSERT INTO kelas (NAMA_KELAS,PRODI) VALUES(\"" + nama_kelas + "\",\"" + prodi +"\");";
            stats = st.executeUpdate(sql);
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return stats;
    }
}
