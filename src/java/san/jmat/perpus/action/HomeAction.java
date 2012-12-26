/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.action;

import javax.servlet.http.HttpServletRequest;

/**
 *Kelas HomeAction 
 * Mengimplentasi interface ActionInterface
 * @author joker
 */
public class HomeAction implements ActionInterface{

    //Override methode
    @Override
    public String execute(HttpServletRequest request) {
         
         return "home.jsp";
    }
    
}
