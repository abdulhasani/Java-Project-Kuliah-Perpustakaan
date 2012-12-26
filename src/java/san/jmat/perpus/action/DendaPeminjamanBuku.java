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
import san.jmat.perpus.dao.service.KeUanganPendendaanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KeuanganDenda;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DendaPeminjamanBuku implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        String pesan = null;
        
        Integer uangKembalian=null;
        String uangPembayaran = request.getParameter("uangPembayaran");
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        
        KeuanganDenda keuanganDenda=null;
        if (user != null) {
            keuanganDenda = PengembalianBukuFinish.getKeuanganDenda();
            try {
                    result="DendaPeminjamanBuku.jsp";
                if(!uangPembayaran.trim().equals("")){
                Integer konUangPembayaran=Integer.parseInt(uangPembayaran);
                    if(konUangPembayaran>=keuanganDenda.getNominalDenda()){
                        uangKembalian=konUangPembayaran-keuanganDenda.getNominalDenda();
                        if(uangKembalian==0){
                            result="controler?/san/jmat/perpus/action=daftarPeminjaman";
                        }else{
                            pesan="Uang Kembalian = Rp."+uangKembalian;
                        }
                       KeUanganPendendaanDao keUanganPendendaanDao=DBPerpustakaan.getKeUanganPendendaanDao();
                       keUanganPendendaanDao.Insert(keuanganDenda);
                    }else{
                        pesan="Uang Pembayaran Tidak Cukup";
                    }
                }
                else{
                    pesan="Harap Masukan Uang Pembayaran";
                   
                }
            } catch (Exception e) {
                e.printStackTrace();
                pesan = "Format Uang Pembayaran Berupa Angka";
                
                
            }
        }
        request.setAttribute("nomorAnggota", keuanganDenda.getNomorAnggota());
        request.setAttribute("totalDenda", keuanganDenda.getNominalDenda());
        request.setAttribute("list", keuanganDenda.getList());
        request.setAttribute("jumlahItem", keuanganDenda.getList().size());
        request.setAttribute("msg2", pesan);
        request.setAttribute("uangKembalian", uangKembalian);
        return result;
    }
}
