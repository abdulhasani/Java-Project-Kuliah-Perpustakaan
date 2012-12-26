/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.AnggotaDao;
import san.jmat.perpus.dao.service.KategoriAnggotaDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Anggota;
import san.jmat.perpus.entity.KategoriAnggota;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DaftarAnggota implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        //Deklarasi variabel result
        String result;
        //inisialisasi variabel result
        result = null;
        //Deklarasi variabel dan inisialisasi anggotaAll
        List<Anggota> anggotaAll = new ArrayList<>();
        //Deklarasi variabel dan inisialisasi ktgAnggota
        List<KategoriAnggota> ktgAnggota = new ArrayList<>();
        //Tangkap session 
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        //jika user tidak sama dengan null baca if
        if (user != null) {
            result = "DaftarAnggota.jsp";
        }
        //jika syarat if tak terpenuhi
        else{
            result="home.jsp";
        }
        
        try {
            //Untuk menapilkan dafatar anggota dan kategorinya initinya ada disini
            //Gunakan konsep Polimorphysme
            
            KategoriAnggotaDao kategoriAnggotaDao = DBPerpustakaan.getKategoriAnggotaDao();
            //panggil method selectAll pada interface kategoriAnggotaDao
            //dimana method selectAll di override di Kelas KategoriAnggotaImplemen
            ktgAnggota = kategoriAnggotaDao.selectAll();
            //panggil method selectAll pada interface AnggotaDao
            //dimana method selectAll di override di Kelas AnggotaImplemen
            AnggotaDao anggotaDao = DBPerpustakaan.getAnggotaDao();
            anggotaAll = anggotaDao.selectAll();

        } catch (SQLException ex) {
            Logger.getLogger(DaftarAnggota.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
        }
        //set attribut Kategori Anggota
        request.setAttribute("ktgAnggota", ktgAnggota);
        //set attribut Anggota
        request.setAttribute("anggotaAll", anggotaAll);

        return result;
    }
}
