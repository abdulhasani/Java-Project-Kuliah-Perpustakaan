
import java.sql.SQLException;
import java.util.List;
import san.jmat.perpus.dao.service.KategoriAnggotaDao;
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.dao.service.PeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KategoriAnggota;
import san.jmat.perpus.entity.KategoriBuku;
import san.jmat.perpus.entity.Peminjaman;

/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
/**
 *
 * @author joker
 */
public class tes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
      PeminjamanDao peminjamanDao=DBPerpustakaan.getPeminjamanDao();
      long tes;
        tes = 1354482113486l;
        Peminjaman byId = peminjamanDao.getById(1354482113486l);
        System.out.println(byId.getNomorAnggota());
    }
}
