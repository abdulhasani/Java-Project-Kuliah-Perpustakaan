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
public class rengkingPeminjaman {
    private Anggota anggota;
    private KategoriAnggota kategoriAnggota;
    private Long rengking;

    public rengkingPeminjaman() {
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public KategoriAnggota getKategoriAnggota() {
        return kategoriAnggota;
    }

    public void setKategoriAnggota(KategoriAnggota kategoriAnggota) {
        this.kategoriAnggota = kategoriAnggota;
    }

    public Long getRengking() {
        return rengking;
    }

    public void setRengking(Long rengking) {
        this.rengking = rengking;
    }

}
