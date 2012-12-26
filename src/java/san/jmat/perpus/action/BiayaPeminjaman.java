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
import san.jmat.perpus.entity.KeuanganPeminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class BiayaPeminjaman implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        Integer biaya = null;
        
        Integer deteksiIsiArrayList = KeuanganPeminjaman.getDetilPeminjamans().size();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if (user!=null) {
            result="BiayaPeminjaman.jsp";
            if (deteksiIsiArrayList != null) {
                if (deteksiIsiArrayList == 1) {
                    biaya = 7000;
                } else if (deteksiIsiArrayList == 2) {
                    biaya = 7000*deteksiIsiArrayList;
                }else{
                    biaya=7000*deteksiIsiArrayList;
                }
                KeuanganPeminjaman.setNominalPemasukan(biaya);
                
            }
        }else{
            result="home.jsp";
        }
        request.setAttribute("biaya", biaya);
        request.setAttribute("nomorAnggota", KeuanganPeminjaman.getNomorAnggota());
        request.setAttribute("jumlahItem", deteksiIsiArrayList);
        return result;
    }
}
