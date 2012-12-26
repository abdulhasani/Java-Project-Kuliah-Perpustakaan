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
import java.util.Date;
import java.util.List;
import san.jmat.perpus.dao.service.PengembalianDao;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.Pengembalian;

/**
 *
 * @author joker
 */
public class PengembalianImplemen implements PengembalianDao {

    private final String updateAnggota = "UPDATE anggota SET keterangan=? WHERE nomorAnggota=?";
    private final String getdetilPeminjamanId = "SELECT bukuId FROM detilPeminjaman WHERE peminjamanId=?";
    private final String INSERT1 = "INSERT INTO pengembalian (id,nomorAnggota,judulBuku,ketentuanTglKembali,tanggalKembali) VALUES (?,?,?,?,?)";
    private final String select = "SELECT * FROM pengembalian";
    private Connection connection;
    private final String deleteAll = "DELETE FROM pengembalian";
    private final String delete = "DELETE FROM pengembalian WHERE id=?";

    public PengembalianImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert(Pengembalian pengembalian, String nomorAnggota) throws Exception {
        PreparedStatement statement1;
        PreparedStatement statement2;
        PreparedStatement statement3;
        ResultSet resultSet1;
        statement1 = null;
        statement2 = null;
        statement3 = null;
        resultSet1 = null;
        String keterangan = "Free";
        Integer id = null;
        try {
            connection.setAutoCommit(false);
            //Update keterangan anggota
            statement1 = connection.prepareStatement(updateAnggota);
            statement1.setString(1, keterangan);
            statement1.setString(2, nomorAnggota);
            statement1.executeUpdate();


            for (Peminjaman peminjaman : pengembalian.getPeminjamans()) {
                //SELECT DetilPeminjaman Berdasar ID peminjam
                statement2 = connection.prepareStatement(getdetilPeminjamanId);
                statement2.setLong(1, peminjaman.getIdPeminjaman());
                resultSet1 = statement2.executeQuery();
                if (resultSet1.next()) {
                    id = resultSet1.getInt("bukuId");
                }
                //SELECT BUKU berdasar ID
                BukuImplemen bukuImplemen = new BukuImplemen(connection);
                Buku byId = bukuImplemen.getById(id);
                Integer jumlahTersedia = byId.getJumlahTersedia() + 1;
                byId.setJumlahTersedia(jumlahTersedia);
                //update buku
                bukuImplemen.Update(id, byId);

                //INSERT Pengembalian 
                Long time = System.currentTimeMillis();
                statement3 = connection.prepareStatement(INSERT1);
                statement3.setLong(1, time);
                statement3.setString(2, peminjaman.getNomorAnggota());
                statement3.setString(3, peminjaman.getJudulBuku());
                statement3.setDate(4, new java.sql.Date(peminjaman.getTanggalHarusKembali().getTime()));
                statement3.setDate(5, new java.sql.Date(pengembalian.getTglKembali().getTime()));
                statement3.executeUpdate();
            }
            //Delete DaftarPeminjaman
            PeminjamanImplemen peminjamanImplemen = new PeminjamanImplemen(connection);
            peminjamanImplemen.Delete2(nomorAnggota);
            connection.commit();
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
            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException ex) {
                }
            }
            if (statement2 != null) {
                try {
                    statement2.close();
                } catch (SQLException ex) {
                }
            }
            if (statement3 != null) {
                try {
                    statement3.close();
                } catch (SQLException ex) {
                }
            }
            if (resultSet1 != null) {
                try {
                    resultSet1.close();
                } catch (SQLException ex) {
                }
            }
        }

    }

    @Override
    public List<Pengembalian> selectAll() throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        List<Pengembalian> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(select);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pengembalian pengembalian = new Pengembalian();
                pengembalian.setId(resultSet.getLong("id"));
                pengembalian.setNomorAnggota(resultSet.getString("nomorAnggota"));
                pengembalian.setJudulBuku(resultSet.getString("judulBuku"));
                pengembalian.setKetentuanTglKembali(resultSet.getDate("ketentuanTglKembali"));
                pengembalian.setTglKembali(resultSet.getDate("tanggalKembali"));
                list.add(pengembalian);
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
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void Insert2(Pengembalian pengembalian, Long idPeminjam) throws Exception {
        PreparedStatement statement1;
        PreparedStatement statement2;
        PreparedStatement statement3;
        ResultSet resultSet1;
        statement1 = null;
        statement2 = null;
        statement3 = null;
        resultSet1 = null;
        String keterangan = "Free";
        Integer id = null;
        try {
            connection.setAutoCommit(false);

            for (Peminjaman peminjaman : pengembalian.getPeminjamans()) {
                //SELECT DetilPeminjaman Berdasar ID peminjam
                statement2 = connection.prepareStatement(getdetilPeminjamanId);
                statement2.setLong(1, peminjaman.getIdPeminjaman());
                resultSet1 = statement2.executeQuery();
                if (resultSet1.next()) {
                    id = resultSet1.getInt("bukuId");
                }
                //SELECT BUKU berdasar ID
                BukuImplemen bukuImplemen = new BukuImplemen(connection);
                Buku byId = bukuImplemen.getById(id);
                Integer jumlahTersedia = byId.getJumlahTersedia() + 1;
                byId.setJumlahTersedia(jumlahTersedia);
                //update buku
                bukuImplemen.Update(id, byId);

                //INSERT Pengembalian 
                Long time = System.currentTimeMillis();
                statement3 = connection.prepareStatement(INSERT1);
                statement3.setLong(1, time);
                statement3.setString(2, peminjaman.getNomorAnggota());
                statement3.setString(3, peminjaman.getJudulBuku());
                statement3.setDate(4, new java.sql.Date(peminjaman.getTanggalHarusKembali().getTime()));
                statement3.setDate(5, new java.sql.Date(pengembalian.getTglKembali().getTime()));
                statement3.executeUpdate();
            }
            //Delete DaftarPeminjaman
            PeminjamanImplemen peminjamanImplemen = new PeminjamanImplemen(connection);
            peminjamanImplemen.Delete2(idPeminjam);
            //Select apakah nomor anggota tersebut masih meminjam buku
            List<Peminjaman> byNomorAnggota = peminjamanImplemen.getByNomorAnggota(pengembalian.getNomorAnggota());
            if (byNomorAnggota.isEmpty()) {
                //Update keterangan anggota
                statement1 = connection.prepareStatement(updateAnggota);
                statement1.setString(1, keterangan);
                statement1.setString(2, pengembalian.getNomorAnggota());
                statement1.executeUpdate();
            }
            connection.commit();
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
            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException ex) {
                }
            }
            if (statement2 != null) {
                try {
                    statement2.close();
                } catch (SQLException ex) {
                }
            }
            if (statement3 != null) {
                try {
                    statement3.close();
                } catch (SQLException ex) {
                }
            }
            if (resultSet1 != null) {
                try {
                    resultSet1.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public void deleteAll() throws Exception {
        PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteAll);
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
    public void delete(Long id) throws Exception {
        PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(delete);
            statement.setLong(1, id);
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
    public List<Pengembalian> filter(String filter) throws Exception {
        String sql="SELECT * FROM pengembalian WHERE  judulBuku LIKE '"+filter+"%' OR nomorAnggota='"+filter+"'";
        Statement statement;
        ResultSet resultSet;
        resultSet = null;
        statement = null;
        List<Pengembalian> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
             Pengembalian pengembalian = new Pengembalian();
                pengembalian.setId(resultSet.getLong("id"));
                pengembalian.setNomorAnggota(resultSet.getString("nomorAnggota"));
                pengembalian.setJudulBuku(resultSet.getString("judulBuku"));
                pengembalian.setKetentuanTglKembali(resultSet.getDate("ketentuanTglKembali"));
                pengembalian.setTglKembali(resultSet.getDate("tanggalKembali"));
                list.add(pengembalian);
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
                } catch (SQLException e) {
                }
            }
        }
    }
}
