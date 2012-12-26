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
import san.jmat.perpus.dao.service.AnggotaDao;
import san.jmat.perpus.dao.service.KategoriAnggotaDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Anggota;
import san.jmat.perpus.entity.KategoriAnggota;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class SimpanAnggotaFinish implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        //Deklarasi dan Insialisasi varibel
        //konsep sekuensial
        //apa itu sekuensial
        //sekuensial itu kode yang sudah dieksusi di atas di bawahnya dieksekusi kembali
        String result;
        String pesan;
        result = null;
        pesan = null;
        String idAnggota;
        String nomorAnggota;
        String nama;
        String noIdentitas;
        String jenisIdentitas;
        String alamat;
        String kategoriAnggotaId;
        String keterangan;

        idAnggota = request.getParameter("seleksi");
        nomorAnggota = request.getParameter("noAnggota");
        nama = request.getParameter("nama");
        noIdentitas = request.getParameter("noIdentitas");
        jenisIdentitas = request.getParameter("jenisIdentitas");
        alamat = request.getParameter("alamat");
        kategoriAnggotaId = request.getParameter("kategoriAnggotaId");
        keterangan = request.getParameter("keterangan");
        KategoriAnggota kategoriAnggota;

        //takap session
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");

        if (user != null) {
            result = "controler?/san/jmat/perpus/action=daftarAnggota";
        } else {
            result = "home.jsp";
        }

        //Jika varibel idAnggota tidak diisi otomatis kosong
        //kalau kosong itu melakukan penambahan anggota alias
        //insert
        //validasi untuk insert 
        if (idAnggota.equals("")) {
            if (!nomorAnggota.trim().equals("") && !nama.trim().equals("")
                    && !noIdentitas.trim().equals("") && !jenisIdentitas.trim().equals("")
                    && !alamat.trim().equals("") && !kategoriAnggotaId.equals("0")
                    && !keterangan.trim().equals("")) {
                pesan = "Berhasil menambah anggota";

                try {
                    //deklarasi dan inisialisasi variabel konKatIdAnggota
                    //konversi idKategori ke dari string ke Integer
                    Integer konKatIdAnggota = Integer.parseInt(kategoriAnggotaId);
                    //Konsep Polimorphysme
                    KategoriAnggotaDao kategoriAnggotaDao = DBPerpustakaan.getKategoriAnggotaDao();
                    //panggil metode getById return value berupa Objek dari kelas
                    //KategoriAnggota
                    //Mengapa kita kita harus memanggil method getById?
                    //alasannya kita cuman memastikan bahwa idKategori yang di inputkan sudah 
                    //ada di tabel KategoriAnggota dan juga mengisi attribut2
                    //pada kelas KategoriAnggota
                    kategoriAnggota = kategoriAnggotaDao.getById(konKatIdAnggota);
                    //Konsep Polimorphysme
                    AnggotaDao anggotaDao = DBPerpustakaan.getAnggotaDao();
                    //Buat Objek dari kelas Anggota dan objek juda dari kelas Anggota
                    //ini bukan polimorphysme
                    Anggota anggota = new Anggota();
                    //set semua attribue yang ada di kelas Anggota 
                    anggota.setNomorAnggota(nomorAnggota);
                    anggota.setNama(nama);
                    anggota.setNoIdentitas(noIdentitas);
                    anggota.setJenisIdentitas(jenisIdentitas);
                    anggota.setAlamat(alamat);
                    anggota.setKategoriAnggota(kategoriAnggota);
                    anggota.setKeterangan(keterangan);
                    //Panggil method insert dengan parameter objek anggota
                    anggotaDao.Insert(anggota);
                } catch (SQLException e) {
                } catch (Exception ex) {
                }
            }
            //jika syrat if di atas tidak terpenuhi
            else {
                //inisialisasi varibel pesan
                pesan = "Harap Input Semua Data";
                //ini sialisasi variabel result
                result = "controler?/san/jmat/perpus/action=crudAnggota";
            }
        }
        //Ini untuk proses update
        //proses ini akan dieksekusi jika varibel idAnggota diatas 
        //terinisialisasi tidak sama dengan kosong
        else {
            if (!nomorAnggota.trim().equals("") && !nama.trim().equals("")
                    && !noIdentitas.trim().equals("") && !jenisIdentitas.trim().equals("")
                    && !alamat.trim().equals("") && !kategoriAnggotaId.equals("0")
                    && !keterangan.trim().equals("")) {
                pesan = "Berhasil mengedit anggota";
                try {
                    //konversi varibel idAnggota dari String ke Integer
                    //proses konversi bisa terjadi NumberOfException
                    Integer konIdAnggota = Integer.parseInt(idAnggota);
                    //konversi varibel kategoriAnggotaId dari String ke Integer
                    Integer konKatIdAnggota = Integer.parseInt(kategoriAnggotaId);
                    //Konsep Polimorphysme
                    KategoriAnggotaDao kategoriAnggotaDao = DBPerpustakaan.getKategoriAnggotaDao();
                    //panggil method getById dengan parameter konKatIdAnggota
                    kategoriAnggota = kategoriAnggotaDao.getById(konKatIdAnggota);
                    //Konsep polimorphysme
                    AnggotaDao anggotaDao = DBPerpustakaan.getAnggotaDao();
                    //buat objek anggota
                    Anggota anggota = new Anggota();
                    //set semua attribut yang ada di kelas Anggota
                    anggota.setNomorAnggota(nomorAnggota);
                    anggota.setNama(nama);
                    anggota.setNoIdentitas(noIdentitas);
                    anggota.setJenisIdentitas(jenisIdentitas);
                    anggota.setAlamat(alamat);
                    anggota.setKategoriAnggota(kategoriAnggota);
                    anggota.setKeterangan(keterangan);
                    //panggil method update
                    anggotaDao.Update(konIdAnggota, anggota);
                } catch (SQLException e) {
                    pesan = e.getMessage();
                } catch (Exception ex) {
                    pesan = ex.getMessage();
                }
            } else {
                pesan = "Gagal Mengedit Anggota, Harap Input Semua Data";
            }

        }
        request.setAttribute("msg2", pesan);

        return result;
    }
}
