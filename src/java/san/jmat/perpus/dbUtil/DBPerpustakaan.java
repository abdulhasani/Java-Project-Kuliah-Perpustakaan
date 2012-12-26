/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dbUtil;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import san.jmat.perpus.dao.service.AnggotaDao;
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.dao.service.DetilPeminjamanDao;
import san.jmat.perpus.dao.service.KategoriAnggotaDao;
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.dao.service.KeUanganPeminjamanDao;
import san.jmat.perpus.dao.service.KeUanganPendendaanDao;
import san.jmat.perpus.dao.service.PeminjamanDao;
import san.jmat.perpus.dao.service.PengembalianDao;
import san.jmat.perpus.dao.service.UserDao;
import san.jmat.perpus.dao.service.imple.AnggotaImplemen;
import san.jmat.perpus.dao.service.imple.BukuImplemen;
import san.jmat.perpus.dao.service.imple.DetilPeminjamanImplemen;
import san.jmat.perpus.dao.service.imple.KategoriAnggotaImplemen;
import san.jmat.perpus.dao.service.imple.KategoriBukuImplemen;
import san.jmat.perpus.dao.service.imple.KeUanganPeminjamanImpl;
import san.jmat.perpus.dao.service.imple.KeUanganPendendaanImpl;
import san.jmat.perpus.dao.service.imple.PeminjamanImplemen;
import san.jmat.perpus.dao.service.imple.PengembalianImplemen;
import san.jmat.perpus.dao.service.imple.UserImplemen;
import san.jmat.perpus.dao.service.imple.rengkingBukuImplemen;
import san.jmat.perpus.dao.service.imple.rengkingPeminjamImplemen;
import san.jmat.perpus.dao.service.rengkingBukuDao;
import san.jmat.perpus.dao.service.rengkingPeminjamanDao;

/**
 *
 * @author joker
 */
public class DBPerpustakaan {

    private static Connection connection;
    private static UserDao userDao;
    private static KategoriAnggotaDao kategoriAnggotaDao;
    private static KategoriBukuDao kategoriBukuDao;
    private static AnggotaDao anggotaDao;
    private static BukuDao bukuDao;
    private static PeminjamanDao peminjamanDao;
    private static DetilPeminjamanDao detilPeminjamanDao;
    private static PengembalianDao pengembalianDao;
    private static KeUanganPeminjamanDao keUanganPeminjamanDao;
    private static KeUanganPendendaanDao keUanganPendendaanDao;
    private static rengkingBukuDao rengBukuDao;
    private static rengkingPeminjamanDao rengPeminjamanDao;

    public DBPerpustakaan() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/perpustakaan");
            dataSource.setUser("sani");
            dataSource.setPassword("123");

            connection = dataSource.getConnection();
        }
        return connection;
    }

    public static UserDao getUserDao() throws SQLException {
        if (userDao == null) {
            userDao = new UserImplemen(getConnection());
        }
        return userDao;
    }

    public static KategoriAnggotaDao getKategoriAnggotaDao() throws SQLException {
        if (kategoriAnggotaDao == null) {
            kategoriAnggotaDao = new KategoriAnggotaImplemen(getConnection());
        }
        return kategoriAnggotaDao;
    }

    public static KategoriBukuDao getKategoriBukuDao() throws SQLException {
        if (kategoriBukuDao == null) {
            kategoriBukuDao = new KategoriBukuImplemen(getConnection());
        }
        return kategoriBukuDao;
    }

    public static AnggotaDao getAnggotaDao() throws SQLException {
        if (anggotaDao == null) {
            anggotaDao = new AnggotaImplemen(getConnection());
        }
        return anggotaDao;
    }

    public static BukuDao getBukuDao() throws SQLException {
        if (bukuDao == null) {
            bukuDao = new BukuImplemen(getConnection());
        }
        return bukuDao;
    }

    public static PeminjamanDao getPeminjamanDao() throws SQLException {
        if (peminjamanDao == null) {
            peminjamanDao = new PeminjamanImplemen(getConnection());
        }
        return peminjamanDao;
    }

    public static DetilPeminjamanDao getDetilPeminjamanDao() throws SQLException {
        if (detilPeminjamanDao == null) {
            detilPeminjamanDao = new DetilPeminjamanImplemen(getConnection());
        }
        return detilPeminjamanDao;
    }

    public static PengembalianDao getPengembalianDao() throws SQLException {
        if (pengembalianDao == null) {
            pengembalianDao = new PengembalianImplemen(getConnection());
        }
        return pengembalianDao;
    }

    public static KeUanganPeminjamanDao getKeUanganPeminjamanDao() throws SQLException {
        if (keUanganPeminjamanDao == null) {
            keUanganPeminjamanDao = new KeUanganPeminjamanImpl(getConnection());
        }
        return keUanganPeminjamanDao;
    }

    public static KeUanganPendendaanDao getKeUanganPendendaanDao() throws SQLException {
        if (keUanganPendendaanDao == null) {
            keUanganPendendaanDao = new KeUanganPendendaanImpl(getConnection());
        }
        return keUanganPendendaanDao;
    }

    public static rengkingBukuDao getRengBukuDao() throws SQLException {
        if (rengBukuDao == null) {
            rengBukuDao = new rengkingBukuImplemen(getConnection());
        }
        return rengBukuDao;
    }

    public static rengkingPeminjamanDao getRengPeminjamanDao() throws SQLException {
        if (rengPeminjamanDao == null) {
            rengPeminjamanDao = new rengkingPeminjamImplemen(getConnection());
        }
        return rengPeminjamanDao;
    }
    
    
}
