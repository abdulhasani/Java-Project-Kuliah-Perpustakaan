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
import san.jmat.perpus.dao.service.PeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DaftarPeminjaman implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String pesan;
        pesan=null;
        Long jumlahBukuDipinjam;
        jumlahBukuDipinjam = null;
        String result;
        result = null;
        List<Peminjaman> peminjamans;
        peminjamans = new ArrayList<>();
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        if(user!=null){
            result="DaftarPeminjaman.jsp";
            try{
            PeminjamanDao peminjamanDao=DBPerpustakaan.getPeminjamanDao();
            peminjamans=peminjamanDao.joinTable();
            jumlahBukuDipinjam=peminjamanDao.bukuDipinjam();
            }
            catch(SQLException e){
                
            }catch(Exception ex){
                
            }
        }else{
            result="home.jsp";
        }
        request.setAttribute("ms", pesan);
        request.setAttribute("peminjaman", peminjamans);
        request.setAttribute("jumlah", jumlahBukuDipinjam);
        return result;
    }
}
