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
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DeleteBuku implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
            String result=null;
            HttpSession session=request.getSession(true);
            User user=(User) session.getAttribute("login");
            String idBuku=request.getParameter("delete");
            String kategoriBuku=null;
            Buku buku=null;
            if(user!=null){
                result="DeleteBuku.jsp";
                try{
                    Integer konIdBuku=Integer.parseInt(idBuku);
                    BukuDao bukuDao=DBPerpustakaan.getBukuDao();
                    buku = bukuDao.getById(konIdBuku);
                    kategoriBuku=buku.getKategoriBuku().getNama();
                }catch(SQLException e){
                    
                }catch(Exception ex){
                    
                }
            }else{
                result="home.jsp";
            }
            request.setAttribute("buku", buku);
            request.setAttribute("katBuku", kategoriBuku);
        return result;
    }
    
}
