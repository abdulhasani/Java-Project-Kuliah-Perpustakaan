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
import san.jmat.perpus.dao.service.KategoriAnggotaDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KategoriAnggota;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SimpanKategoriAnggotaFinish implements ActionInterface {

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
        String idKategoriAnggota;
        idKategoriAnggota = request.getParameter("katAnggotaId");
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarKategoriAnggota";
        } else {
            result = "home.jsp";
        }

        //insert
        if (idKategoriAnggota.equals("")) {
            if (!nama.trim().equals("") && !keterangan.trim().equals("")) {
                try {
                    pesan = "Berhasil Menambahkan Kategori Anggota";
                    KategoriAnggotaDao kategoriAnggotaDao = DBPerpustakaan.getKategoriAnggotaDao();
                    KategoriAnggota kategoriAnggota = new KategoriAnggota();
                    kategoriAnggota.setNama(nama);
                    kategoriAnggota.setKeterangan(keterangan);
                    kategoriAnggotaDao.Insert(kategoriAnggota);
                } catch (SQLException e) {
                    pesan = e.getMessage();
                } catch (Exception ex) {
                    pesan = ex.getMessage();
                }
            } else {
                result = "CrudKategoriAnggota.jsp";
                pesan = "Harap Input Data";
            }
        } //update
        else {
            if (!nama.trim().equals("") && !keterangan.trim().equals("")) {
                try {
                    Integer konIdKatAnggota = Integer.parseInt(idKategoriAnggota);
                    KategoriAnggotaDao kategoriAnggotaDao = DBPerpustakaan.getKategoriAnggotaDao();
                    KategoriAnggota kategoriAnggota = new KategoriAnggota();
                    kategoriAnggota.setNama(nama);
                    kategoriAnggota.setKeterangan(keterangan);
                    kategoriAnggotaDao.Update(konIdKatAnggota, kategoriAnggota);
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
