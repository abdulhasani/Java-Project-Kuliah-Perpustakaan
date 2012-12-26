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
public class FilterBuku implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        Integer katId = Integer.parseInt(request.getParameter("katId"));
        List<KategoriBuku> ktgBuku = new ArrayList<>();
        List<Buku> buku = new ArrayList<>();
        String result;
        result = null;
        try {
            KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
            ktgBuku = kategoriBukuDao.selectAll();
            BukuDao bukuDao = DBPerpustakaan.getBukuDao();
            buku = bukuDao.getByKategoriBukuId(katId);
            HttpSession session=request.getSession(true);
            User user=(User) session.getAttribute("login");
            if(user!=null){
                result="DaftarBukuAdmin.jsp";
            }
            else{
                result="DaftarBuku.jsp";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBukuAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
        }
        request.setAttribute("categorys", ktgBuku);
        request.setAttribute("bukuAll", buku);
        return result;
    }
}
