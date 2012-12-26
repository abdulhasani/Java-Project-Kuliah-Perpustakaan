/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.AnggotaDao;
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.dao.service.PeminjamanDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Anggota;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.KeuanganPeminjaman;
import san.jmat.perpus.entity.Peminjaman;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class PeminjamanBukuFinish implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        
        String result = null;
        String pesan = null;
        String nomorAnggota = request.getParameter("nomorAnggota");
        String tgl = request.getParameter("dd");
        String bln = request.getParameter("MM");
        String tahun = request.getParameter("yyyy");
        List<Buku> selectAll = new ArrayList<>();
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        Peminjaman peminjaman;
        peminjaman = (Peminjaman) session.getAttribute("keranjang");
        //Jika Dalam Sesi Admin
        if (user != null) {
            result = "PeminjamanBuku.jsp";
            //Untuk melalukan peminjaman 
            //Data yang dibutuhkan harus terpenuhi
            if (!nomorAnggota.trim().equals("") && !tgl.trim().equals("")
                    && !bln.equals("") && !tahun.trim().equals("")
                    && peminjaman != null) {
                try {
                    //Buat Objek AnggotaDao 
                    //Menggunakan konsep polimorphysme
                    AnggotaDao anggotaDao = DBPerpustakaan.getAnggotaDao();
                    
                    //select berdasarkan nomor anggota pada tabel anggota
                    //return value berupa objek anggota
                    Anggota byNomorAnggota = anggotaDao.getByNomorAnggota(nomorAnggota);
                    
                    //Buat objek PeminjamanDao 
                    //Menggunakan konsep polimorphysme
                    PeminjamanDao peminjamanDao = DBPerpustakaan.getPeminjamanDao();
                    
                    //select peminjam berdasarkan nomor anggota
                    //return value berupa ArrayList<Peminjaman>
                    List<Peminjaman> byNomorAnggota1 = peminjamanDao.getByNomorAnggota(nomorAnggota);
                    
                    //Dapetin ukuran ArrayList
                    Integer size = byNomorAnggota1.size();
                    
                    //Peminjam Harus Terdaftar Sebagai Anggota Perpus
                    //Syaratnya objek anggota tidak boleh null
                    if (byNomorAnggota != null) {
                        
                        //Anggota tidak sedang meminjam 3 Buku
                        if (size < 3) {

                            //Jika Anggota sedang minjam 1 Buku
                            if (size == 1) {

                                //Maka Anggota bisa meminjam lebih kecil sama dengan 2 buku lagi
                                if (peminjaman.getDetilPeminjamans().size() <= 2) {
                                    result = "controler?/san/jmat/perpus/action=biayaPeminjaman";
                                    //Panggil metode 
                                    //setNomorAnggota dari Kelas KeuanganPeminjaman
                                    KeuanganPeminjaman.setNomorAnggota(nomorAnggota);
                                    //konversi string tahun ke integer
                                    Integer konThn = Integer.parseInt(tahun);
                                    //Dijava bulan Januari =0
                                    //Maka nilai bulan yang didapetin 
                                    //dari textField harus dikurangi 1
                                    Integer konBln = Integer.parseInt(bln) - 1;
                                    //konversi string tanggal ke integer
                                    Integer konTgl = Integer.parseInt(tgl);
                                    //remove sesion yang beratribut keranjang
                                    session.removeAttribute("keranjang");
                                    //remove sesion yang beratribut itemKeranjang
                                    session.removeAttribute("itemKeranjang");
                                    //Buat objek Calendar dari metode static Calendar dimana
                                    //metodenya getInstance
                                    Calendar newCal = Calendar.getInstance();
                                    //set tanggal sesuai dengan textField
                                    newCal.set(konThn, konBln, konTgl);
                                    //Konversi Objek kalendar ke java.util Date
                                    Date tglPinjam = new Date(newCal.getTime().getTime());
                                    //set metode TanggalPinjam pada Kelas Peminjaman
                                    peminjaman.setTanggalPinjam(tglPinjam);
                                    //Tanggal kembali dapetin dari
                                    //tanggal peminjaman + 7 hari 
                                    //Hari dihitung sejak tanggal peminjaman
                                    //Karena dijava dihitungnya hari esoknya maka
                                    //diset 6 
                                    newCal.add(newCal.DATE, 6);
                                    Date tglHarusKembali = new Date(newCal.getTime().getTime());
                                    peminjaman.setTanggalHarusKembali(tglHarusKembali);
                                    peminjaman.setNomorAnggota(nomorAnggota);
                                    peminjamanDao = DBPerpustakaan.getPeminjamanDao();
                                    peminjamanDao.Insert(peminjaman, nomorAnggota);

                                } //Jika Meminjam lebih dari 2 buku
                                else {
                                    pesan = "Maaf Anggota " + byNomorAnggota.getNama() + " Sedang Meminjam "
                                            + size + " Buku";
                                    session.removeAttribute("keranjang");
                                    session.removeAttribute("itemKeranjang");
                                }

                            }
                            //Jika Anggota Sedang Meminjam 2 Buku
                            else if (size == 2) {
                                //Maka Anggota bisa meminjam sama dengan 1 buku lagi
                                if (peminjaman.getDetilPeminjamans().size() == 1) {
                                    result = "controler?/san/jmat/perpus/action=biayaPeminjaman";
                                    KeuanganPeminjaman.setNomorAnggota(nomorAnggota);
                                    Integer konThn = Integer.parseInt(tahun);
                                    Integer konBln = Integer.parseInt(bln) - 1;
                                    Integer konTgl = Integer.parseInt(tgl);
                                    session.removeAttribute("keranjang");
                                    session.removeAttribute("itemKeranjang");

                                    Calendar newCal = Calendar.getInstance();
                                    newCal.set(konThn, konBln, konTgl);
                                    Date tglPinjam = new Date(newCal.getTime().getTime());
                                    peminjaman.setTanggalPinjam(tglPinjam);
                                    newCal.add(newCal.DATE, 6);
                                    Date tglHarusKembali = new Date(newCal.getTime().getTime());
                                    peminjaman.setTanggalHarusKembali(tglHarusKembali);
                                    peminjaman.setNomorAnggota(nomorAnggota);
                                    peminjamanDao = DBPerpustakaan.getPeminjamanDao();
                                    peminjamanDao.Insert(peminjaman, nomorAnggota);
                                }
                                //Jika meminjam lebih dari 1 buku 
                                else {
                                    pesan = "Maaf Anggota " + byNomorAnggota.getNama() + " Sedang Meminjam "
                                            + size + " Buku";
                                    session.removeAttribute("keranjang");
                                    session.removeAttribute("itemKeranjang");
                                }

                            }
                            //Jika Anggota tidak meminjam buku 
                            else {
                                result = "controler?/san/jmat/perpus/action=biayaPeminjaman";
                                KeuanganPeminjaman.setNomorAnggota(nomorAnggota);
                                Integer konThn = Integer.parseInt(tahun);
                                Integer konBln = Integer.parseInt(bln) - 1;
                                Integer konTgl = Integer.parseInt(tgl);
                                session.removeAttribute("keranjang");
                                session.removeAttribute("itemKeranjang");

                                Calendar newCal = Calendar.getInstance();
                                newCal.set(konThn, konBln, konTgl);
                                Date tglPinjam = new Date(newCal.getTime().getTime());
                                peminjaman.setTanggalPinjam(tglPinjam);
                                newCal.add(newCal.DATE, 6);
                                Date tglHarusKembali = new Date(newCal.getTime().getTime());
                                peminjaman.setTanggalHarusKembali(tglHarusKembali);
                                peminjaman.setNomorAnggota(nomorAnggota);
                                peminjamanDao = DBPerpustakaan.getPeminjamanDao();
                                peminjamanDao.Insert(peminjaman, nomorAnggota);
                            }

                        }
                        //Jika Anggota Sedang Meminjam 3 Buku 
                        else {
                            session.removeAttribute("keranjang");
                            session.removeAttribute("itemKeranjang");
                            pesan = "Maaf Anggota " + byNomorAnggota.getNama() + " Sedang "
                                    + "Meminjam 3 Buku";
                        }
                    }
                    //Jika Anggota Belum Terdaftar
                    else {
                        pesan = "Anggota Belum Terdaftar";
                        session.removeAttribute("keranjang");
                        session.removeAttribute("itemKeranjang");
                    }
                } catch (Exception ex) {
                    pesan = ex.getMessage();
                    if (!pesan.equals("Can't call commit when autocommit=true")) {
                        pesan = "Format Tanggal Berupa angka";
                        result = "PeminjamanBuku.jsp";
                    }

                }
            }
            
            //Jika Data yang dibutuhkan tidak terpenuhi 
            else {

                pesan = "Harap Input Semua Data";
            }

        }
        //Jika Bukan Sesi Admin 
        else {
            result = "home.jsp";
        }
        
        try {
            //Buat Objek BukuDao 
            //Menggunakan konsep Polimorphysme
            BukuDao bukuDao = DBPerpustakaan.getBukuDao();
            //select semua buku
            //retun value berupa ArrayList<Buku>
            selectAll = bukuDao.selectAll();
        } catch (Exception e) {
        }

        request.setAttribute("buku", selectAll);
        request.setAttribute("msg", pesan);
        
        return result;
    }
}
