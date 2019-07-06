/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.disconnect;
import static DAO.DAO.getConnection;
import Model.Mata_Kuliah;
import Model.Ruangan;
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
public class RuanganDAO {
    public static List<Ruangan> getAll(){
        List<Ruangan> ruangan = new ArrayList<>();
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ruangan");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Ruangan ruangObj = new Ruangan();
                
                ruangObj.setJENIS(rs.getString("JENIS"));
                ruangObj.setKD_RUANGAN(rs.getString("KD_RUANGAN"));
                ruangObj.setLANTAI(rs.getInt("LANTAI"));
                
                ruangan.add(ruangObj);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return ruangan;
    }
    
    public static int save(Ruangan _ruangan){
        Integer stats = 0;
        try{
            Connection con = (Connection) getConnection();
            Statement st = con.createStatement();
            
            String kd_ruangan = _ruangan.getKD_RUANGAN();
            String jenis = _ruangan.getJENIS();
            int lantai = _ruangan.getLANTAI();
            
            String sql = "INSERT INTO ruangan (KD_RUANGAN,LANTAI,JENIS) VALUES(\"" + kd_ruangan + "\",\"" + lantai +"\",\"" + jenis +"\");";
            stats = st.executeUpdate(sql);
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return stats;
    }
}
