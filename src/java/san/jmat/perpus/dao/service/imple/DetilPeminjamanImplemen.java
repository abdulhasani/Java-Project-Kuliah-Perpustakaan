/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import san.jmat.perpus.dao.service.DetilPeminjamanDao;
import san.jmat.perpus.entity.DetilPeminjaman;

/**
 *
 * @author joker
 */
public class DetilPeminjamanImplemen implements DetilPeminjamanDao {

    private Connection connection;
    private final String getBukuId = "SELECT * FROM detilPeminjaman WHERE bukuId=?";
    

    public DetilPeminjamanImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert(DetilPeminjaman detilPeminjaman) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DetilPeminjaman> selectAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DetilPeminjaman getPeminjamId(Long peminjamId) throws Exception {
        
        
        return null;
    }

    @Override
    public DetilPeminjaman getByBukuID(Integer bukuId) throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getBukuId);
            statement.setInt(1, bukuId);
            resultSet = statement.executeQuery();
            DetilPeminjaman detilPeminjaman = null;
            if (resultSet.next()) {
                detilPeminjaman = new DetilPeminjaman();
                detilPeminjaman.setPeminjamanId(new PeminjamanImplemen(connection).getById(resultSet.getLong("peminjamanId")));
                detilPeminjaman.setStatus(resultSet.getString("status"));
            }
            connection.commit();
            return detilPeminjaman;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new Exception(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
        }

    }
}
