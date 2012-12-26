/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import java.util.List;
import san.jmat.perpus.entity.Anggota;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.DetilKeUanganPeminjaman;
import san.jmat.perpus.entity.KeuanganPeminjaman;

/**
 *
 * @author joker
 */
public interface KeUanganPeminjamanDao {

    public void Insert() throws Exception;

    public void DeletAll() throws Exception;

    public List<DetilKeUanganPeminjaman> selectAll() throws Exception;

    public Integer sum() throws Exception;

    public List<DetilKeUanganPeminjaman> filter(String filter) throws Exception;
}
