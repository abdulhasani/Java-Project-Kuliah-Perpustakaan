/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.KategoriBuku;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SimpanBukuFinish implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        //Konsep Sekuen Dalam mendeklarasikan variabel
        String result;
        result = null;
        String pesan;
        pesan = null;
        String idBuku;
        String judul;
        String pengarang;
        String penerbit;
        String tahunTerbit;
        String kategoriBukuId;
        String jumlahStok;
        String jumlahTersedia;
        String keterangan;
        String sinopsis;
        idBuku = request.getParameter("idBk");
        judul = request.getParameter("judulBuku");
        pengarang = request.getParameter("pengarang");
        penerbit = request.getParameter("penerbit");
        tahunTerbit = request.getParameter("tahunTerbit");
        kategoriBukuId = request.getParameter("kategoriBukuId");
        jumlahStok = request.getParameter("jumlahStok");
        jumlahTersedia = request.getParameter("jumlahTersedia");
        keterangan = request.getParameter("keterangan");
        sinopsis = request.getParameter("sinopsis");
        KategoriBuku kategoriBuku;
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarBukuAdmin";
        } else {
            result = "home.jsp";
        }
        //Jika varibel iddBuku sama dengan kosong
        //kita deteksi bahawa itu proses insert
        if (idBuku.equals("")) {
            //validasi semua textFile tidak boleh kosong
            if (!judul.trim().equals("") && !pengarang.trim().equals("") && !penerbit.trim().equals("")
                    && !tahunTerbit.trim().equals("") && !kategoriBukuId.equals("0")
                    && !jumlahStok.trim().equals("") && !jumlahTersedia.trim().equals("")
                    && !keterangan.trim().equals("") && !sinopsis.trim().equals("")) {
                //set variabel pesan
                pesan = "Buku baru berhasil ditambahkan";
                try {
                    Integer katBukuId = Integer.parseInt(kategoriBukuId);
                    Integer jmlStok = Integer.parseInt(jumlahStok);
                    Integer jmlTersedia = Integer.parseInt(jumlahTersedia);
                    KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
                    kategoriBuku = kategoriBukuDao.getById(katBukuId);
                    BukuDao bukuDao = DBPerpustakaan.getBukuDao();
                    Buku buku = new Buku();
                    buku.setJudul(judul);
                    buku.setPengarang(pengarang);
                    buku.setPenerbit(penerbit);
                    buku.setTahunTerbit(tahunTerbit);
                    buku.setKategoriBuku(kategoriBuku);
                    buku.setJumlahStok(jmlStok);
                    buku.setJumlahTersedia(jmlTersedia);
                    buku.setKeterangan(keterangan);
                    buku.setSinopsis(sinopsis);
                    bukuDao.Insert(buku);
                } catch (SQLException e) {
                } catch (Exception ex) {
                    pesan = "Gagal Menambahkan, Jumlah Stok dan Jumlah Tersdia Berformat Angka";
                    result = "controler?/san/jmat/perpus/action=simpanBuku";
                }


            } else {
                pesan = "HARAP INPUT SEMUA DATA";
                result = "controler?/san/jmat/perpus/action=simpanBuku";
            }
        }
        //Sedangkan untuk update secara logika
        //idBuku tidak boleh sama dengan kosong karena mengupdate berdasarkan idBuku
        if (!idBuku.equals("")) {
            //validasi semua textFiled tidak boleh kosong
            if (!judul.trim().equals("") && !pengarang.trim().equals("") && !penerbit.trim().equals("")
                    && !tahunTerbit.trim().equals("") && !kategoriBukuId.equals("0")
                    && !jumlahStok.trim().equals("") && !jumlahTersedia.trim().equals("") 
                    && !keterangan.trim().equals("")
                    && !sinopsis.trim().equals("")) {
                pesan = "Berhasil mengedit buku";

                try {
                    //Konversi String ke Integer
                    Integer bookID = Integer.parseInt(idBuku);
                    Integer katBukuId = Integer.parseInt(kategoriBukuId);
                    Integer jmlTersedia = Integer.parseInt(jumlahTersedia);
                    Integer jmlStok = Integer.parseInt(jumlahStok);
                    //Konsep Polimorphysme
                    KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
                    //Panggil metode getById dimana parameternya variabel katBukuId
                    kategoriBuku = kategoriBukuDao.getById(katBukuId);
                    BukuDao bukuDao = DBPerpustakaan.getBukuDao();
                    Buku buku = new Buku();
                    buku.setJudul(judul);
                    buku.setPengarang(pengarang);
                    buku.setPenerbit(penerbit);
                    buku.setTahunTerbit(tahunTerbit);
                    buku.setKategoriBuku(kategoriBuku);
                    buku.setJumlahStok(jmlStok);
                    buku.setJumlahTersedia(jmlTersedia);
                    buku.setKeterangan(keterangan);
                    buku.setSinopsis(sinopsis);
                    bukuDao.Update(bookID, buku);
                } catch (SQLException e) {
                } catch (Exception e) {
                    pesan = "Gagal Mengedit,Jumlah Stok dan Jumlah Tersdia Berformat Angka";
                    result = "controler?/san/jmat/perpus/action=daftarBukuAdmin";
                }
            } else {
                pesan = "Gagal mengedit buku harap input semua data";
                result = "controler?/san/jmat/perpus/action=daftarBukuAdmin";
            }


        }

        request.setAttribute("msg2", pesan);
        return result;
    }
}
