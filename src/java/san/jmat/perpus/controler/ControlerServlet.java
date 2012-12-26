/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.controler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import san.jmat.perpus.action.ActionInterface;

/**
 *
 * @author joker
 */
public class ControlerServlet extends HttpServlet {
    //Kelas Properties
    Properties properties = null;
    //ReuestDispatcher 
    //Untuk mengalihkan respon
    RequestDispatcher requestDispatcher = null;
    
    //Override method 
    @Override   
                                            //tangkap Exception
    public void init(ServletConfig config) throws ServletException {
        try {
            //Buat objek dari kelas Properties
            properties = new Properties();
            //Baca file pada direktori san.jmat.perpus.mapping
            //Akan menghasilkan Exception
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("/san/jmat/perpus/mapping/conf.properties");
            //lalu di load
            properties.load(in);
            
        } catch (IOException ex) {
            //Tanganni Exception
            System.err.println("file to read file "+ex.getMessage());
        }
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Deklarasi variabel untuk mendetksi dimana
        //direktori yang menyimpan file kelas yang mengimplentasi 
        //ActionInterface
        String urlPath = request.getParameter("/san/jmat/perpus/action");
                                    //Dari Objek dikonversi keString
        String reqHelperClassName = (String) properties.get(urlPath);
        
        //reqHelperClassName harus ada isinya tidak boleh null
        if (reqHelperClassName != null) {
            try{
                ActionInterface helper=(ActionInterface) Class.forName(reqHelperClassName).newInstance();
                String nextView=helper.execute(request);
                if(!nextView.contains("controler")){
                    nextView="/WEB-INF/page/"+nextView;
                }
                requestDispatcher=request.getRequestDispatcher(nextView);
                requestDispatcher.forward(request, response);
            }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e){
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
