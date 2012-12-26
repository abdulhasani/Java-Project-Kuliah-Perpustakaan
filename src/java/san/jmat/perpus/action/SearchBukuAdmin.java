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
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.KategoriBuku;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SearchBukuAdmin implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        List<KategoriBuku> ktgBuku;
        ktgBuku = new ArrayList<>();
        List<Buku> buku;
        buku = new ArrayList<>();
        String judulBuku;
        judulBuku = request.getParameter("judulBuku");
        String pengarang;
        pengarang = request.getParameter("pengarang");
        String pesan = null;
        String result;
        result=null;
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");

        if (user != null) {
            result="DaftarBukuAdmin.jsp";
            try {
                KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
                ktgBuku = kategoriBukuDao.selectAll();
            } catch (SQLException e) {
            } catch (Exception e) {
            }
        }
        else{
            result="home.jsp";
        }

        if (judulBuku.trim().equals("") && pengarang.trim().equals("")) {
            pesan = "Masukan judul dan pengarang buku";
        } else if (judulBuku.trim().equals("")) {
            pesan = "Masukan judul buku";
        } else if (pengarang.trim().equals("")) {
            pesan = "Masukan pengarang buku";
        } else {
            try {

                BukuDao bukuDao = DBPerpustakaan.getBukuDao();
                buku = bukuDao.Filter(judulBuku, pengarang, null, null);
                if (buku.isEmpty()) {
                    pesan = "BUKU YANG ANDA CARI TIDAK DITEMUKAN";
                }
            } catch (SQLException e) {
            } catch (Exception e) {
            }
        }
        request.setAttribute("msg", pesan);
        request.setAttribute("categorys", ktgBuku);
        request.setAttribute("bukuAll", buku);
        return result;
    }
}
