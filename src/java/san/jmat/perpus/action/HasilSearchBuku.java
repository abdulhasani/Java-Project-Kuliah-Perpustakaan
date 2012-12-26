/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import san.jmat.perpus.dao.service.BukuDao;
import san.jmat.perpus.dao.service.KategoriBukuDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.Buku;
import san.jmat.perpus.entity.KategoriBuku;

/**
 *
 * @author joker
 */
public class HasilSearchBuku implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String pesan = null;
        String judulBuku;
        String pengarang;
        String penerbit;
        String tahunTerbit;
        String jspFile = null;
        List<Buku> listBuku;
        List<KategoriBuku> ktgBuku;
        listBuku = new ArrayList<>();
        ktgBuku = new ArrayList<>();
        judulBuku = request.getParameter("judulBuku");
        pengarang = request.getParameter("pengarang");
        penerbit = request.getParameter("penerbit");
        tahunTerbit = request.getParameter("tahunTerbit");

        try {
            KategoriBukuDao kategoriBukuDao = DBPerpustakaan.getKategoriBukuDao();
            ktgBuku = kategoriBukuDao.selectAll();
        } catch (SQLException ex) {
            Logger.getLogger(HasilSearchBuku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
        }
        if (judulBuku.trim().equals("") && pengarang.trim().equals("")) {
            pesan = "Judul Buku dan Pengarang Masih Kosong";
            jspFile = "SearchBuku.jsp";
        } else if (judulBuku.trim().equals("")) {
            pesan = "Judul Buku Masih Kosong";
            jspFile = "SearchBuku.jsp";
        } else if (pengarang.trim().equals("")) {
            pesan = "Pengarang Masih Kosong";
            jspFile = "SearchBuku.jsp";
        } else {
            try {
                BukuDao bukuDao = DBPerpustakaan.getBukuDao();
                listBuku = bukuDao.Filter(judulBuku, pengarang, penerbit, tahunTerbit);
                jspFile = "HasilSearchBuku.jsp";
                if(listBuku.isEmpty()){
                    pesan=null;
                }else{
                    pesan="DAFTAR BUKU YANG ANDA CARI";
                }
            } catch (SQLException ex) {
                Logger.getLogger(HasilSearchBuku.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                Logger.getLogger(HasilSearchBuku.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        request.setAttribute("msg", pesan);
        request.setAttribute("categorys", ktgBuku);
        request.setAttribute("buku", listBuku);
        return jspFile;
    }
}
