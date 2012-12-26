/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import san.jmat.perpus.entity.Peminjaman;

/**
 *
 * @author joker
 */
public interface PeminjamanDao {

    public void Insert(Peminjaman peminjaman, String nomorAnggota) throws Exception;

    public void Update(Integer id, Peminjaman peminjaman) throws Exception;

    public void Delete2(String nomorAnggota) throws Exception;

    public void Delete2(Long idPeminjam) throws Exception;

    public List<Peminjaman> filter(String filter) throws Exception;

    public List<Peminjaman> joinTable() throws Exception;

    public Long bukuDipinjam() throws Exception;

    public Peminjaman getById(Long id) throws Exception;

    public Peminjaman getById2(Long id) throws Exception;

    public List<Peminjaman> getByNomorAnggota(String nomorAnggota) throws Exception;
}
