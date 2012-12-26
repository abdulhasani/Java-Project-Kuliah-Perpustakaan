/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KategoriBuku;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SimpanKategoriBukuFinish implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result;
        String pesan;
        pesan = null;
        result = null;
        String nama;
        String keterangan;
        nama = request.getParameter("nama");
        keterangan = request.getParameter("keterangan");
        String idKategoriBuku;
        idKategoriBuku = request.getParameter("katBukuId");
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarKategoriBuku";
        } else {
            result = "home.jsp";
        }

        //insert
        if (idKategoriBuku.equals("")) {
            if (!nama.trim().equals("") && !keterangan.trim().equals("")) {
                try {
                    pesan = "Berhasil Menambahkan Kategori Buku";
                    KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
                    KategoriBuku kategoriBuku = new KategoriBuku();
                    kategoriBuku.setNama(nama);
                    kategoriBuku.setKeterangan(keterangan);
                    kategoriBukuDao.Insert(kategoriBuku);
                } catch (SQLException e) {
                    pesan = e.getMessage();
                } catch (Exception ex) {
                    pesan = ex.getMessage();
                }
            } else {
                result = "CrudKategoriBuku.jsp";
                pesan = "Harap Input Data";
            }
        } //update
        else {
            if (!nama.trim().equals("") && !keterangan.trim().equals("")) {
                try {
                    Integer konIdKatBuku = Integer.parseInt(idKategoriBuku);
                    KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
                    KategoriBuku kategoriBuku = new KategoriBuku();
                    kategoriBuku.setNama(nama);
                    kategoriBuku.setKeterangan(keterangan);
                    kategoriBukuDao.Update(konIdKatBuku, kategoriBuku);
                    pesan = "Berhasil Mengedit";
                } catch (SQLException e) {
                    pesan = e.getMessage();
                } catch (Exception ex) {
                    pesan = ex.getMessage();
                }
            } else {
                pesan = "Gagal Mengedit,Harap Input Semua Data";
            }
        }
        request.setAttribute("msg2", pesan);
        return result;
    }
}
