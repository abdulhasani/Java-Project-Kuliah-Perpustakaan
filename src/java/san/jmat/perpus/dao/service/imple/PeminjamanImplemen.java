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
import san.jmat.perpus.dao.service.PeminjamanDao;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.DetilPeminjaman;
import san.jmat.perpus.entity.Peminjaman;

/**
 *
 * @author joker
 */
public class PeminjamanImplemen implements PeminjamanDao {

    private Connection connection;
    private final String getById = "SELECT * FROM peminjaman WHERE idPeminjaman=?";
    private final String getByNomor = "SELECT * FROM peminjaman WHERE nomorAnggota=?";
    private final String joinTable = "SELECT peminjaman.idPeminjaman,peminjaman.nomorAnggota,peminjaman.tglPinjam,peminjaman.tglHarusKembali,buku.judul,detilPeminjaman.status FROM peminjaman,detilPeminjaman,buku WHERE peminjaman.idPeminjaman=detilPeminjaman.peminjamanId AND detilPeminjaman.bukuId=buku.idBuku ";
     private final String getById2 = "SELECT peminjaman.idPeminjaman,peminjaman.nomorAnggota,peminjaman.tglPinjam,peminjaman.tglHarusKembali,buku.judul,detilPeminjaman.status FROM peminjaman,detilPeminjaman,buku WHERE peminjaman.idPeminjaman=detilPeminjaman.peminjamanId AND detilPeminjaman.bukuId=buku.idBuku AND peminjaman.idPeminjaman=?";
    private final String jmlhBukuDipinjam = "SELECT COUNT(idPeminjaman) as total FROM peminjaman ";
    private final String delete="DELETE FROM peminjaman WHERE idPeminjaman=? ";
    private final String delete2="DELETE FROM peminjaman WHERE nomorAnggota=? ";
    //Proses Peminjaman
    private final String insert1 = "INSERT INTO peminjaman (idPeminjaman,tglPinjam,tglHarusKembali,nomorAnggota,keterangan) VALUES(?,?,?,?,?) ";
    private final String insert2 = "INSERT INTO detilPeminjaman (peminjamanId,bukuId,status) VALUES(?,?,?)";
    private final String updateAnggota = "UPDATE anggota SET keterangan=? WHERE nomorAnggota=?";
    private final String selectBuku = "SELECT * FROM buku WHERE idBuku=?";
    
    public PeminjamanImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void Insert(Peminjaman peminjaman,String nomorAnggota) throws Exception {
        
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        
        //select jumlah tersedia
        PreparedStatement statement3=null;
        
        PreparedStatement statement5 = null;
        ResultSet resultSet=null;
        
        String keteranganAnggota="Meminjam Buku";
        
        Integer jumlahTersedia = null;
        
        try {
            
            connection.setAutoCommit(false);
            statement2=connection.prepareStatement(updateAnggota);
            statement2.setString(1, keteranganAnggota);
            statement2.setString(2, nomorAnggota);
            statement2.executeUpdate();
            
            BukuImplemen bukuImplemen=new BukuImplemen(connection);
            for (DetilPeminjaman detilPeminjaman : peminjaman.getDetilPeminjamans()) {
                long idPeminjam = System.currentTimeMillis();
                Buku byId = bukuImplemen.getById(detilPeminjaman.getBukuId().getIdBuku());
                jumlahTersedia=byId.getJumlahTersedia()-1;
                byId.setJumlahTersedia(jumlahTersedia);
                bukuImplemen.Update(detilPeminjaman.getBukuId().getIdBuku(), byId);
                
                
               
                //Insert peminjaman
                statement1 = connection.prepareStatement(insert1);
                statement1.setLong(1, idPeminjam);
                statement1.setDate(2, new java.sql.Date(peminjaman.getTanggalPinjam().getTime()));
                statement1.setDate(3, new java.sql.Date(peminjaman.getTanggalHarusKembali().getTime()));
                statement1.setString(4, peminjaman.getNomorAnggota());
                statement1.setString(5, peminjaman.getKeterangan());
                statement1.executeUpdate();

                //Insert DetilPeminjaman
                statement = connection.prepareStatement(insert2);
                statement.setLong(1, idPeminjam);
                statement.setInt(2, detilPeminjaman.getBukuId().getIdBuku());
                statement.setString(3, detilPeminjaman.getStatus());
                statement.executeUpdate();
                
                
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
            } catch (Exception e) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                }
            }
            if(statement2!=null){
                try{
                    statement2.close();
                }catch(Exception e){
                    
                }
            }
             if(statement3!=null){
                try{
                    statement3.close();
                }catch(Exception e){
                    
                }
            }
           
