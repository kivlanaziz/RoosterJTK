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
public class Ruangan {
    private String KD_RUANGAN;
    private int LANTAI;
    private String JENIS;

    /**
     * @return the KD_RUANGAN
     */
    public String getKD_RUANGAN() {
        return KD_RUANGAN;
    }

    /**
     * @param KD_RUANGAN the KD_RUANGAN to set
     */
    public void setKD_RUANGAN(String KD_RUANGAN) {
        this.KD_RUANGAN = KD_RUANGAN;
    }

    /**
     * @return the LANTAI
     */
    public int getLANTAI() {
        return LANTAI;
    }

    /**
     * @param LANTAI the LANTAI to set
     */
    public void setLANTAI(int LANTAI) {
        this.LANTAI = LANTAI;
    }

    /**
     * @return the JENIS
     */
    public String getJENIS() {
        return JENIS;
    }

    /**
     * @param JENIS the JENIS to set
     */
    public void setJENIS(String JENIS) {
        this.JENIS = JENIS;
    }
}
