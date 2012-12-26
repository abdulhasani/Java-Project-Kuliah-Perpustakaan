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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.KategoriAnggotaDao;
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KategoriAnggota;
import san.jmat.perpus.entity.KategoriBuku;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DaftarKategoriAnggota implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
     String result = null;
        
        List<KategoriAnggota> anggotas=new ArrayList<>();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if (user != null) {
            result = "DaftarKategoriAnggota.jsp";
            try{
            KategoriAnggotaDao kategoriAnggotaDao=DBPerpustakaan.getKategoriAnggotaDao();
            anggotas=kategoriAnggotaDao.selectAll();
            }
            catch(SQLException e){
                
            }catch(Exception ex){
                
            }
        } else {
            result = "DaftarBuku.jsp";
        }
        
        request.setAttribute("anggotas", anggotas);
        return result;   
    }
}
