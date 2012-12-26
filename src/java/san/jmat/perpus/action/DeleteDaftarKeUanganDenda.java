/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.KeUanganPendendaanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DeleteDaftarKeUanganDenda implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result;
        result = null;
        String pesan2;
        pesan2 = null;
        String komfirmasi = request.getParameter("komfirmasi");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarKeUanganPendendaan";
            if (komfirmasi != null) {
                if (!komfirmasi.equals("")) {
                    try {
                        KeUanganPendendaanDao keUanganPendendaanDao;
                        keUanganPendendaanDao = DBPerpustakaan.getKeUanganPendendaanDao();
                        keUanganPendendaanDao.DeleteAll();
                    } catch (SQLException ex) {
                        Logger.getLogger(DeleteDaftarKeUanganDenda.class.getName()).log(Level.SEVERE, null, ex);
                    }catch(Exception e){
                        
                    }
                }
            } else {
                pesan2 = "<font color=\"red\"><strong>Hapus Semua Data ?</strong></font>&nbsp;&nbsp;<a href=\"controler?/san/jmat/perpus/action=deleteDaftarKeUanganPendendaan&komfirmasi=YES\">YES</a>";
            }
        } else {
            result = "home.jsp";
        }
        request.setAttribute("msg2", pesan2);
        return result;

    }
}
