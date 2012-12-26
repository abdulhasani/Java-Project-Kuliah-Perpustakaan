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
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.entity.Buku;

/**
 *
 * @author joker
 */
public class BukuImplemen implements BukuDao {

    private Connection connection;
    private final String selectAll = "SELECT * FROM buku";
    private final String getByKategori = "SELECT * FROM buku WHERE idKategoriBuku=? ";
    private final String getById = "SELECT * FROM buku WHERE idBuku=?";
    private final String insert = "INSERT INTO buku (judul,pengarang,penerbit,tahunTerbit,idKategoriBuku,sinopsis,jumlahStok,jumlahTersedia,keterangan) VALUES(?,?,?,?,?,?,?,?,?)";
    private final String update = "UPDATE buku SET judul=?,pengarang=?,penerbit=?,tahunTerbit=?,idKategoriBuku=?,sinopsis=?,jumlahStok=?,jumlahTersedia=?,keterangan=? WHERE idBuku=? ";
    private final String delete = "DELETE FROM buku WHERE idBuku=?";
    
    public BukuImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert(Buku buku) throws Exception {
        PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insert);
            statement.setString(1, buku.getJudul());
            statement.setString(2, buku.getPengarang());
            statement.setString(3, buku.getPenerbit());
            statement.setString(4, buku.getTahunTerbit());
            statement.setInt(5, buku.getKategoriBuku().getIdKategoriBuku());
            statement.setString(6, buku.getSinopsis());
            statement.setInt(7, buku.getJumlahStok());
            statement.setInt(8, buku.getJumlahTersedia());
            statement.setString(9, buku.getKeterangan());
            statement.executeUpdate();
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
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void Update(Integer id, Buku buku) throws Exception {
        PreparedStatement statement;
        statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(update);
            statement.setString(1, buku.getJudul());
            statement.setString(2, buku.getPengarang());
            statement.setString(3, buku.getPenerbit());
            statement.setString(4, buku.getTahunTerbit());
            statement.setInt(5, buku.getKategoriBuku().getIdKategoriBuku());
            statement.setString(6, buku.getSinopsis());
            statement.setInt(7, buku.getJumlahStok());
            statement.setInt(8, buku.getJumlahTersedia());
            statement.setString(9, buku.getKeterangan());
            statement.setInt(10, id);
            statement.executeUpdate();
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
            statement = connection.prepareStatement(delete);
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
    public List<Buku> selectAll() throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        List<Buku> list = new ArrayList<>();
        statement = null;
        resultSet = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectAll);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Buku buku = new Buku();
                buku.setIdBuku(resultSet.getInt("idBuku"));
                buku.setJudul(resultSet.getString("judul"));
                buku.setPengarang(resultSet.getString("pengarang"));
                buku.setPenerbit(resultSet.getString("penerbit"));
                buku.setTahunTerbit(resultSet.getString("tahunTerbit"));
                buku.setKategoriBuku(new KategoriBukuImplemen(connection).getById(resultSet.getInt("idKategoriBuku")));
                buku.setSinopsis(resultSet.getString("sinopsis"));
                buku.setJumlahStok(resultSet.getInt("jumlahStok"));
                buku.setJumlahTersedia(resultSet.getInt("jumlahTersedia"));
                buku.setKeterangan(resultSet.getString("keterangan"));

