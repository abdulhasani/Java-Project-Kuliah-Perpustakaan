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
public class SearchPengembalian implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result=null;
        String pesan=null;
        String pesan2=null;
        String filter=request.getParameter("pencarian");
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        List<Pengembalian> filter1 = new ArrayList<>();
        if(user!=null){
            result="Daftar Pengembalian.jsp";
            if(!filter.trim().equals("")){
                try {
                    PengembalianDao pengembalianDao=DBPerpustakaan.getPengembalianDao();
                    filter1 = pengembalianDao.filter(filter);
                    if(filter1.isEmpty()){
                       
                       pesan="Data Yang Anda Cari Tidak Ditemukan"; 
                    }
                } catch (SQLException ex) {
                   ex.printStackTrace();
                }catch(Exception x){
                    x.printStackTrace();
                }
                
            }else{
                result="controler?/san/jmat/perpus/action=daftarPengembalian";
                pesan2="<font color=\"red\"><strong>Masukan Data Yang Hendak Dicari</strong></font>";
            }
        }else{
            result="home.jsp";
        }
        request.setAttribute("msg2", pesan2);
        request.setAttribute("msg", pesan);
        request.setAttribute("pengembalian", filter1);
        return result;
    }
    
}
