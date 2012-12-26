/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.entity;

import java.util.Date;

/**
 *
 * @author joker
 */
public class DetilKeUanganPeminjaman {
    private Long id;
    private String nomorAnggota;
    private Date tanggalPemasukan;
    private Integer nominalPemasukan;
    private Integer jumlahItem;

    public DetilKeUanganPeminjaman() {
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

    public Date getTanggalPemasukan() {
        return tanggalPemasukan;
    }

    public void setTanggalPemasukan(Date tanggalPemasukan) {
        this.tanggalPemasukan = tanggalPemasukan;
    }

    public Integer getNominalPemasukan() {
        return nominalPemasukan;
    }

    public void setNominalPemasukan(Integer nominalPemasukan) {
        this.nominalPemasukan = nominalPemasukan;
    }

    public Integer getJumlahItem() {
        return jumlahItem;
    }

    public void setJumlahItem(Integer jumlahItem) {
        this.jumlahItem = jumlahItem;
    }
    
    
}
