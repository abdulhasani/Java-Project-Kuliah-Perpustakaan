/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import java.util.Date;
import java.util.List;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.Pengembalian;

/**
 *
 * @author joker
 */
public interface PengembalianDao {

    public void Insert(Pengembalian pengembalian, String nomorAnggota) throws Exception;

    public void Insert2(Pengembalian pengembalian, Long idPeminjam) throws Exception;

    public void deleteAll() throws Exception;

    public void delete(Long id) throws Exception;

    public List<Pengembalian> selectAll() throws Exception;

    public List<Pengembalian> filter(String filter) throws Exception;
}
