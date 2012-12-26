/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import java.util.List;
import san.jmat.perpus.entity.KeuanganDenda;

/**
 *
 * @author joker
 */
public interface KeUanganPendendaanDao {

    public void Insert(KeuanganDenda keuanganDenda) throws Exception;

    public void DeleteAll() throws Exception;

    public List<KeuanganDenda> selectAll() throws Exception;

    public Integer sum() throws Exception;

    public List<KeuanganDenda> filter(String filter) throws Exception;
}
