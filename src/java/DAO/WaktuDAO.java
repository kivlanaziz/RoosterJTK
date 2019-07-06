/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.disconnect;
import static DAO.DAO.getConnection;
import Model.Mata_Kuliah;
import Model.Waktu;
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
public class WaktuDAO {
    public static List<Waktu> getAll(){
        List<Waktu> waktu = new ArrayList<>();
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM waktu");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Waktu wktObj = new Waktu();
                
                wktObj.setKD_JAM(rs.getInt("KD_JAM"));
                wktObj.setWAKTU_MULAI(rs.getTime("WAKTU_MULAI"));
                wktObj.setWAKTU_SELESAI(rs.getTime("WAKTU_SELESAI"));
                
                waktu.add(wktObj);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return waktu;
    }
    
    public static int save(Waktu _waktu){
        Integer stats = 0;
        try{
            Connection con = (Connection) getConnection();
            Statement st = con.createStatement();
            
            int kd_jam = _waktu.getKD_JAM();
            java.sql.Time waktu_mulai = _waktu.getWAKTU_MULAI();
            java.sql.Time waktu_selesai = _waktu.getWAKTU_SELESAI();
            
            String sql = "INSERT INTO waktu (KD_JAM,WAKTU_MULAI,WAKTU_SELESAI) VALUES(\"" + kd_jam + "\",\"" + waktu_mulai +"\",\"" + waktu_selesai +"\");";
            stats = st.executeUpdate(sql);
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return stats;
    }
}
