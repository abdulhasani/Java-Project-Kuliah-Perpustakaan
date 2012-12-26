/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.PeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.Pengembalian;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class ViewBukuDipinjam implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result=null;
        String nomorAnggota=request.getParameter("noAnggota");
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        List<Peminjaman> filter = null;
        if (user != null) {
            result="View Buku Yang DiPinjam.jsp";
            try{
                PeminjamanDao peminjamanDao=DBPerpustakaan.getPeminjamanDao();
                filter = peminjamanDao.filter(nomorAnggota);
                if(filter.isEmpty()){
                    result="controler?/san/jmat/perpus/action=daftarAnggota";
                }
            }catch(SQLException e){
                
            }catch(Exception e){
                
            }
            
        }else{
            result="home.jsp";
        }
        request.setAttribute("nomorAnggota", nomorAnggota);
        request.setAttribute("judulBuku", filter);
        return result;
    }
    
}
