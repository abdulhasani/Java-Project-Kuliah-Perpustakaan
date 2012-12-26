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
public class DaftarBukuAction implements ActionInterface {

    //overrid method 
    @Override
    public String execute(HttpServletRequest request) {
        //varibel ktgBuku 
        //tipe data list diisi dengan objek array list
        List<KategoriBuku> ktgBuku = new ArrayList<>();
        //varibel buku 
        //tipe data list diisi dengan objek array list
        List<Buku> buku = new ArrayList<>();
        //varibel result
        String result;
        //varibel result di set null
        result = null;
        try {
            //Polimorphysme 
            KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
            //isi varibel ktgBuku
            //dengan cara dapetin return value dari method 
            //selectAll pada kelas kategoriBukuDao yang methodnya udah di
            //overridde di kelas KategoriBukuImplemen
            ktgBuku = kategoriBukuDao.selectAll();
            //Polimorphysme 
            BukuDao bukuDao = DBPerpustakaan.getBukuDao();
            //isi variabel buku
            //dengan cara dapetin return value dari method
            //selectAll pada kelas BukuDao yang methodnya udah di override
            //pada kelas BukuImplemen
            buku = bukuDao.selectAll();
            //Tangkap session
            HttpSession session=request.getSession(true);
            User user=(User) session.getAttribute("login");
            //jika dalam sesi admin
            if(user!=null){
                result="DaftarBukuAdmin.jsp";
            }
            //jika bukan dalam sesi admin
            else{
                result="DaftarBuku.jsp";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBukuAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
        }
        //set atribut 
        request.setAttribute("categorys", ktgBuku);
        request.setAttribute("bukuAll", buku);
        //alihkan respon ke file jsp 
        //dimana variabel result sudah di inisialisai di atas
        return result;
    }
}
