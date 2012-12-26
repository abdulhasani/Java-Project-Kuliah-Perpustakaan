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
import java.util.ArrayList;
import java.util.List;
import san.jmat.perpus.dao.service.KategoriAnggotaDao;
import san.jmat.perpus.entity.KategoriAnggota;

/**
 *
 * @author joker
 */
public class KategoriAnggotaImplemen implements KategoriAnggotaDao {

    private Connection connection;
    private final String Insert = "INSERT INTO kategorianggota (Nama,keterangan) VALUES (?,?) ";
    private final String Update = "UPDATE kategorianggota SET Nama=?,keterangan=? WHERE IdKategoriAnggota=? ";
    private final String Delete = "DELETE FROM kategorianggota WHERE IdKategoriAnggota=? ";
    private final String selectAll = "SELECT * FROM kategorianggota ";
    private final String getById = "SELECT IdKategoriAnggota,Nama,keterangan FROM kategorianggota WHERE IdKategoriAnggota=? ";

    public KategoriAnggotaImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert(KategoriAnggota kategoriAnggota) throws Exception {
        PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(Insert);
            statement.setString(1, kategoriAnggota.getNama());
            statement.setString(2, kategoriAnggota.getKeterangan());
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
    public void Update(Integer id, KategoriAnggota kategoriAnggota) throws Exception {
        PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(Update);
            statement.setString(1, kategoriAnggota.getNama());
            statement.setString(2, kategoriAnggota.getKeterangan());
            statement.setInt(3, id);
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
    public void Delete(Integer id) throws Exception {
       PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(Delete);
            statement.setInt(1, id);
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
    public List<KategoriAnggota> selectAll() throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        List<KategoriAnggota> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectAll);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                KategoriAnggota kategoriAnggota = new KategoriAnggota();
                kategoriAnggota.setIdKategoriAnggota(resultSet.getInt("idKategoriAnggota"));
                kategoriAnggota.setNama(resultSet.getString("Nama"));
                kategoriAnggota.setKeterangan(resultSet.getString("keterangan"));
                list.add(kategoriAnggota);
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
                } catch (SQLException ex) {
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
    public KategoriAnggota getById(Integer id) throws Exception {
        KategoriAnggota kategoriAnggota;
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        kategoriAnggota = null;
        try {
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                kategoriAnggota = new KategoriAnggota();
                kategoriAnggota.setIdKategoriAnggota(resultSet.getInt("idKategoriAnggota"));
                kategoriAnggota.setNama(resultSet.getString("Nama"));
                kategoriAnggota.setKeterangan(resultSet.getString("keterangan"));
            }
            return kategoriAnggota;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
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
