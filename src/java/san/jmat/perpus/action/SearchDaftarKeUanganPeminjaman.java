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
import san.jmat.perpus.dao.service.KeUanganPeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.DetilKeUanganPeminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SearchDaftarKeUanganPeminjaman implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        String pesan2=null;
        String pesan=null;
        String filter=request.getParameter("pencarian");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        List<DetilKeUanganPeminjaman> selectAll = new ArrayList<>();
        Integer sum=0;
        if (user != null) {
            result = "Daftar KeUangan Peminjaman.jsp";
            if(!filter.trim().equals("")){
            try {
                KeUanganPeminjamanDao keUanganPeminjamanDao=DBPerpustakaan.getKeUanganPeminjamanDao();
                selectAll=keUanganPeminjamanDao.filter(filter);
                sum = keUanganPeminjamanDao.sum();
                if(selectAll.isEmpty()){
                    pesan="Data Yang Anda Cari Tidak Ditemukan";
                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchDaftarKeUanganPeminjaman.class.getName()).log(Level.SEVERE, null, ex);
            }catch(Exception e){
                
            }
            }else{
                pesan2="<font color=\"red\"><strong>Masukan Data Untuk Pencarian</strong></font>";
                result="controler?/san/jmat/perpus/action=daftarKeUanganPeminjaman";
            }
            
        }else{
            result="home.jsp";
        }
        request.setAttribute("msg2", pesan2);
        request.setAttribute("msg", pesan);
        request.setAttribute("total", sum);
        request.setAttribute("keuanganPmj", selectAll);
        return result;
    }
    
}
