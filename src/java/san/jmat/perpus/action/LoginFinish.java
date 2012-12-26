/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public class LoginFinish implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");

        session.removeAttribute("login");
        session.removeAttribute("keranjang");
        session.removeAttribute("itemKeranjang");
        session.removeAttribute("tgl");
        session.removeAttribute("bln");
        session.removeAttribute("thn");
        return "home.jsp";
    }
}
