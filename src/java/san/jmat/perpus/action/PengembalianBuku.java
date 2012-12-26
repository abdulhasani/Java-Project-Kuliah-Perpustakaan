/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.PeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.Pengembalian;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class PengembalianBuku implements ActionInterface {

    private static Pengembalian Objekpengembalian;

    public static Pengembalian getPengembalian() {
        return Objekpengembalian;
    }

    public static void setPengembalian(Pengembalian pengembalian) {
        PengembalianBuku.Objekpengembalian = pengembalian;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        Integer jmlhItem = null;
        SimpleDateFormat format1 = new SimpleDateFormat("dd");
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String tanggal = null;
        String bulan = null;
        String tahun = null;
        String nomorAnggota = request.getParameter("noAnggota");
        String idPeminjaman = request.getParameter("idPeminjam");
        Long nyicil=null;
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        List<Peminjaman> filter = null;
        if (user != null) {
            result = "Pengembalian Buku.jsp";
            try {
                if (nomorAnggota != null) {
                    if (!nomorAnggota.trim().equals("")) {
                        PeminjamanDao peminjamanDao = DBPerpustakaan.getPeminjamanDao();
                        filter = peminjamanDao.filter(nomorAnggota);
                        jmlhItem = filter.size();
                        Pengembalian pengembalian = new Pengembalian();
                        pengembalian.setPeminjamans(filter);
                        PengembalianBuku.setPengembalian(pengembalian);
                        tanggal = format1.format(date);
                        bulan = format2.format(date);
                        tahun = format3.format(date);
                    }
                } else if (idPeminjaman != null) {
                    if (!idPeminjaman.trim().equals("")) {
                        PeminjamanDao peminjamanDao = DBPerpustakaan.getPeminjamanDao();
                        Long konId = Long.parseLong(idPeminjaman);
                        Peminjaman byId = peminjamanDao.getById2(konId);
                        nomorAnggota = byId.getNomorAnggota();
                        List<Peminjaman> list=new ArrayList<>();
                        list.add(byId);
                        filter=list;
                        jmlhItem=filter.size();
                        Pengembalian pengembalian = new Pengembalian();
                        pengembalian.setNomorAnggota(nomorAnggota);
                        pengembalian.setPeminjamans(filter);
                        PengembalianBuku.setPengembalian(pengembalian);
                        tanggal = format1.format(date);
                        bulan = format2.format(date);
                        tahun = format3.format(date);
                        nyicil=byId.getIdPeminjaman();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            result = "home.jsp";
        }
        session.setAttribute("tgl", tanggal);
        session.setAttribute("bln", bulan);
        session.setAttribute("thn", tahun);
        request.setAttribute("nyicil", nyicil);
        request.setAttribute("nomorAnggota", nomorAnggota);
        request.setAttribute("jmlhItem", jmlhItem);
        request.setAttribute("peminjaman", filter);
        return result;
    }
}
