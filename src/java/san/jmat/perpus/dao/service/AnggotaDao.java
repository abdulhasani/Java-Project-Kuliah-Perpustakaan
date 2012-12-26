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

/**
 *
 * @author joker
 */
public interface AnggotaDao {

    public void Insert(Anggota anggota) throws Exception;

    public void Update(Integer id, Anggota anggota) throws Exception;

    public void Delete(Integer id) throws Exception;

    public List<Anggota> selectAll() throws Exception;

    public List<Anggota> getByKategoriAnggotaId(Integer ktgId) throws Exception;

    public Anggota getById(Integer id) throws Exception;

    public List<Anggota> getNamanNomor(String nama, String nomorAnggota) throws Exception;

    public Anggota getByNomorAnggota(String nomorAnggota) throws Exception;
}
