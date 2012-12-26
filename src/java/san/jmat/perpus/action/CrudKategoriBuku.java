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
public class CrudKategoriBuku implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String pesan=null;
        String result=null;
        String idKategoriBuku=request.getParameter("idKtgBuku");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        KategoriBuku kategoriBuku = null;
        if (user != null) {
            result="CrudKategoriBuku.jsp";
            if(!idKategoriBuku.equals("")){
                try{
                    Integer konIdKatBuku=Integer.parseInt(idKategoriBuku);
                KategoriBukuDao kategoriBukuDao=DBPerpustakaan.getKategoriBukuDao();
                    kategoriBuku = kategoriBukuDao.getById(konIdKatBuku);
                }catch(SQLException e){
                    pesan=e.getMessage();
                    result="DaftarKategoriBuku.jsp";
                }catch(Exception ex){
                    pesan=ex.getMessage();
                    result="DaftarKategoriBuku.jsp";
                }
            }
        } else {
            result="DaftarBuku.jsp";
        }
        
        request.setAttribute("idKatBuku", idKategoriBuku);
        request.setAttribute("kategoriBuku", kategoriBuku);
        return result;
    }
}
