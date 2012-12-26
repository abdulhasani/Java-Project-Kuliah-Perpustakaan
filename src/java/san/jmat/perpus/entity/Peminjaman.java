/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author joker
 */
public class Peminjaman {
    
    private Long idPeminjaman;
    private Date tanggalPinjam;
    private Date tanggalHarusKembali;
    private String nomorAnggota;
    private String keterangan;
    private String judulBuku;
    private String status;
    private List<DetilPeminjaman> detilPeminjamans=new ArrayList<>();

    public List<DetilPeminjaman> getDetilPeminjamans() {
        return detilPeminjamans;
    }

    public void setDetilPeminjamans(List<DetilPeminjaman> detilPeminjamans) {
        this.detilPeminjamans = detilPeminjamans;
    }

    public Long getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(Long idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }
    
    /**
     * @return the tanggalPinjam
     */
    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    /**
     * @param tanggalPinjam the tanggalPinjam to set
     */
    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    /**
     * @return the tanggalHarusKembali
     */
    public Date getTanggalHarusKembali() {
        return tanggalHarusKembali;
    }

    /**
     * @param tanggalHarusKembali the tanggalHarusKembali to set
     */
    public void setTanggalHarusKembali(Date tanggalHarusKembali) {
        this.tanggalHarusKembali = tanggalHarusKembali;
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

    /**
     * @return the judulBuku
     */
    public String getJudulBuku() {
        return judulBuku;
    }

    /**
     * @param judulBuku the judulBuku to set
     */
    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
