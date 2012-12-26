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
import san.jmat.perpus.dao.service.PengembalianDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Pengembalian;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DaftarPengembalian implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result;
        String pesan;
        result = null;
        
        List<Pengembalian> selectAll = new ArrayList<>();
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        if(user!=null){
            result="Daftar Pengembalian.jsp";
            try {
                PengembalianDao pengembalianDao;
                pengembalianDao = DBPerpustakaan.getPengembalianDao();
                
                selectAll = pengembalianDao.selectAll();
            } catch (SQLException ex) {
                Logger.getLogger(DaftarPengembalian.class.getName()).log(Level.SEVERE, null, ex);
            }catch(Exception e){
                
            }
        }else{
            result="home.jsp";
        }
        request.setAttribute("pengembalian", selectAll);
        
        return result;
    }
    
}
