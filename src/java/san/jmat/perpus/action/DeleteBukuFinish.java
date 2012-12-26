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
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.dao.service.DetilPeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.DetilPeminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DeleteBukuFinish implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result;
        String pesan;
        String bukuId;
        result = null;
        pesan = null;
        bukuId = request.getParameter("hapus");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");

        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarBukuAdmin";
            try {
                Integer ceking = Integer.parseInt(bukuId);
                
                DetilPeminjamanDao detilPeminjamanDao = DBPerpustakaan.getDetilPeminjamanDao();
                DetilPeminjaman detilPeminjaman = detilPeminjamanDao.getByBukuID(ceking);

                if (detilPeminjaman !=null ) {
                    pesan = "Buku sedang dipinjam tidak bisa dihapus";

                } else {
                    pesan = "Proses delete sukses";
                    BukuDao bukuDao = DBPerpustakaan.getBukuDao();
                    bukuDao.Delete(ceking);

                }
            } catch (SQLException e) {
                pesan=e.getMessage();
            } catch (Exception ex) {
                pesan=ex.getMessage();
            }
        }else{
            result="home.jsp";
        }
        request.setAttribute("msg2", pesan);
        return result;
    }
}
