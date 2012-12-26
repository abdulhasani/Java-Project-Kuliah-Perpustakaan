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
import san.jmat.perpus.dao.service.KeUanganPendendaanDao;
import san.jmat.perpus.entity.KeuanganDenda;

/**
 *
 * @author joker
 */
public class KeUanganPendendaanImpl implements KeUanganPendendaanDao {

    private final String insert = "INSERT INTO keuanganDenda (id,nomorAnggota,tanggalPendendaan,nominalDenda) VALUES (?,?,?,?) ";
    private final String insert2 = "INSERT INTO detilKeUanganPendendaan (id,keterangan) VALUES (?,?) ";
    private Connection connection;
    private final String select = "SELECT * FROM keuanganDenda ";
    private final String sum = "SELECT SUM(nominalDenda) as total FROM keuanganDenda";
    private final String delete = "DELETE FROM keuanganDenda ";

    public KeUanganPendendaanImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert(KeuanganDenda keuanganDenda) throws Exception {
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insert);
            Long time = System.currentTimeMillis();
            statement.setLong(1, time);
            statement.setString(2, keuanganDenda.getNomorAnggota());
            statement.setDate(3, new Date(keuanganDenda.getTanggalPendendaan().getTime()));
            statement.setInt(4, keuanganDenda.getNominalDenda());
            statement.executeUpdate();
            for (String ket : keuanganDenda.getList()) {
                statement2 = connection.prepareStatement(insert2);
                statement2.setLong(1, time);
                statement2.setString(2, ket);
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
            if (statement != null) {
                try {
                    statement.close();
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
    public void DeleteAll() throws Exception {
        PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(delete);
            statement.executeUpdate();
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
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<KeuanganDenda> selectAll() throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        List<KeuanganDenda> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(select);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                KeuanganDenda keuanganDenda = new KeuanganDenda();
                keuanganDenda.setId(resultSet.getLong("id"));
                keuanganDenda.setNomorAnggota(resultSet.getString("nomorAnggota"));
                keuanganDenda.setTanggalPendendaan(resultSet.getDate("tanggalPendendaan"));
                keuanganDenda.setNominalDenda(resultSet.getInt("nominalDenda"));
                list.add(keuanganDenda);
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
                } catch (SQLException x) {
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

    @Override
    public Integer sum() throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        Integer total = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sum);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt("total");
            }
            connection.commit();
            return total;
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
                } catch (SQLException x) {
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

    @Override
    public List<KeuanganDenda> filter(String filter) throws Exception {
        String sql="SELECT * FROM keuanganDenda WHERE nomorAnggota='"+filter+"' OR tanggalPendendaan LIKE '%"+filter+"%'";
        Statement statement;
        statement = null;
        ResultSet resultSet;
        resultSet = null;
        List<KeuanganDenda> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                KeuanganDenda keuanganDenda = new KeuanganDenda();
                keuanganDenda.setId(resultSet.getLong("id"));
                keuanganDenda.setNomorAnggota(resultSet.getString("nomorAnggota"));
                keuanganDenda.setTanggalPendendaan(resultSet.getDate("tanggalPendendaan"));
                keuanganDenda.setNominalDenda(resultSet.getInt("nominalDenda"));
                list.add(keuanganDenda);
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
                } catch (SQLException x) {
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
