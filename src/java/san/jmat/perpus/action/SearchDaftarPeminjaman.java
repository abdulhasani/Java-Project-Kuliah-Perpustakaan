/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.PeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SearchDaftarPeminjaman implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        String pesan=null;
        Long jumlahBukuDipinjam;
        jumlahBukuDipinjam = null;
        String search=request.getParameter("filter");
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        List<Peminjaman> filter=null;
        if(user!=null){
            result="DaftarPeminjaman.jsp";
            if(!search.trim().equals("")){
            try{
                PeminjamanDao peminjamanDao=DBPerpustakaan.getPeminjamanDao();
                filter = peminjamanDao.filter(search);
                jumlahBukuDipinjam=peminjamanDao.bukuDipinjam();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            }else{
                pesan="Harap Tentukan Data Yang Hendak DiCari";
            }
        }else{
            result="home.jp";
        }
        request.setAttribute("msg2", pesan);
        request.setAttribute("peminjaman", filter);
        request.setAttribute("jumlah", jumlahBukuDipinjam);
        return result;
    }
    
}
