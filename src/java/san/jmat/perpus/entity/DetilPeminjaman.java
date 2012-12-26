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
public class DetilPeminjaman {
    
    private Peminjaman peminjamanId;
    private Buku bukuId;
    private String status;
    
    
    
    /**
     * @return the peminjamanId
     */
    public Peminjaman getPeminjamanId() {
        return peminjamanId;
    }

    /**
     * @param peminjamanId the peminjamanId to set
     */
    public void setPeminjamanId(Peminjaman peminjamanId) {
        this.peminjamanId = peminjamanId;
    }

    /**
     * @return the bukuId
     */
    public Buku getBukuId() {
        return bukuId;
    }

    /**
     * @param bukuId the bukuId to set
     */
    public void setBukuId(Buku bukuId) {
        this.bukuId = bukuId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
