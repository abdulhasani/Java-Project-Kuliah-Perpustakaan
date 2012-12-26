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
public class FilterAnggota implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result;
        String katId=request.getParameter("katId");
        result = null;
        List<KategoriAnggota> ktgAnggota = new ArrayList<>();
        List<Anggota> anggotaAll = new ArrayList<>();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if (user != null) {
            result = "DaftarAnggota.jsp";
        }else{
            result="home.jsp";
        }
        try {
            Integer konversi=Integer.parseInt(katId);
            KategoriAnggotaDao kategoriAnggotaDao = DBPerpustakaan.getKategoriAnggotaDao();
            ktgAnggota = kategoriAnggotaDao.selectAll();
            AnggotaDao anggotaDao = DBPerpustakaan.getAnggotaDao();
            anggotaAll=anggotaDao.getByKategoriAnggotaId(konversi);
        } catch (SQLException e) {
        } catch (Exception ex) {
        }
        request.setAttribute("ktgAnggota", ktgAnggota);
        request.setAttribute("anggotaAll", anggotaAll);
        return result;
    }
}
