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
public class HomeAdmin implements ActionInterface {

    @Override
    public String execute(HttpServletRequest request) {
        String result = null;
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("login");
        if (user != null) {
            result="loginAdmin.jsp";
        }else{
            result="controler?/san/jmat/perpus/action=home";
        }
        return result;
    }
}
