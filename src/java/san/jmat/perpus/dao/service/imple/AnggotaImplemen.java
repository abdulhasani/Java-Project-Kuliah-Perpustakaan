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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import san.jmat.perpus.dao.service.AnggotaDao;
import san.jmat.perpus.entity.Anggota;

/**
 *
 * @author joker
 */
public class AnggotaImplemen implements AnggotaDao {

    private Connection connection;
    private final String selecAll = "SELECT * FROM anggota";
    private final String getAnggotaId = "SELECT * FROM anggota WHERE idAnggota=?";
    private final String getKtgAnggotaId = "SELECT * FROM anggota WHERE idKategotiAnggota=?";
    private final String insert="INSERT INTO anggota (nomorAnggota,nama,noIdentitas,jenisIdentitas,alamat,idKategotiAnggota,keterangan) VALUES (?,?,?,?,?,?,?)";
    private final String update="UPDATE anggota SET nomorAnggota=?,nama=?,noIdentitas=?,jenisIdentitas=?,alamat=?,idKategotiAnggota=?,keterangan=? WHERE idAnggota=? ";
    private final String delete="DELETE FROM anggota WHERE idAnggota=?";
    private final String getByNomorAnggota="SELECT * FROM anggota WHERE nomorAnggota=?";
    
    public AnggotaImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert(Anggota anggota) throws Exception {
        PreparedStatement statement;
        statement=null;
        try{
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(insert);
            statement.setString(1, anggota.getNomorAnggota());
            statement.setString(2, anggota.getNama());
            statement.setString(3, anggota.getNoIdentitas());
            statement.setString(4, anggota.getJenisIdentitas());
            statement.setString(5, anggota.getAlamat());
            statement.setInt(6, anggota.getKategoriAnggota().getIdKategoriAnggota());
            statement.setString(7, anggota.getKeterangan());
            statement.executeUpdate();
            connection.commit();
        }catch (SQLException e) {
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
        }
    }

    @Override
    public void Update(Integer id, Anggota anggota) throws Exception {
       PreparedStatement statement;
        statement=null;
        try{
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(update);
            statement.setString(1, anggota.getNomorAnggota());
            statement.setString(2, anggota.getNama());
            statement.setString(3, anggota.getNoIdentitas());
            statement.setString(4, anggota.getJenisIdentitas());
            statement.setString(5, anggota.getAlamat());
            statement.setInt(6, anggota.getKategoriAnggota().getIdKategoriAnggota());
            statement.setString(7, anggota.getKeterangan());
            statement.setInt(8, id);
            statement.executeUpdate();
            connection.commit();
        }catch (SQLException e) {
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
        } 
    }

    @Override
    public void Delete(Integer id) throws Exception {
     PreparedStatement statement;
        statement=null;
        try{
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        }catch (SQLException e) {
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
        }   
    }

    @Override
    public List<Anggota> selectAll() throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        List<Anggota> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selecAll);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Anggota anggota = new Anggota();
                anggota.setIdAnggota(resultSet.getInt("idAnggota"));
                anggota.setNomorAnggota(resultSet.getString("nomorAnggota"));
                anggota.setNama(resultSet.getString("nama"));
                anggota.setNoIdentitas(resultSet.getString("noIdentitas"));
                anggota.setJenisIdentitas(resultSet.getString("jenisIdentitas"));
                anggota.setAlamat(resultSet.getString("alamat"));
                anggota.setKategoriAnggota(new KategoriAnggotaImplemen(connection).getById(resultSet.getInt("idKategotiAnggota")));
                anggota.setKeterangan(resultSet.getString("keterangan"));
                list.add(anggota);
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
    public List<Anggota> getByKategoriAnggotaId(Integer ktgId) throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        List<Anggota> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getKtgAnggotaId);
            statement.setInt(1, ktgId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Anggota anggota = new Anggota();
                anggota.setIdAnggota(resultSet.getInt("idAnggota"));
                anggota.setNomorAnggota(resultSet.getString("nomorAnggota"));
                anggota.setNama(resultSet.getString("nama"));
                anggota.setNoIdentitas(resultSet.getString("noIdentitas"));
                anggota.setJenisIdentitas(resultSet.getString("jenisIdentitas"));
                anggota.setAlamat(resultSet.getString("alamat"));
                anggota.setKategoriAnggota(new KategoriAnggotaImplemen(connection).getById(resultSet.getInt("idKategotiAnggota")));
                anggota.setKeterangan(resultSet.getString("keterangan"));
                list.add(anggota);
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
    public Anggota getById(Integer id) throws Exception {
        Anggota anggota;
        anggota=null;
        PreparedStatement statement;
        ResultSet resultSet;
        statement=null;
        resultSet=null;
        try{
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(getAnggotaId);
            statement.setInt(1, id);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                anggota = new Anggota();
                anggota.setIdAnggota(resultSet.getInt("idAnggota"));
                anggota.setNomorAnggota(resultSet.getString("nomorAnggota"));
                anggota.setNama(resultSet.getString("nama"));
                anggota.setNoIdentitas(resultSet.getString("noIdentitas"));
                anggota.setJenisIdentitas(resultSet.getString("jenisIdentitas"));
                anggota.setAlamat(resultSet.getString("alamat"));
                anggota.setKategoriAnggota(new KategoriAnggotaImplemen(connection).getById(resultSet.getInt("idKategotiAnggota")));
                anggota.setKeterangan(resultSet.getString("keterangan"));
            }
            connection.commit();
            return anggota;
        }catch (SQLException e) {
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
    public List<Anggota> getNamanNomor(String nama, String nomorAnggota) throws Exception {
        Statement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        List<Anggota> list = new ArrayList<>();
        String sql = "SELECT * FROM anggota WHERE nama LIKE '" + nama + "%' AND nomorAnggota LIKE '" + nomorAnggota + "%'";
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Anggota anggota = new Anggota();
                anggota.setIdAnggota(resultSet.getInt("idAnggota"));
                anggota.setNomorAnggota(resultSet.getString("nomorAnggota"));
                anggota.setNama(resultSet.getString("nama"));
                anggota.setNoIdentitas(resultSet.getString("noIdentitas"));
                anggota.setJenisIdentitas(resultSet.getString("jenisIdentitas"));
                anggota.setAlamat(resultSet.getString("alamat"));
                anggota.setKategoriAnggota(new KategoriAnggotaImplemen(connection).getById(resultSet.getInt("idKategotiAnggota")));
                anggota.setKeterangan(resultSet.getString("keterangan"));
                list.add(anggota);
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
    public Anggota getByNomorAnggota(String nomorAnggota) throws Exception {
     Anggota anggota;
        anggota=null;
        PreparedStatement statement;
        ResultSet resultSet;
        statement=null;
        resultSet=null;
        try{
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(getAnggotaId);
            statement.setString(1, nomorAnggota);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                anggota = new Anggota();
                anggota.setIdAnggota(resultSet.getInt("idAnggota"));
                anggota.setNomorAnggota(resultSet.getString("nomorAnggota"));
                anggota.setNama(resultSet.getString("nama"));
                anggota.setNoIdentitas(resultSet.getString("noIdentitas"));
                anggota.setJenisIdentitas(resultSet.getString("jenisIdentitas"));
                anggota.setAlamat(resultSet.getString("alamat"));
                anggota.setKategoriAnggota(new KategoriAnggotaImplemen(connection).getById(resultSet.getInt("idKategotiAnggota")));
                anggota.setKeterangan(resultSet.getString("keterangan"));
            }
            connection.commit();
            return anggota;
        }catch (SQLException e) {
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
}
