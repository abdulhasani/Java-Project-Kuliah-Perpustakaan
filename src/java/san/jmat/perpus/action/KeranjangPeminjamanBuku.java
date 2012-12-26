
/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.DetilPeminjaman;
import san.jmat.perpus.entity.KeuanganPeminjaman;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class KeranjangPeminjamanBuku implements ActionInterface {

    List<Buku> bukus = new ArrayList<>();    
    
    public List<Buku> getBukus() {
        return bukus;
    }
    
    public void setBukus(List<Buku> bukus) {
        this.bukus = bukus;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String result;
        result = null;
        Integer itemKeranjang;
        Integer keranjangFull = null;
        itemKeranjang = null;
        String idBuku = request.getParameter("idBuku");
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        
        if (user != null) {
            result = "controler?/san/jmat/perpus/action=peminjamanBuku";
            try {
                Integer konIdBuku = Integer.parseInt(idBuku);
                BukuDao bukuDao = DBPerpustakaan.getBukuDao();
                Buku byId = bukuDao.getById(konIdBuku);
                DetilPeminjaman detilPeminjaman = new DetilPeminjaman();
                detilPeminjaman.setBukuId(byId);
                detilPeminjaman.setStatus("Dipinjam");
                Peminjaman peminjaman = (Peminjaman) session.getAttribute("keranjang");
                
                if(peminjaman==null){
                    peminjaman=new Peminjaman();
                    
                }
                peminjaman.getDetilPeminjamans().add(detilPeminjaman);
                
                itemKeranjang=peminjaman.getDetilPeminjamans().size();
                if(itemKeranjang>3){
                    keranjangFull=itemKeranjang;
                    
                }else{
                    session.setAttribute("keranjang", peminjaman);
                    KeuanganPeminjaman.setDetilPeminjamans(peminjaman.getDetilPeminjamans());
                }
            } catch (Exception e) {
                
            }
        } else {
            result = "controler?/san/jmat/perpus/action=home";
        }
        session.setAttribute("itemKeranjang", itemKeranjang);
        request.setAttribute("keranjangFull", keranjangFull);
        return result;
    }
}
