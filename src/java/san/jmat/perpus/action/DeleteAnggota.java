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
import san.jmat.perpus.dao.service.AnggotaDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Anggota;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DeleteAnggota implements ActionInterface {
    private static Integer idAnggota;

    public static Integer getIdAnggota() {
        return idAnggota;
    }

    public static void setIdAnggota(Integer idAnggota) {
        DeleteAnggota.idAnggota = idAnggota;
    }
    @Override
    public String execute(HttpServletRequest request) {
        String result;
        String idAnggota;
        String pesan;
        
        pesan = null;
        result = null;
        idAnggota = request.getParameter("delete");
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");

        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarAnggota";
            if (!idAnggota.equals("")) {
                try {
                    Integer konIdAnggota = Integer.parseInt(idAnggota);
                    setIdAnggota(konIdAnggota);
                    String deleteAnggotaFinsih="controler?/san/jmat/perpus/action=deleteAnggotaFinish";
                    AnggotaDao anggotaDao = DBPerpustakaan.getAnggotaDao();
                    Anggota anggota = anggotaDao.getById(konIdAnggota);
                    pesan = "Anda Hendak Menghapus Anggota Dengan Nama = "+anggota.getNama()+"&nbsp;&nbsp;[<a href="+deleteAnggotaFinsih+">YES </a>]";
                } catch (SQLException e) {
                } catch (Exception ex) {
                }

            }
        } else {
            result = "home.jsp";
        }
        request.setAttribute("msg2", pesan);
        return result;
    }
    
    
}