                list.add(buku);
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
    public List<Buku> getByKategoriBukuId(Integer katId) throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        List<Buku> list = new ArrayList<>();
        statement = null;
        resultSet = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByKategori);
            statement.setInt(1, katId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Buku buku = new Buku();
                buku.setIdBuku(resultSet.getInt("idBuku"));
                buku.setJudul(resultSet.getString("judul"));
                buku.setPengarang(resultSet.getString("pengarang"));
                buku.setPenerbit(resultSet.getString("penerbit"));
                buku.setTahunTerbit(resultSet.getString("tahunTerbit"));
                buku.setKategoriBuku(new KategoriBukuImplemen(connection).getById(resultSet.getInt("idKategoriBuku")));
                buku.setSinopsis(resultSet.getString("sinopsis"));
                buku.setJumlahStok(resultSet.getInt("jumlahStok"));
                buku.setJumlahTersedia(resultSet.getInt("jumlahTersedia"));
                buku.setKeterangan(resultSet.getString("keterangan"));

                list.add(buku);
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
    public Buku getById(Integer id) throws Exception {
        Buku buku;
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        buku = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                buku = new Buku();
                buku.setIdBuku(resultSet.getInt("idBuku"));
                buku.setJudul(resultSet.getString("judul"));
                buku.setPengarang(resultSet.getString("pengarang"));
                buku.setPenerbit(resultSet.getString("penerbit"));
                buku.setTahunTerbit(resultSet.getString("tahunTerbit"));
                buku.setKategoriBuku(new KategoriBukuImplemen(connection).getById(resultSet.getInt("idKategoriBuku")));
                buku.setSinopsis(resultSet.getString("sinopsis"));
                buku.setJumlahStok(resultSet.getInt("jumlahStok"));
                buku.setJumlahTersedia(resultSet.getInt("jumlahTersedia"));
                buku.setKeterangan(resultSet.getString("keterangan"));
            }
            connection.commit();
            return buku;
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
    public List<Buku> Filter(String judul, String pengarang, String penerbit, String tahunTerbit) throws Exception {
        String filter = "SELECT * FROM buku WHERE judul LIKE '" + judul + "%' "
                + "AND pengarang LIKE '" + pengarang + "%' OR penerbit='" + penerbit + "' "
                + "OR tahunTerbit='" + tahunTerbit + "'";
        Statement statement;
        ResultSet resultSet;
        List<Buku> list = new ArrayList<>();
        statement = null;
        resultSet = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(filter);
            while (resultSet.next()) {
                Buku buku = new Buku();
                buku.setIdBuku(resultSet.getInt("idBuku"));
                buku.setJudul(resultSet.getString("judul"));
                buku.setPengarang(resultSet.getString("pengarang"));
                buku.setPenerbit(resultSet.getString("penerbit"));
                buku.setTahunTerbit(resultSet.getString("tahunTerbit"));
                buku.setKategoriBuku(new KategoriBukuImplemen(connection).getById(resultSet.getInt("idKategoriBuku")));
                buku.setSinopsis(resultSet.getString("sinopsis"));
                buku.setJumlahStok(resultSet.getInt("jumlahStok"));
                buku.setJumlahTersedia(resultSet.getInt("jumlahTersedia"));
                buku.setKeterangan(resultSet.getString("keterangan"));

                list.add(buku);
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
    public List<Buku> getJudulorId(String judul, String id) throws Exception {
        Statement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        List<Buku> bukus = new ArrayList<>();
        String getJudulorId = "SELECT * FROM buku WHERE judul like '" + judul + "%' OR idBuku like '" + id + "%'";
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getJudulorId);
            while (resultSet.next()) {
                Buku buku = new Buku();
                buku.setIdBuku(resultSet.getInt("idBuku"));
                buku.setJudul(resultSet.getString("judul"));
                buku.setPengarang(resultSet.getString("pengarang"));
                buku.setPenerbit(resultSet.getString("penerbit"));
                buku.setTahunTerbit(resultSet.getString("tahunTerbit"));
                buku.setKategoriBuku(new KategoriBukuImplemen(connection).getById(resultSet.getInt("idKategoriBuku")));
                buku.setSinopsis(resultSet.getString("sinopsis"));
                buku.setJumlahStok(resultSet.getInt("jumlahStok"));
                buku.setJumlahTersedia(resultSet.getInt("jumlahTersedia"));
                buku.setKeterangan(resultSet.getString("keterangan"));
                
                bukus.add(buku);
            }
            connection.commit();
            return bukus;
        } catch (SQLException ex) {
             try {
                connection.rollback();
            } catch (SQLException e) {
            }
            throw new Exception(ex.getMessage());
        }finally {
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
