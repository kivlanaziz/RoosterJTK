/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author kivla
 */
public class Waktu {
    private int KD_JAM;
    private java.sql.Time WAKTU_MULAI;
    private java.sql.Time WAKTU_SELESAI;

    /**
     * @return the KD_JAM
     */
    public int getKD_JAM() {
        return KD_JAM;
    }

    /**
     * @param KD_JAM the KD_JAM to set
     */
    public void setKD_JAM(int KD_JAM) {
        this.KD_JAM = KD_JAM;
    }

    /**
     * @return the WAKTU_MULAI
     */
    public java.sql.Time getWAKTU_MULAI() {
        return WAKTU_MULAI;
    }

    /**
     * @param WAKTU_MULAI the WAKTU_MULAI to set
     */
    public void setWAKTU_MULAI(java.sql.Time WAKTU_MULAI) {
        this.WAKTU_MULAI = WAKTU_MULAI;
    }

    /**
     * @return the WAKTU_SELESAI
     */
    public java.sql.Time getWAKTU_SELESAI() {
        return WAKTU_SELESAI;
    }

    /**
     * @param WAKTU_SELESAI the WAKTU_SELESAI to set
     */
    public void setWAKTU_SELESAI(java.sql.Time WAKTU_SELESAI) {
        this.WAKTU_SELESAI = WAKTU_SELESAI;
    }
}
