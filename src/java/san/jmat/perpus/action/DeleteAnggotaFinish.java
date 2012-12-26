/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.AnggotaDao;
import san.jmat.perpus.dao.service.PeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Anggota;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DeleteAnggotaFinish implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        //Deklarasi varibel 
        String result;
        String pesan;
        //inisialisasi varibel
        result = null;
        pesan = null;

        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        
        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarAnggota";
            try {

                AnggotaDao anggotaDao; //variabel anggotaDao tipe data interface 
                //AnggotaDao
                //Buat Objek dengan konsep polimorfishem
                anggotaDao = DBPerpustakaan.getAnggotaDao();
                //Variabel anggota dengan tipe data kelas Anggota
                Anggota anggota;
                //isi varibel anggota dengan memanfaatkan 
                //return value method getById
                anggota = anggotaDao.getById(DeleteAnggota.getIdAnggota());
                //Konsep Polimorphysme
                PeminjamanDao peminjamanDao=DBPerpustakaan.getPeminjamanDao();
                //deklarsi varibel 
                List<Peminjaman> byNomorAnggota;
                byNomorAnggota = peminjamanDao.getByNomorAnggota(anggota.getNomorAnggota());
                if(byNomorAnggota.isEmpty()){
                anggotaDao.Delete(DeleteAnggota.getIdAnggota());
                pesan = "Berhasil Menghapus Data";
                }else{
                    pesan="Gagal Menghapus Data, Anggota Sedang Meminjam Buku";
                }
            } catch (SQLException e) {
            } catch (Exception ex) {
            }
        } else {
            result = "home.jsp";
        }
        request.setAttribute("msg2", pesan);
        return result;
    }
}
