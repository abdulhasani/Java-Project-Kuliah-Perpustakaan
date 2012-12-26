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
public class CrudAnggota implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result;
        result = null;
        HttpSession session=request.getSession(true);
        String seleksi=request.getParameter("edit");
        User user = (User) session.getAttribute("login");
        List<KategoriAnggota> anggotas=new ArrayList<>();
        Anggota anggota=null;
        if(user!=null){
          result="CrudAnggota.jsp";
            try {
                KategoriAnggotaDao kategoriAnggotaDao=DBPerpustakaan.getKategoriAnggotaDao();
                anggotas=kategoriAnggotaDao.selectAll();
                if(!seleksi.equals("")){
                Integer idAnggota=Integer.parseInt(seleksi);
                AnggotaDao anggotaDao=DBPerpustakaan.getAnggotaDao();
                anggota =anggotaDao.getById(idAnggota);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SimpanBuku.class.getName()).log(Level.SEVERE, null, ex);
            }catch(Exception e){
                
            }
          
        }else{
            result="home.jsp";
        }
        
        request.setAttribute("seleksi", seleksi);
        request.setAttribute("Anggota", anggota);
        request.setAttribute("kategoriAnggota", anggotas);
        return result;
    }
}
