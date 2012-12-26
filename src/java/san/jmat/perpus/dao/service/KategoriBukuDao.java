/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import java.util.List;
import san.jmat.perpus.entity.KategoriBuku;

/**
 *
 * @author joker
 */
public interface KategoriBukuDao {

    public void Insert(KategoriBuku kategoriBuku) throws Exception;

    public void Update(Integer id, KategoriBuku kategoriBuku) throws Exception;

    public void Delete(Integer id) throws Exception;

    public List<KategoriBuku> selectAll() throws Exception;

    public KategoriBuku getById(Integer id) throws Exception;
}
