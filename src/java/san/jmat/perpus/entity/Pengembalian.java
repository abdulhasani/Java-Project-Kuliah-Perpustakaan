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
public class Pengembalian {
    
    private Long id;
    private String nomorAnggota;
    private String judulBuku;
    private Date ketentuanTglKembali;
    private Date tglKembali;
    private List<Peminjaman> peminjamans=new ArrayList<>();
    public Pengembalian() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomorAnggota() {
        return nomorAnggota;
    }

    public void setNomorAnggota(String nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public Date getKetentuanTglKembali() {
        return ketentuanTglKembali;
    }

    public void setKetentuanTglKembali(Date ketentuanTglKembali) {
        this.ketentuanTglKembali = ketentuanTglKembali;
    }

    
    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }

    public List<Peminjaman> getPeminjamans() {
        return peminjamans;
    }

    public void setPeminjamans(List<Peminjaman> peminjamans) {
        this.peminjamans = peminjamans;
    }
    
    

}
