/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.entity;

/**
 *
 * @author joker
 */
public class KategoriBuku {
    private Integer idKategoriBuku;
    private String nama;
    private String keterangan;

    public KategoriBuku() {
    }
    
    
    
    /**
     * @return the idKategoriBuku
     */
    public Integer getIdKategoriBuku() {
        return idKategoriBuku;
    }

    /**
     * @param idKategoriBuku the idKategoriBuku to set
     */
    public void setIdKategoriBuku(Integer idKategoriBuku) {
        this.idKategoriBuku = idKategoriBuku;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
