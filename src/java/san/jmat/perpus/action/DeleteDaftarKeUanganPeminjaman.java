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
import san.jmat.perpus.dao.service.KeUanganPeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.DetilKeUanganPeminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DeleteDaftarKeUanganPeminjaman implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        String pesan = null;
        String komfirmasi = request.getParameter("komfirmasi");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        List<DetilKeUanganPeminjaman> selectAll = new ArrayList<>();
        Integer sum = 0;
        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarKeUanganPeminjaman";


            try {
                KeUanganPeminjamanDao keUanganPeminjamanDao = DBPerpustakaan.getKeUanganPeminjamanDao();
                selectAll = keUanganPeminjamanDao.selectAll();
                sum = keUanganPeminjamanDao.sum();
                if (komfirmasi != null) {
                    if (komfirmasi.equals("YES")) {

                        keUanganPeminjamanDao.DeletAll();
                        pesan = "Berhasil Menghapus Data";
                        
                    }
                } else {
                    pesan = "<font color=\"red\"><strong>Hapus Semua Data ?</strong></font>&nbsp;&nbsp;<a href=\"controler?/san/jmat/perpus/action=deleteDaftarKeUanganPeminjaman&komfirmasi=YES\">YES</a>";
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            result = "home.jsp";
        }
        request.setAttribute("msg2", pesan);
        request.setAttribute("total", sum);
        request.setAttribute("keuanganPmj", selectAll);
        return result;
    }
}
