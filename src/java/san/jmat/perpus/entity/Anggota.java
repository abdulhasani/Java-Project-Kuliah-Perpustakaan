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
public class Anggota {
    private Integer idAnggota;
    private String nomorAnggota;
    private String nama;
    private String noIdentitas;
    private String jenisIdentitas;
    private String alamat;
    private KategoriAnggota kategoriAnggota;
    private String keterangan;

    public Anggota() {
    }
    
    

    public KategoriAnggota getKategoriAnggota() {
        return kategoriAnggota;
    }

    public void setKategoriAnggota(KategoriAnggota kategoriAnggota) {
        this.kategoriAnggota = kategoriAnggota;
    }

    
    
    /**
     * @return the idAnggota
     */
    public Integer getIdAnggota() {
        return idAnggota;
    }

    /**
     * @param idAnggota the idAnggota to set
     */
    public void setIdAnggota(Integer idAnggota) {
        this.idAnggota = idAnggota;
    }

    /**
     * @return the nomorAnggota
     */
    public String getNomorAnggota() {
        return nomorAnggota;
    }

    /**
     * @param nomorAnggota the nomorAnggota to set
     */
    public void setNomorAnggota(String nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
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
     * @return the noIdentitas
     */
    public String getNoIdentitas() {
        return noIdentitas;
    }

    /**
     * @param noIdentitas the noIdentitas to set
     */
    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    /**
     * @return the jenisIdentitas
     */
    public String getJenisIdentitas() {
        return jenisIdentitas;
    }

    /**
     * @param jenisIdentitas the jenisIdentitas to set
     */
    public void setJenisIdentitas(String jenisIdentitas) {
        this.jenisIdentitas = jenisIdentitas;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
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
