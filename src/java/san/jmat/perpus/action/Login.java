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
import san.jmat.perpus.dao.service.UserDao;
import san.jmat.perpus.dbUtil.DBPerpustakaan;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class Login implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        //deklarasi dan inisialisasi variabel userName
        String userName = request.getParameter("userName");
        //deklarasi dan inisialisasi variabel password
        String password = request.getParameter("password");
        //deklarasi dan inisialisasi variabel fileJsp
        String fileJsp = "home.jsp";
        //deklarasi dan inisialisasi variabel pesan
        String pesan = null;
        //jika variabel userName tidak diisi atau cuman diisi sepasi dan 
        //jika password tidak diisi atau cuman diisi sepasi 
        //maka syarat if terpenuhi jika tidak masuk ke else if 
        if (userName.trim().equals("") && password.trim().equals("")) {
            pesan = "Username dan Password masih kosong";
        }
        //jika userName diisi spasi atau diisi kosong maka syarat terpenuhi
        //jika tidak pernuhi baca else if dibawahnya
        else if (userName.trim().equals("")) {
            pesan = "Username masih kosong";
        }
        //jika password diisi spasi atau diisi kosong maka syarat terpenuhi
        //jika tidak pernuhi baca else if dibawahnya
        else if (password.trim().equals("")) {
            pesan = "Password masih kosong";
        } 
        //jika If dan else if diatas syarat2nya tidak terpenuhi semua
        //maka akan ditangani else if ini
        else {
            try {
                //Konsep Polimorphysme
                UserDao userDao = DBPerpustakaan.getUserDao();
                //panggil method Login
                //return value method Login berupa Objek dari kelas 
                //User
                User Login = userDao.Login(userName, password);
                //jika varibel Login berisi objek 
                //maka otomatis tidak sama dengan null syarat if terpenuhi
                if (Login != null) {
                    //Inti dari validasi
                    //sama kan user name dan password yang diinputkan dengan
                    //user name dan password yang disimpan di database
                    if (Login.getUserName().equals(userName)
                            && Login.getPassword().equals(password)) {
                        //jika syrat if terpenuhi maka disini
                        //buat session 
                        HttpSession session = request.getSession(true);
                        session.setAttribute("login", Login);
                        //inisailisasi fileJsp
                        fileJsp = "loginAdmin.jsp";
                    }
                    //Jika user name dan password yang diinputkan 
                    //tidak sama dengan di database baca else 
                    else {
                        pesan = "Cek Username dan Password";
                    }
                }
                //jika varibel Login berisi null
                //mengapa bernilai null
                //karena username maupun password yang diinput tidak ada di
                //database dalam artian prosess search tidak ditemukan
                else {
                    pesan = "Cek Username dan Password";
                }

            } catch (SQLException e) {
                
            } catch (Exception e) {
                
            }
        }
        //set attribut untuk menampilkasn pesan jika 
        //proses login gagal
        request.setAttribute("msg", pesan);
        //return fileJsp
        return fileJsp;
    }
}
