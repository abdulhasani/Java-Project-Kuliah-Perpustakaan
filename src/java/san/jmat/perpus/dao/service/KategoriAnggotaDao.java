/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import java.util.List;
import san.jmat.perpus.entity.KategoriAnggota;

/**
 *
 * @author joker
 */
public interface KategoriAnggotaDao {

    public void Insert(KategoriAnggota kategoriAnggota) throws Exception;

    public void Update(Integer id, KategoriAnggota kategoriAnggota) throws Exception;

    public void Delete(Integer id) throws Exception;

    public List<KategoriAnggota> selectAll() throws Exception;

    public KategoriAnggota getById(Integer id) throws Exception;
}