             if(resultSet!=null){
                try{
                    resultSet.close();
                }catch(Exception e){
                    
                }
            }
        }

    }

    @Override
    public void Update(Integer id, Peminjaman peminjaman) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public List<Peminjaman>filter(String filter) throws Exception {
        String sql="SELECT peminjaman.idPeminjaman,peminjaman.nomorAnggota,peminjaman.tglPinjam,peminjaman.tglHarusKembali,buku.judul,detilPeminjaman.status FROM peminjaman,detilPeminjaman,buku WHERE peminjaman.idPeminjaman=detilPeminjaman.peminjamanId AND detilPeminjaman.bukuId=buku.idBuku AND (peminjaman.nomorAnggota='"+filter+"' OR peminjaman.tglPinjam='"+filter+"' OR peminjaman.tglHarusKembali='"+filter+"' OR buku.judul  LIKE '"+filter+"%')";
        Statement statement;
        statement = null;
        ResultSet resultSet;
        resultSet = null;
        Peminjaman peminjaman;
        List<Peminjaman> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(resultSet.getLong("idPeminjaman"));
                peminjaman.setNomorAnggota(resultSet.getString("nomorAnggota"));
                peminjaman.setTanggalPinjam(resultSet.getDate("tglPinjam"));
                peminjaman.setTanggalHarusKembali(resultSet.getDate("tglHarusKembali"));
                peminjaman.setJudulBuku(resultSet.getString("judul"));
                peminjaman.setStatus(resultSet.getString("status"));
                list.add(peminjaman);
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
    public Peminjaman getById(Long id) throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        Peminjaman peminjaman = null;
        
        try {

            statement = connection.prepareStatement(getById);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(resultSet.getLong("idPeminjaman"));
                peminjaman.setTanggalPinjam(resultSet.getDate("tglPinjam"));
                peminjaman.setTanggalHarusKembali(resultSet.getDate("tglHarusKembali"));
                peminjaman.setNomorAnggota(resultSet.getString("nomorAnggota"));
                peminjaman.setKeterangan(resultSet.getString("keterangan"));
                
            }
            return peminjaman;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
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

    @Override
    public List<Peminjaman> getByNomorAnggota(String nomorAnggota) throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        List<Peminjaman> list = new ArrayList<>();
        try {

            statement = connection.prepareStatement(getByNomor);
            statement.setString(1, nomorAnggota);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(resultSet.getLong("idPeminjaman"));
                peminjaman.setTanggalPinjam(resultSet.getDate("tglPinjam"));
                peminjaman.setTanggalHarusKembali(resultSet.getDate("tglHarusKembali"));
                peminjaman.setNomorAnggota(resultSet.getString("nomorAnggota"));
                peminjaman.setKeterangan(resultSet.getString("keterangan"));
                list.add(peminjaman);
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
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

    

    @Override
    public List<Peminjaman> joinTable() throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        Peminjaman peminjaman;
        List<Peminjaman> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(joinTable);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(resultSet.getLong("idPeminjaman"));
                peminjaman.setNomorAnggota(resultSet.getString("nomorAnggota"));
                peminjaman.setTanggalPinjam(resultSet.getDate("tglPinjam"));
                peminjaman.setTanggalHarusKembali(resultSet.getDate("tglHarusKembali"));
                peminjaman.setJudulBuku(resultSet.getString("judul"));
                peminjaman.setStatus(resultSet.getString("status"));
                list.add(peminjaman);
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
    public Long bukuDipinjam() throws Exception {
        Long jumlah = null;
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(jmlhBukuDipinjam);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                jumlah = resultSet.getLong("total");
            }
            connection.commit();
            return jumlah;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new Exception();
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
    public void Delete2(String nomorAnggota) throws Exception {
        PreparedStatement statement;
        statement=null;
        try{
            statement=connection.prepareStatement(delete2);
            statement.setString(1, nomorAnggota);
            statement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            if(statement!=null){
            try{
                statement.close();
            }catch(SQLException ex){
                
            }
            }
        }
    }

    @Override
    public Peminjaman getById2(Long id) throws Exception {
        PreparedStatement statement;
        ResultSet resultSet;
        statement = null;
        resultSet = null;
        Peminjaman peminjaman = null;
        
        try {

            statement = connection.prepareStatement(getById2);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(resultSet.getLong("idPeminjaman"));
                peminjaman.setNomorAnggota(resultSet.getString("nomorAnggota"));
                peminjaman.setTanggalPinjam(resultSet.getDate("tglPinjam"));
                peminjaman.setTanggalHarusKembali(resultSet.getDate("tglHarusKembali"));
                peminjaman.setJudulBuku(resultSet.getString("judul"));
                peminjaman.setStatus(resultSet.getString("status"));
                
            }
            return peminjaman;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
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

    @Override
    public void Delete2(Long idPeminjam) throws Exception {
    PreparedStatement statement;
        statement=null;
        try{
            statement=connection.prepareStatement(delete);
            statement.setLong(1, idPeminjam);
            statement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            if(statement!=null){
            try{
                statement.close();
            }catch(SQLException ex){
                
            }
            }
        }    
    }

    

}
