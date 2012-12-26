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
public class SimpanBuku implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result=null;
        HttpSession session=request.getSession(true);
        String seleksi=request.getParameter("edit");
        User user = (User) session.getAttribute("login");
        List<KategoriBuku> kategoriBukus=new ArrayList<>();
        Buku buku=null;
        if(user!=null){
          result="SimpanBuku.jsp";
            try {
                KategoriBukuDao kategoriBukuDao=DBPerpustakaan.getKategoriBukuDao();
                kategoriBukus=kategoriBukuDao.selectAll();
                if(!seleksi.equals("")){
                Integer idBuku=Integer.parseInt(seleksi);
                BukuDao bukuDao=DBPerpustakaan.getBukuDao();
                buku =bukuDao.getById(idBuku);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SimpanBuku.class.getName()).log(Level.SEVERE, null, ex);
            }catch(Exception e){
                
            }
          
        }else{
            result="home.jsp";
        }
        
        request.setAttribute("seleksi", seleksi);
        request.setAttribute("Buku", buku);
        request.setAttribute("kategoriBuku", kategoriBukus);
        return result;
    }
    
}
