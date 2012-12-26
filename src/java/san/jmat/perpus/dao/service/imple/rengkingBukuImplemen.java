/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service.imple;

import java.sql.Connection;
import san.jmat.perpus.dao.service.rengkingBukuDao;
import san.jmat.perpus.entity.rengkingBuku;

/**
 *
 * @author joker
 */
public class rengkingBukuImplemen implements rengkingBukuDao{
    private Connection connection;

    public rengkingBukuImplemen(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void Insert(rengkingBuku rengkingBuku) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Update(Integer id, rengkingBuku rengkingBuku) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public rengkingBuku getByIdAnggota(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public rengkingBuku getByRengking(Long rengking) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
