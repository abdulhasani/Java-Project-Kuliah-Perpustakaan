/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.PengembalianDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.KeuanganDenda;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.Pengembalian;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class PengembalianBukuFinish implements ActionInterface {

    private static KeuanganDenda keuanganDenda;

    public static KeuanganDenda getKeuanganDenda() {
        return keuanganDenda;
    }

    public static void setKeuanganDenda(KeuanganDenda keuanganDenda) {
        PengembalianBukuFinish.keuanganDenda = keuanganDenda;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String nomorAnggota = request.getParameter("noAnggota");
        String nomorAnggota2 = null;
        String idPeminjaman = request.getParameter("idPeminjam");
        SimpleDateFormat format1 = new SimpleDateFormat("dd");
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy");
        String tanggal = null;
        String bulan = null;
        String tahun = null;
        String result = null;
        String pesan = null;
        Integer totalDenda = 0;
        Integer item = null;
        List<String> list = new ArrayList<>();
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        if (user != null) {
            Pengembalian pengembalian = PengembalianBuku.getPengembalian();
            KeuanganDenda Kdenda = new KeuanganDenda();

            try {
                Integer date = Integer.parseInt(request.getParameter("dd"));
                Integer moon = Integer.parseInt(request.getParameter("MM")) - 1;
                Integer year = Integer.parseInt(request.getParameter("yyyy"));
                Calendar newCal = Calendar.getInstance();
                newCal.set(year, moon, date);
                pengembalian.setTglKembali(new Date(newCal.getTime().getTime()));
                Kdenda.setTanggalPendendaan(new Date(newCal.getTime().getTime()));
                Kdenda.setNomorAnggota(nomorAnggota);
                item = pengembalian.getPeminjamans().size();
                Integer denda = null;
                Calendar newCal2 = Calendar.getInstance();
                for (Peminjaman peminjaman : pengembalian.getPeminjamans()) {
                    tanggal = format1.format(peminjaman.getTanggalHarusKembali());
                    Integer tgl = Integer.parseInt(tanggal);
                    bulan = format2.format(peminjaman.getTanggalHarusKembali());
                    Integer bln = Integer.parseInt(bulan) - 1;
                    tahun = format3.format(peminjaman.getTanggalHarusKembali());
                    Integer thn = Integer.parseInt(tahun);
                    newCal2.set(thn, bln, tgl);
                    int selisih = newCal.get(Calendar.DAY_OF_YEAR) - newCal2.get(Calendar.DAY_OF_YEAR);
                    nomorAnggota2 = peminjaman.getNomorAnggota();
                    if (selisih > 0) {
                        denda = 2000 * selisih;
                        totalDenda = denda + totalDenda;
                        list.add("" + peminjaman.getJudulBuku() + ", &nbsp;&nbsp; Telat " + selisih + " Hari &nbsp;&nbsp; Rp. " + denda);
                        Kdenda.getList().add("" + peminjaman.getJudulBuku() + ", Telat " + selisih + " Hari ");
                        Kdenda.setNominalDenda(totalDenda);
                    }

                }
                if (nomorAnggota != null) {
                    if (!nomorAnggota.trim().equals("")) {
                        if (list.isEmpty()) {
                            result = "controler?/san/jmat/perpus/action=daftarPeminjaman";
                            PengembalianDao pengembalianDao = DBPerpustakaan.getPengembalianDao();
                            pengembalianDao.Insert(pengembalian, nomorAnggota);


                        } else {
                            PengembalianBukuFinish.setKeuanganDenda(Kdenda);
                            result = "DendaPeminjamanBuku.jsp";
                            PengembalianDao pengembalianDao = DBPerpustakaan.getPengembalianDao();
                            pengembalianDao.Insert(pengembalian, nomorAnggota);
                        }
                    }
                } else if (idPeminjaman != null) {
                    if (!idPeminjaman.trim().equals("")) {
                        Long konId = Long.parseLong(idPeminjaman);
                        nomorAnggota = nomorAnggota2;
                        Kdenda.setNomorAnggota(nomorAnggota2);
                        Kdenda.setNominalDenda(totalDenda);

                        if (list.isEmpty()) {
                            result = "controler?/san/jmat/perpus/action=daftarPeminjaman";
                            PengembalianDao pengembalianDao = DBPerpustakaan.getPengembalianDao();
                            pengembalianDao.Insert2(pengembalian, konId);


                        } else {
                            PengembalianBukuFinish.setKeuanganDenda(Kdenda);
                            result = "DendaPeminjamanBuku.jsp";
                            PengembalianDao pengembalianDao = DBPerpustakaan.getPengembalianDao();
                            pengembalianDao.Insert2(pengembalian, konId);
                        }

                    }
                }

            } catch (Exception e) {
                if (!e.getMessage().equals("Can't call commit when autocommit=true")) {
                    pesan = "Format Tanggal Berupa angka";
                    result = "controler?/san/jmat/perpus/action=pengembalianBuku&noAnggota=" + nomorAnggota;
                }
            }
        } else {
            result = "home.jsp";
        }

        request.setAttribute("pesan", pesan);
        request.setAttribute("jumlahItem", item);
        request.setAttribute("list", list);
        request.setAttribute("totalDenda", totalDenda);
        request.setAttribute("nomorAnggota", nomorAnggota);
        return result;
    }
}
