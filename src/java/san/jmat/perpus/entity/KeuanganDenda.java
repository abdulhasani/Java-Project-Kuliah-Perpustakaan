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
public class KeuanganDenda {

    private Long id;
    private String nomorAnggota;
    private Date tanggalPendendaan;
    private Integer nominalDenda;
    private Integer keteranganDenda;
    private String keterangan;
    private List<String> list = new ArrayList<>();

    public KeuanganDenda() {
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

    public Date getTanggalPendendaan() {
        return tanggalPendendaan;
    }

    public void setTanggalPendendaan(Date tanggalPendendaan) {
        this.tanggalPendendaan = tanggalPendendaan;
    }

    public Integer getNominalDenda() {
        return nominalDenda;
    }

    public void setNominalDenda(Integer nominalDenda) {
        this.nominalDenda = nominalDenda;
    }

    public Integer getKeteranganDenda() {
        return keteranganDenda;
    }

    public void setKeteranganDenda(Integer keteranganDenda) {
        this.keteranganDenda = keteranganDenda;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    
    
}
