/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class PeminjamanBuku implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd");
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String result = null;
        String tanggal = null;
        String bulan = null;
        String tahun = null;
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        List<Buku> selectAll = new ArrayList<>();
        if (user != null) {
            result = "PeminjamanBuku.jsp";
            try {
                BukuDao bukuDao = DBPerpustakaan.getBukuDao();
                selectAll = bukuDao.selectAll();
                tanggal = format1.format(date);
                bulan = format2.format(date);
                tahun = format3.format(date);
            } catch (SQLException e) {
            } catch (Exception ex) {
            }
        } else {
            result = "home.jsp";
        }
        session.setAttribute("tgl", tanggal);
        session.setAttribute("bln", bulan);
        session.setAttribute("thn", tahun);
        request.setAttribute("buku", selectAll);
        return result;
    }
}
