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
 *Interface ActionInterface
 * Interface inti agar kelas yang mengimplementasi interface ini
 * bisa mengoverdding method execute 
 * @author joker
 */
public interface ActionInterface {

    //method ini berparameter intercafe HttpServletRequest 
    public String execute(HttpServletRequest request);
}
