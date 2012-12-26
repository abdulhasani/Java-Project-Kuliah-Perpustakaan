/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.entity.KeuanganPeminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class ResetKeranjang implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        Integer itemKeranjang;
        Integer keranjangFull = null;
        itemKeranjang = null;
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");

        if (user != null) {
            result = "controler?/san/jmat/perpus/action=peminjamanBuku";
            session.removeAttribute("keranjang");
            session.removeAttribute("itemKeranjang");
            KeuanganPeminjaman.setNomorAnggota(null);
            KeuanganPeminjaman.setNominalPemasukan(null);
            
        }
        else {
            result = "controler?/san/jmat/perpus/action=home";
        }
        request.setAttribute("itemKeranjang", itemKeranjang);
        request.setAttribute("keranjangFull", keranjangFull);
        return result;

    }
}
