/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service.imple;

import java.sql.Connection;
import san.jmat.perpus.dao.service.rengkingPeminjamanDao;
import san.jmat.perpus.entity.rengkingPeminjaman;

/**
 *
 * @author joker
 */
public class rengkingPeminjamImplemen implements rengkingPeminjamanDao{
    private Connection connection;

    public rengkingPeminjamImplemen(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void Insert(rengkingPeminjaman rengkingPeminjaman) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Update(Integer id, rengkingPeminjaman rengkingPeminjaman) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public rengkingPeminjaman getByIdAnggota(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public rengkingPeminjaman getByRengking(Long rengking) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
