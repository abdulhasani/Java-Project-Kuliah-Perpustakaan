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
import san.jmat.perpus.dao.service.KeUanganPendendaanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KeuanganDenda;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DaftarKeUanganDenda implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        List<KeuanganDenda> selectAll=new ArrayList<>();
        Integer totalUangDenda=0;
        if (user != null) {
            result="Daftar KeUangan Pendendaan.jsp";
            try {
                KeUanganPendendaanDao keUanganPendendaanDao;
                keUanganPendendaanDao = DBPerpustakaan.getKeUanganPendendaanDao();
                selectAll = keUanganPendendaanDao.selectAll();
                totalUangDenda=keUanganPendendaanDao.sum();
            } catch (SQLException ex) {
                Logger.getLogger(DaftarKeUanganDenda.class.getName()).log(Level.SEVERE, null, ex);
            }catch(Exception e){
                
            }
        }else{
            result="home.jsp";
        }
        request.setAttribute("totalUangDenda", totalUangDenda);
        request.setAttribute("denda", selectAll);
        return result;
    }
    
}
