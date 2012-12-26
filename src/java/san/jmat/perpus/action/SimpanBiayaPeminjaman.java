/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.KeUanganPeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KeuanganPeminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SimpanBiayaPeminjaman implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result=null;
        String pesan=null;
        String uangPembayaran=request.getParameter("uangPembayaran");
        Integer uangkembalian=null;
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if(user!=null){
            result="controler?/san/jmat/perpus/action=biayaPeminjaman";
            if(!uangPembayaran.trim().equals("")){
            try{
                Integer konUangPem=Integer.parseInt(uangPembayaran);
                if(konUangPem<KeuanganPeminjaman.getNominalPemasukan()){
                    pesan="Uang Pembayaran Tidak Cukup";
                }else {
                    KeuanganPeminjaman.setTanggalPemasukan(new Date());
                    Integer hitung=konUangPem-KeuanganPeminjaman.getNominalPemasukan();
                    uangkembalian=hitung;
                    KeUanganPeminjamanDao keUanganPeminjamanDao=DBPerpustakaan.getKeUanganPeminjamanDao();
                    keUanganPeminjamanDao.Insert();
                    if(uangkembalian==0){
                        result="controler?/san/jmat/perpus/action=daftarPeminjaman";
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception ex){
               pesan="Format Uang Pembayaran Berupa Angka";
            }
            
            }else{
                pesan="Harap input uang pembayaran";
            }
        }else{
            result="home.jsp";
        }
        
        request.setAttribute("pesan", pesan);
        request.setAttribute("kembalian", uangkembalian);
        return result;
    }
    
}
