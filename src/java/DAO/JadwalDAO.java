/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Rooster;
import Controller.Rooster.JamDosen;
import static DAO.DAO.disconnect;
import static DAO.DAO.getConnection;
import Model.Dosen;
import Model.Jadwal;
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
public class JadwalDAO {
    public static List<Jadwal> getAll(){
        List<Jadwal> jadwal = new ArrayList<>();
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM jadwal_klh ORDER BY HARI DESC,KD_JAM ASC");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Jadwal jdwObj = new Jadwal();
                
                jdwObj.setKD_DOSEN(rs.getString("KD_DOSEN"));
                jdwObj.setNAMA_DOSEN(rs.getString("NAMA_DOSEN"));
                jdwObj.setKD_JAM(rs.getInt("KD_JAM"));
                jdwObj.setKD_MATKUL(rs.getString("KD_MATKUL"));
                jdwObj.setNAMA_MATKUL(rs.getString("NAMA_MATKUL"));
                jdwObj.setSKS(rs.getInt("SKS"));
                jdwObj.setKD_RUANGAN(rs.getString("KD_RUANGAN"));
                jdwObj.setNAMA_KELAS(rs.getString("NAMA_KELAS"));
                jdwObj.setWAKTU_MULAI(rs.getString("WAKTU_MULAI"));
                jdwObj.setWAKTU_SELESAI(rs.getString("WAKTU_SELESAI"));
                jdwObj.setHARI(rs.getString("HARI"));
                jdwObj.setPRODI(rs.getString("PRODI"));
                jdwObj.setSEMESTER(rs.getString("SEMESTER"));
                jdwObj.setTAHUN_AJARAN(rs.getString("TAHUN_AJARAN"));
                
                jadwal.add(jdwObj);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return jadwal;
    }
    
    public static List<Jadwal> getJdwDosen(String kd_dosen){
        List<Jadwal> jadwal = new ArrayList<>();
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("CALL getJadwalDsn('" + kd_dosen + "');");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Jadwal jdwObj = new Jadwal();
                
                jdwObj.setKD_DOSEN(rs.getString("KD_DOSEN"));
                jdwObj.setNAMA_DOSEN(rs.getString("NAMA_DOSEN"));
                //jdwObj.setKD_JAM(rs.getInt("KD_JAM"));
                //jdwObj.setKD_MATKUL(rs.getString("KD_MATKUL"));
                jdwObj.setNAMA_MATKUL(rs.getString("NAMA_MATKUL"));
                //jdwObj.setSKS(rs.getInt("SKS"));
                jdwObj.setKD_RUANGAN(rs.getString("KD_RUANGAN"));
                jdwObj.setNAMA_KELAS(rs.getString("NAMA_KELAS"));
                jdwObj.setWAKTU_MULAI(rs.getString("WAKTU_MULAI"));
                jdwObj.setWAKTU_SELESAI(rs.getString("WAKTU_SELESAI"));
                jdwObj.setHARI(rs.getString("HARI"));
                //jdwObj.setPRODI(rs.getString("PRODI"));
                //jdwObj.setSEMESTER(rs.getString("SEMESTER"));
                //jdwObj.setTAHUN_AJARAN(rs.getString("TAHUN_AJARAN"));
                
                jadwal.add(jdwObj);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return jadwal;
    }
    
    public static int getWktDosen(String kd_dosen){
        int jam = 0;
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT checkjmlajar(\""+ kd_dosen + "\") AS jmlAjar;");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                jam = rs.getInt("jmlAjar");
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return jam;
    }
    
    public static List<JamDosen> getRankDsn(int limit){
        ArrayList<JamDosen> jam = new ArrayList<>();
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("CALL checkjmlajarMIN('" + limit + "');");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Rooster rt = new Rooster();
                Rooster.JamDosen jm = rt.new JamDosen();
                jm.setKd_dosen(rs.getString("kd_dsn"));
                jm.setNm_dosen(rs.getString("nm_dsn"));
                jm.setJml_ajar(rs.getInt("jml_ajr"));
                
                jam.add(jm);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return jam;
    }
    
