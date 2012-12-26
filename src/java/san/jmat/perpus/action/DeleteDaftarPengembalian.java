/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.dao.service.PengembalianDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class DeleteDaftarPengembalian implements ActionInterface{

    @Override
    public String execute(HttpServletRequest request) {
        String result=null;
        String pesan=null;
        String idPengembalian=request.getParameter("id");
        String konfirmasi2=request.getParameter("hapus");
        HttpSession session;
        session = request.getSession(true);
        User user;
        user = (User) session.getAttribute("login");
        if(user!=null){
            result="controler?/san/jmat/perpus/action=daftarPengembalian";
            if(idPengembalian!=null){
                
                if(!idPengembalian.trim().equals("")){
                    try {
                        Long id=Long.parseLong(idPengembalian);
                        PengembalianDao pengembalianDao=DBPerpustakaan.getPengembalianDao();
                        pengembalianDao.delete(id);
                        pesan="<font color=\"red\"><strong>Proses Delete Berhasil</strong></font>";
                    } catch (SQLException ex) {
                        Logger.getLogger(DeleteDaftarPengembalian.class.getName()).log(Level.SEVERE, null, ex);
                    }catch(Exception x){
                        
                    }
                }
            }
            //Delete All jalankan
            else if(konfirmasi2!=null){
                if(!konfirmasi2.trim().equals("")){
                    try {
                        PengembalianDao pengembalianDao=DBPerpustakaan.getPengembalianDao();
                        pengembalianDao.deleteAll();
                    } catch (SQLException ex) {
                        pesan="Tidak Ada Data";
                    }catch(Exception e){
                        
                    }
                }
            }
            //Delete All Komfirmasi
            else{
                pesan="<font color=\"red\"><strong>Hapus Semua Data ?</strong></font>&nbsp;&nbsp;<a href=\"controler?/san/jmat/perpus/action=deleteDaftarPengembalian&hapus=YES\" >YES</a>";
            }
        }else{
            result="home.jsp";
        }
        request.setAttribute("msg2", pesan);
        return result;
    }
    
}
