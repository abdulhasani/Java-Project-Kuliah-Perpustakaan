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
import san.jmat.perpus.dao.service.KeUanganPeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.DetilKeUanganPeminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DaftarKeUanganPeminjaman implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        List<DetilKeUanganPeminjaman> selectAll = new ArrayList<>();
        Integer sum=0;
        if (user != null) {
            result = "Daftar KeUangan Peminjaman.jsp";
            try {
                KeUanganPeminjamanDao keUanganPeminjamanDao;
                keUanganPeminjamanDao = DBPerpustakaan.getKeUanganPeminjamanDao();
                selectAll = keUanganPeminjamanDao.selectAll();
                sum = keUanganPeminjamanDao.sum();
            } catch (SQLException ex) {
                Logger.getLogger(DaftarKeUanganPeminjaman.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
            }

        } else {
            result = "home.jsp";
        }
        request.setAttribute("total", sum);
        request.setAttribute("keuanganPmj", selectAll);
        return result;
    }
}
