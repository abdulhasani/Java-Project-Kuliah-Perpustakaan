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
public class Buku {
    
    private Integer idBuku;
    private String judul;
    private String pengarang;
    private String penerbit;
    private String tahunTerbit;
    private KategoriBuku kategoriBuku;
    private String sinopsis;
    private Integer jumlahStok;
    private Integer jumlahTersedia;
    private String keterangan;

    public Buku() {
    }
    
    

    /**
     * @return the idBuku
     */
    public Integer getIdBuku() {
        return idBuku;
    }

    /**
     * @param idBuku the idBuku to set
     */
    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    /**
     * @return the judul
     */
    public String getJudul() {
        return judul;
    }

    /**
     * @param judul the judul to set
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }

    /**
     * @return the pengarang
     */
    public String getPengarang() {
        return pengarang;
    }

    /**
     * @param pengarang the pengarang to set
     */
    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    /**
     * @return the penerbit
     */
    public String getPenerbit() {
        return penerbit;
    }

    /**
     * @param penerbit the penerbit to set
     */
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    /**
     * @return the tahunTerbit
     */
    public String getTahunTerbit() {
        return tahunTerbit;
    }

    /**
     * @param tahunTerbit the tahunTerbit to set
     */
    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    /**
     * @return the kategoriBuku
     */
    public KategoriBuku getKategoriBuku() {
        return kategoriBuku;
    }

    /**
     * @param kategoriBuku the kategoriBuku to set
     */
    public void setKategoriBuku(KategoriBuku kategoriBuku) {
        this.kategoriBuku = kategoriBuku;
    }

    /**
     * @return the sinopsis
     */
    public String getSinopsis() {
        return sinopsis;
    }

    /**
     * @param sinopsis the sinopsis to set
     */
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    /**
     * @return the jumlahStok
     */
    public Integer getJumlahStok() {
        return jumlahStok;
    }

    /**
     * @param jumlahStok the jumlahStok to set
     */
    public void setJumlahStok(Integer jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    /**
     * @return the jumlahTersedia
     */
    public Integer getJumlahTersedia() {
        return jumlahTersedia;
    }

    /**
     * @param jumlahTersedia the jumlahTersedia to set
     */
    public void setJumlahTersedia(Integer jumlahTersedia) {
        this.jumlahTersedia = jumlahTersedia;
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