    public static Jadwal getJadwal(String kd_dosen,String kd_matkul,String kd_ruangan,String nama_kelas,String prodi,int kd_jam){
        Jadwal jadwal = new Jadwal();
        try {
            Connection con = (Connection) getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM jadwal_klh WHERE KD_DOSEN = \"" + kd_dosen + "\" AND KD_MATKUL = \"" + kd_matkul + "\" AND KD_RUANGAN = \"" + kd_ruangan + "\" AND NAMA_KELAS = \"" + nama_kelas + "\" AND PRODI = \"" + prodi + "\" AND KD_JAM = \"" + kd_jam + "\" ;");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                
                jadwal.setKD_DOSEN(rs.getString("KD_DOSEN"));
                jadwal.setNAMA_DOSEN(rs.getString("NAMA_DOSEN"));
                jadwal.setKD_JAM(rs.getInt("KD_JAM"));
                jadwal.setKD_MATKUL(rs.getString("KD_MATKUL"));
                jadwal.setNAMA_MATKUL(rs.getString("NAMA_MATKUL"));
                jadwal.setSKS(rs.getInt("SKS"));
                jadwal.setKD_RUANGAN(rs.getString("KD_RUANGAN"));
                jadwal.setNAMA_KELAS(rs.getString("NAMA_KELAS"));
                jadwal.setWAKTU_MULAI(rs.getString("WAKTU_MULAI"));
                jadwal.setWAKTU_SELESAI(rs.getString("WAKTU_SELESAI"));
                jadwal.setHARI(rs.getString("HARI"));
                jadwal.setPRODI(rs.getString("PRODI"));
                jadwal.setSEMESTER(rs.getString("SEMESTER"));
                jadwal.setTAHUN_AJARAN(rs.getString("TAHUN_AJARAN"));
                
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return jadwal;
    }
    
    public static int update(Jadwal _jadwal,String kd_dsen,String kd_mtkul,String kd_rngn,String nm_kelas,String prdi,int kd_jm){
        Integer stats = 0;
        try{
            Connection con = (Connection) getConnection();
            Statement st = con.createStatement();
            
            String kd_dosen = _jadwal.getKD_DOSEN();
            int kd_jam = _jadwal.getKD_JAM();
            String kd_matkul = _jadwal.getKD_MATKUL();
            String kd_ruangan = _jadwal.getKD_RUANGAN();
            String nama_kelas = _jadwal.getNAMA_KELAS();
            String hari = _jadwal.getHARI();
            String prodi = _jadwal.getPRODI();
            String semester = _jadwal.getSEMESTER();
            String tahun_ajaran = _jadwal.getTAHUN_AJARAN();
            
            String sql = "UPDATE jadwal SET KD_DOSEN = \"" + kd_dosen + "\", KD_MATKUL = \"" + kd_matkul +"\", KD_RUANGAN = \"" + kd_ruangan +"\", NAMA_KELAS = \"" + nama_kelas +"\", PRODI = \"" + prodi +"\", KD_JAM = \"" + kd_jam +"\",HARI = \"" + hari +"\", TAHUN_AJARAN = \"" + tahun_ajaran +"\", SEMESTER = \"" + semester +"\" WHERE KD_DOSEN = \"" + kd_dsen + "\" AND KD_MATKUL = \"" + kd_mtkul + "\" AND KD_RUANGAN = \"" + kd_rngn + "\" AND NAMA_KELAS = \"" + nm_kelas + "\" AND PRODI = \"" + prdi + "\" AND KD_JAM = \"" + kd_jm + "\" ;";
            stats = st.executeUpdate(sql);
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return stats;
    }
    
    public static int delete(String kd_dsen,String kd_mtkul,String kd_rngn,String nm_kelas,String prdi,int kd_jm){
        Integer stats = 0;
        try{
            Connection con = (Connection) getConnection();
            Statement st = con.createStatement();
            
            String sql = "DELETE FROM jadwal WHERE KD_DOSEN = \"" + kd_dsen + "\" AND KD_MATKUL = \"" + kd_mtkul + "\" AND KD_RUANGAN = \"" + kd_rngn + "\" AND NAMA_KELAS = \"" + nm_kelas + "\" AND PRODI = \"" + prdi + "\" AND KD_JAM = \"" + kd_jm + "\" ;";
            stats = st.executeUpdate(sql);
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return stats;
    }
    
    public static int save(Jadwal _jadwal){
        Integer stats = 0;
        try{
            Connection con = (Connection) getConnection();
            Statement st = con.createStatement();
            
            String kd_dosen = _jadwal.getKD_DOSEN();
            int kd_jam = _jadwal.getKD_JAM();
            String kd_matkul = _jadwal.getKD_MATKUL();
            String kd_ruangan = _jadwal.getKD_RUANGAN();
            String nama_kelas = _jadwal.getNAMA_KELAS();
            String hari = _jadwal.getHARI();
            String prodi = _jadwal.getPRODI();
            String semester = _jadwal.getSEMESTER();
            String tahun_ajaran = _jadwal.getTAHUN_AJARAN();
            
            String sql = "INSERT INTO jadwal (KD_DOSEN,KD_MATKUL,KD_RUANGAN,NAMA_KELAS,PRODI,KD_JAM,HARI,TAHUN_AJARAN,SEMESTER) VALUES(\"" + kd_dosen + "\",\"" + kd_matkul +"\",\"" + kd_ruangan +"\",\"" + nama_kelas +"\",\"" + prodi +"\",\"" + kd_jam +"\",\"" + hari +"\",\"" + tahun_ajaran +"\",\"" + semester +"\");";
            stats = st.executeUpdate(sql);
        } catch (SQLException ex){
            System.out.println(ex);
        }
        disconnect();
        return stats;
    }
}
