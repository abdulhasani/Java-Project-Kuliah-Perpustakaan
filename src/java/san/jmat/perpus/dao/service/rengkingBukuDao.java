/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import san.jmat.perpus.entity.rengkingBuku;

/**
 *
 * @author joker
 */
public interface rengkingBukuDao {

    public void Insert(rengkingBuku rengkingBuku) throws Exception;

    public void Update(Integer id, rengkingBuku rengkingBuku) throws Exception;

    public void Delete(Integer id) throws Exception;

    public rengkingBuku getByIdAnggota(Integer id) throws Exception;

    public rengkingBuku getByRengking(Long rengking) throws Exception;
}
