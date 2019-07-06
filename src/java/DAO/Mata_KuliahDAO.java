/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.disconnect;
import static DAO.DAO.getConnection;
import Model.Dosen;
import Model.Mata_Kuliah;
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
public class Mata_KuliahDAO {
    public static List<Mata_Kuliah> getAll(){
        List<Mata_Kuliah> matkul = new ArrayList<>();
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM mata_kuliah");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Mata_Kuliah matObj = new Mata_Kuliah();
                matObj.setKD_MATKUL(rs.getString("KD_MATKUL"));
                matObj.setNAMA_MATKUL(rs.getString("NAMA_MATKUL"));
                matObj.setSKS(rs.getInt("SKS"));
                matkul.add(matObj);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return matkul;
    }
    
    public static int save(Mata_Kuliah _matkul){
        Integer stats = 0;
        try{
            Connection con = (Connection) getConnection();
            Statement st = con.createStatement();
            
            String kd_matkul = _matkul.getKD_MATKUL();
            String nama_matkul = _matkul.getNAMA_MATKUL();
            int sks = _matkul.getSKS();
            
            String sql = "INSERT INTO mata_kuliah (KD_MATKUL,NAMA_MATKUL,SKS) VALUES(\"" + kd_matkul + "\",\"" + nama_matkul +"\",\"" + sks +"\");";
            stats = st.executeUpdate(sql);
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return stats;
    }
}
