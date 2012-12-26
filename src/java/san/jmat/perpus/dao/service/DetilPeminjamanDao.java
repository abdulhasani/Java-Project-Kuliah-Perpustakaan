/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import java.util.List;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.DetilPeminjaman;
import san.jmat.perpus.entity.Peminjaman;

/**
 *
 * @author joker
 */
public interface DetilPeminjamanDao {

    public void Insert(DetilPeminjaman detilPeminjaman) throws Exception;

    public List<DetilPeminjaman> selectAll() throws Exception;

    public DetilPeminjaman getPeminjamId(Long peminjamId) throws Exception;

    public DetilPeminjaman getByBukuID(Integer bukuId) throws Exception;
}
