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
public class KeuanganPeminjaman {
    private Long id;
    private static String nomorAnggota;
    private static Date tanggalPemasukan;
    private static Integer nominalPemasukan;
    private static List<DetilPeminjaman> detilPeminjamans=new ArrayList<>();
    public KeuanganPeminjaman() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static String getNomorAnggota() {
        return nomorAnggota;
    }

    public static void setNomorAnggota(String nomorAnggota) {
        KeuanganPeminjaman.nomorAnggota = nomorAnggota;
    }

    public static Date getTanggalPemasukan() {
        return tanggalPemasukan;
    }

    public static void setTanggalPemasukan(Date tanggalPemasukan) {
        
        KeuanganPeminjaman.tanggalPemasukan = tanggalPemasukan;
    }

    public static Integer getNominalPemasukan() {
        return nominalPemasukan;
    }

    public static void setNominalPemasukan(Integer nominalPemasukan) {
        KeuanganPeminjaman.nominalPemasukan = nominalPemasukan;
    }

    public static List<DetilPeminjaman> getDetilPeminjamans() {
        return detilPeminjamans;
    }

    public static void setDetilPeminjamans(List<DetilPeminjaman> detilPeminjamans) {
        KeuanganPeminjaman.detilPeminjamans = detilPeminjamans;
    }

    
   
    
}
