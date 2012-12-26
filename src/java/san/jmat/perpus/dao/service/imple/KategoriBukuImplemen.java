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
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.entity.KategoriBuku;

/**
 *
 * @author joker
 */
public class KategoriBukuImplemen implements KategoriBukuDao {

    private Connection connection;
    private final String Insert = "INSERT INTO kategori_buku (Nama,Keterangan) VALUES (?,?) ";
    private final String Update = "UPDATE kategori_buku SET Nama=?,Keterangan=? WHERE IdKategoriBuku=? ";
    private final String Delete = "DELETE FROM kategori_buku  WHERE IdKategoriBuku=? ";
    private final String SelectAll = "SELECT * FROM kategori_buku ";
    private final String getById = "SELECT * FROM kategori_buku WHERE IdKategoriBuku=? ";

    public KategoriBukuImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert(KategoriBuku kategoriBuku) throws Exception {
        PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(Insert);
            statement.setString(1, kategoriBuku.getNama());
            statement.setString(2, kategoriBuku.getKeterangan());
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
    public void Update(Integer id, KategoriBuku kategoriBuku) throws Exception {
        PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(Update);
            statement.setString(1, kategoriBuku.getNama());
            statement.setString(2, kategoriBuku.getKeterangan());
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
    public List<KategoriBuku> selectAll() throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        List<KategoriBuku> list;
        statement = null;
        resultSet = null;
        list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SelectAll);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                KategoriBuku kategoriBuku = new KategoriBuku();
                kategoriBuku.setIdKategoriBuku(resultSet.getInt("idKategoriBuku"));
                kategoriBuku.setNama(resultSet.getString("Nama"));
                kategoriBuku.setKeterangan(resultSet.getString("Keterangan"));
                list.add(kategoriBuku);

            }
            connection.commit();
            return list;
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
            }
            throw new Exception(ex.getMessage());
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

    @Override
    public KategoriBuku getById(Integer id) throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        try {

            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            KategoriBuku kategoriBuku = null;
            if (resultSet.next()) {
                kategoriBuku = new KategoriBuku();
                kategoriBuku.setIdKategoriBuku(resultSet.getInt("idKategoriBuku"));
                kategoriBuku.setNama(resultSet.getString("Nama"));
                kategoriBuku.setKeterangan(resultSet.getString("Keterangan"));
            }


            return kategoriBuku;
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        } finally {

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
