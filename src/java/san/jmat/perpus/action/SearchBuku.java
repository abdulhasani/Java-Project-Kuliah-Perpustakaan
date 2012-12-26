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
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KategoriBuku;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SearchBuku implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        //Variabel ktgBuku dengan tipe data List tipe genericnya di set
        //KategoriBuku ktgBuku di inisialisi dengan objeknya ArrayList()
        List<KategoriBuku> ktgBuku = new ArrayList<>();
        //varibel result untuk return value methodnya
        String result;
        result = null;
        try {
            //Konsep polimorphysme
            KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
            //method selectAll akan menghasilkan return value berupa
            //List<KategoriBuku> dengan objeknya berupa ArrayList
            //return value tersebut kita set ke varibel ktgBuku
            ktgBuku = kategoriBukuDao.selectAll();
            //Tangkap session
            HttpSession session=request.getSession(true);
            //saat menangkap session dengan attribut login
            //method getAttribute mereturn value berupa
            //Objek
            User user=(User) session.getAttribute("login");
            //jika vaibel user berisi objek otomatis tidak sama dengan null
            if(user!=null){
                //maka inisialisasi variabel 
                //result 
                //gunakan mapping untuk mengkases file DaftarBukuAdmin.jsp
                //agar bisa menapilkan datanya
                result="controler?/san/jmat/perpus/action=daftarBukuAdmin";
            }
            //jika bukan dalam session admin
            //maka responnya dialihkan ke SearchBuku.jsp
            else{
                result="SearchBuku.jsp";
            }
        } catch (SQLException e) {
        } catch (Exception e) {
        }
        //set attribut
        request.setAttribute("categorys", ktgBuku);
        //returnkan varibel result untuk method
        return result;
    }
}
