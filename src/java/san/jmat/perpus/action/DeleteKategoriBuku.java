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
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DeleteKategoriBuku implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result;
        result = null;
        String pesan;
        pesan = null;
        String idKategoriBuku;
        idKategoriBuku = request.getParameter("idKtgBuku");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarKategoriBuku";
            try {
                Integer konIdKategoriBuku = Integer.parseInt(idKategoriBuku);
                KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
                kategoriBukuDao.Delete(konIdKategoriBuku);
                pesan = "Berhasil Menghapus Data";
                
            } catch (SQLException e) {
                
            } catch (Exception ex) {
                
            }
        } else {
            result = "home.jsp";
        }
        request.setAttribute("msg2", pesan);
        return result;
    }
}
