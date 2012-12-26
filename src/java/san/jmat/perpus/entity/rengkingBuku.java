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
public class rengkingBuku {
    
    private Buku buku;
    private KategoriBuku kategoriBuku;
    private Long rengking;

    public rengkingBuku() {
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public KategoriBuku getKategoriBuku() {
        return kategoriBuku;
    }

    public void setKategoriBuku(KategoriBuku kategoriBuku) {
        this.kategoriBuku = kategoriBuku;
    }

    public Long getRengking() {
        return rengking;
    }

    public void setRengking(Long rengking) {
        this.rengking = rengking;
    }

    
}
