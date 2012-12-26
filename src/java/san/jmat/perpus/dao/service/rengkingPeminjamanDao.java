/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import san.jmat.perpus.entity.rengkingPeminjaman;

/**
 *
 * @author joker
 */
public interface rengkingPeminjamanDao {

    public void Insert(rengkingPeminjaman rengkingPeminjaman) throws Exception;

    public void Update(Integer id, rengkingPeminjaman rengkingPeminjaman) throws Exception;

    public void Delete(Integer id) throws Exception;

    public rengkingPeminjaman getByIdAnggota(Integer id) throws Exception;

    public rengkingPeminjaman getByRengking(Long rengking) throws Exception;
}
