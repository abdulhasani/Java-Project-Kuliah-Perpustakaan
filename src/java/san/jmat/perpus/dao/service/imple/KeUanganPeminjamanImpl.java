/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service.imple;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import san.jmat.perpus.dao.service.KeUanganPeminjamanDao;
import san.jmat.perpus.entity.DetilKeUanganPeminjaman;
import san.jmat.perpus.entity.DetilPeminjaman;
import san.jmat.perpus.entity.KeuanganPeminjaman;

/**
 *
 * @author joker
 */
public class KeUanganPeminjamanImpl implements KeUanganPeminjamanDao {

    private Connection connection;
    private final String insert1 = "INSERT INTO keuanganPeminjaman (id,nomorAnggota,jumlahItem,tanggalPemasukan,nominalPemasukan) VALUES (?,?,?,?,?)";
    private final String insert2 = "INSERT INTO detilKeuanganPeminjaman (nomorAnggota,idBuku) VALUES (?,?)";
    private final String select = "SELECT * FROM keuanganPeminjaman";
    private final String sum = "SELECT SUM(nominalPemasukan) as total FROM keuanganPeminjaman";
    private final String deleteAll="DELETE FROM keuanganPeminjaman";

    public KeUanganPeminjamanImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert() throws Exception {
        PreparedStatement statement1;
        PreparedStatement statement2;
        statement1 = null;
        statement2 = null;
        Long id = System.currentTimeMillis();
        try {


            connection.setAutoCommit(false);
            statement1 = connection.prepareStatement(insert1);
            statement1.setLong(1, id);
            statement1.setString(2, KeuanganPeminjaman.getNomorAnggota());
            statement1.setInt(3, KeuanganPeminjaman.getDetilPeminjamans().size());
            statement1.setDate(4, new Date(KeuanganPeminjaman.getTanggalPemasukan().getTime()));
            statement1.setInt(5, KeuanganPeminjaman.getNominalPemasukan());
            statement1.executeUpdate();
            for (DetilPeminjaman detilPeminjaman : KeuanganPeminjaman.getDetilPeminjamans()) {
                statement2 = connection.prepareStatement(insert2);
                statement2.setString(1, KeuanganPeminjaman.getNomorAnggota());
                statement2.setInt(2, detilPeminjaman.getBukuId().getIdBuku());
                statement2.executeUpdate();
            }
            connection.commit();
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
            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                }
            }
            if (statement2 != null) {
                try {
                    statement2.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void DeletAll() throws Exception {
        PreparedStatement statement;
        statement = null;
        try{
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(deleteAll);
            statement.executeUpdate();
            connection.commit();
        }catch(SQLException e){
            try{
                connection.rollback();
            }catch(SQLException ex){
                
            }
            throw new Exception(e.getMessage());
        }finally{
            try{
                connection.setAutoCommit(true);
            }catch(SQLException e){
                
            }
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException e){
                    
                }
            }
        }
    }

    @Override
    public List<DetilKeUanganPeminjaman> selectAll() throws Exception {
        PreparedStatement statement;
        statement = null;
        ResultSet resultSet;
        resultSet = null;
        List<DetilKeUanganPeminjaman> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(select);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DetilKeUanganPeminjaman detilKeUanganPeminjaman = new DetilKeUanganPeminjaman();
                detilKeUanganPeminjaman.setId(resultSet.getLong("id"));
                detilKeUanganPeminjaman.setNomorAnggota(resultSet.getString("nomorAnggota"));
                detilKeUanganPeminjaman.setJumlahItem(resultSet.getInt("jumlahItem"));
                detilKeUanganPeminjaman.setTanggalPemasukan(resultSet.getDate("tanggalPemasukan"));
                detilKeUanganPeminjaman.setNominalPemasukan(resultSet.getInt("nominalPemasukan"));
                list.add(detilKeUanganPeminjaman);
            }
            connection.commit();
            return list;
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
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public Integer sum() throws Exception {
        PreparedStatement statement;
        statement = null;
        ResultSet resultSet;
        resultSet = null;
        Integer totalNominal;
        totalNominal = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sum);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                totalNominal = (resultSet.getInt("total"));
            }
            connection.commit();
            return totalNominal;
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
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public List<DetilKeUanganPeminjaman> filter(String filter) throws Exception {
        String sql="SELECT * FROM keuanganPeminjaman WHERE nomorAnggota='"+filter+"' OR tanggalPemasukan LIKE '%"+filter+"%'";
        Statement statement;
        statement = null;
        ResultSet resultSet;
        resultSet = null;
        List<DetilKeUanganPeminjaman> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DetilKeUanganPeminjaman detilKeUanganPeminjaman = new DetilKeUanganPeminjaman();
                detilKeUanganPeminjaman.setId(resultSet.getLong("id"));
                detilKeUanganPeminjaman.setNomorAnggota(resultSet.getString("nomorAnggota"));
                detilKeUanganPeminjaman.setJumlahItem(resultSet.getInt("jumlahItem"));
                detilKeUanganPeminjaman.setTanggalPemasukan(resultSet.getDate("tanggalPemasukan"));
                detilKeUanganPeminjaman.setNominalPemasukan(resultSet.getInt("nominalPemasukan"));
                list.add(detilKeUanganPeminjaman);
            }
            connection.commit();
            return list;
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
                } catch (SQLException ex) {
                }
            }
        }
    }
}
