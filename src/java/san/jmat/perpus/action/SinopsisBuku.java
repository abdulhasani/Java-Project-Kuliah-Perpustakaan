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
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.KategoriBuku;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SinopsisBuku implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        Integer idBuku=Integer.parseInt(request.getParameter("idBuku"));
        Buku buku=null;
        String result="SinopsisBuku.jsp";
        List<KategoriBuku> katBuku=new ArrayList<>();
        try{
            KategoriBukuDao kategoriBukuDao=DBPerpustakaan.getKategoriBukuDao();
            katBuku=kategoriBukuDao.selectAll();
            BukuDao bukuDao=DBPerpustakaan.getBukuDao();
            buku = bukuDao.getById(idBuku);
            
        }catch(Exception ex){
            
        }
        request.setAttribute("categorys", katBuku);
        request.setAttribute("Buku", buku);
        return result;
    }
    
}
