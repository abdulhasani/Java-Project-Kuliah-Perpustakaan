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
public class SearchAnggota implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result;
        String pesan;
        String nama;
        String nomorAnggota;
        pesan = null;
        result = null;
        nama = request.getParameter("nama");
        nomorAnggota = request.getParameter("nomorAnggota");
        List<KategoriAnggota> ktgAnggota = new ArrayList<>();
        List<Anggota> anggotaAll = new ArrayList<>();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if (user != null) {
            result = "DaftarAnggota.jsp";
            try {
                KategoriAnggotaDao kategoriAnggotaDao = DBPerpustakaan.getKategoriAnggotaDao();
                ktgAnggota = kategoriAnggotaDao.selectAll();
            } catch (SQLException e) {
            } catch (Exception e) {
            }
        } else {
            result = "home.jsp";
        }

        if (!nama.trim().equals("") || !nomorAnggota.trim().equals("")) {

            try {
                AnggotaDao anggotaDao = DBPerpustakaan.getAnggotaDao();
                anggotaAll = anggotaDao.getNamanNomor(nama, nomorAnggota);
                if(anggotaAll.isEmpty()){
                    pesan="ANGGOTA YANG DICARI MUNGKIN BELUM TERDAFTAR";
                }
            } catch (SQLException e) {
            } catch (Exception ex) {
            }
        } else {
            pesan = "Masukan nama anggota";
        }

        request.setAttribute("ktgAnggota", ktgAnggota);
        request.setAttribute("anggotaAll", anggotaAll);
        request.setAttribute("msg", pesan);
        return result;
    }
}
