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
import san.jmat.perpus.dao.service.KategoriAnggotaDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KategoriAnggota;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class CrudKategoriAnggota implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String pesan=null;
        String result=null;
        String idKategoriAnggota=request.getParameter("idKtgAnggota");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        KategoriAnggota kategoriAnggota = null;
        if (user != null) {
            result="CrudKategoriAnggota.jsp";
            if(!idKategoriAnggota.equals("")){
                try{
                    Integer konIdKatAnggota=Integer.parseInt(idKategoriAnggota);
                KategoriAnggotaDao kategoriAnggotaDao=DBPerpustakaan.getKategoriAnggotaDao();
                    kategoriAnggota = kategoriAnggotaDao.getById(konIdKatAnggota);
                }catch(SQLException e){
                    pesan=e.getMessage();
                    result="DaftarKategoriBuku.jsp";
                }catch(Exception ex){
                    pesan=ex.getMessage();
                    result="DaftarKategoriBuku.jsp";
                }
            }
        } else {
            result="DaftarBuku.jsp";
        }
        
        
        request.setAttribute("kategoriAnggota", kategoriAnggota);
        return result;
    }
    
}
