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
public class Mata_Kuliah {
    private String KD_MATKUL;
    private String NAMA_MATKUL;
    private int SKS;

    /**
     * @return the KD_MATKUL
     */
    public String getKD_MATKUL() {
        return KD_MATKUL;
    }

    /**
     * @param KD_MATKUL the KD_MATKUL to set
     */
    public void setKD_MATKUL(String KD_MATKUL) {
        this.KD_MATKUL = KD_MATKUL;
    }

    /**
     * @return the NAMA_MATKUL
     */
    public String getNAMA_MATKUL() {
        return NAMA_MATKUL;
    }

    /**
     * @param NAMA_MATKUL the NAMA_MATKUL to set
     */
    public void setNAMA_MATKUL(String NAMA_MATKUL) {
        this.NAMA_MATKUL = NAMA_MATKUL;
    }

    /**
     * @return the SKS
     */
    public int getSKS() {
        return SKS;
    }

    /**
     * @param SKS the SKS to set
     */
    public void setSKS(int SKS) {
        this.SKS = SKS;
    }
}
