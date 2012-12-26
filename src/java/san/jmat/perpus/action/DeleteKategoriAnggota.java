/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.KategoriAnggotaDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DeleteKategoriAnggota implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result=null;
        String idKategoriAnggota;
         String pesan=null;
        idKategoriAnggota = request.getParameter("idKtgAnggota");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarKategoriAnggota";
            Integer konIdKategoriAnggota = Integer.parseInt(idKategoriAnggota);
            try{
            KategoriAnggotaDao kategoriAnggotaDao=DBPerpustakaan.getKategoriAnggotaDao();
            kategoriAnggotaDao.Delete(konIdKategoriAnggota);
            pesan = "Berhasil Menghapus Data";
                    }
           catch(Exception e){
               e.printStackTrace();
           }
                
            
        }else {
            result = "home.jsp";
        }
        request.setAttribute("msg2", pesan);
        return result;
    }
}
