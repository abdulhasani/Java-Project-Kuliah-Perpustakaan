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
import san.jmat.perpus.entity.KategoriBuku;

/**
 *
 * @author joker
 */
public interface BukuDao {

    public void Insert(Buku buku) throws Exception;

    public void Update(Integer id, Buku buku) throws Exception;

    public void Delete(Integer id) throws Exception;

    public List<Buku> selectAll() throws Exception;

    public List<Buku> getByKategoriBukuId(Integer katId) throws Exception;

    public Buku getById(Integer id) throws Exception;

    public List<Buku> getJudulorId(String judul, String id) throws Exception;

    public List<Buku> Filter(String judul, String pengarang, String penerbit, String tahunTerbit) throws Exception;
    
    
}
