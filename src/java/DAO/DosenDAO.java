/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.disconnect;
import static DAO.DAO.getConnection;
import Model.Dosen;
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
public class DosenDAO {
    public static List<Dosen> getAll(){
        List<Dosen> dosen = new ArrayList<>();
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM dosen");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Dosen dosObj = new Dosen();
                dosObj.setKD_DOSEN(rs.getString("KD_DOSEN"));
                dosObj.setNAMA_DOSEN(rs.getString("NAMA_DOSEN"));
                dosen.add(dosObj);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return dosen;
    }
    
    public static int save(Dosen _dosen){
        Integer stats = 0;
        try{
            Connection con = (Connection) getConnection();
            Statement st = con.createStatement();
            
            String kd_dosen = _dosen.getKD_DOSEN();
            String nama_dosen = _dosen.getNAMA_DOSEN();
            
            String sql = "INSERT INTO dosen (KD_DOSEN,NAMA_DOSEN) VALUES(\"" + kd_dosen + "\",\"" + nama_dosen +"\");";
            stats = st.executeUpdate(sql);
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return stats;
    }
}
