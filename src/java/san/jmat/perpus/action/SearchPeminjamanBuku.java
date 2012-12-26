/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.util.ArrayList;
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
public class SearchPeminjamanBuku implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result=null;
        String search=request.getParameter("cari");
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        List<Buku> selectAll = new ArrayList<>();
        if (user != null) {
            result = "PeminjamanBuku.jsp";
            try {
                BukuDao bukuDao = DBPerpustakaan.getBukuDao();
                if(!search.trim().equals("")) {
                   selectAll=bukuDao.getJudulorId(search, search); 
                   if(!selectAll.isEmpty()){
                   request.setAttribute("buku", selectAll);
                   }
                }
                
            }catch(Exception e){
                
            }
            
        }else {
            result = "home.jsp";
        }
        return result;
    }
    
}
