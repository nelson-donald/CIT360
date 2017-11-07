/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortana;

import examples.Logging.Logit;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quickconnectfamily.json.JSONUtilities;

/**
 *
 * @author neldo
 */
public class HelloWorldServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cortana</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");           
            out.println("</head>");
            out.println("<body>");
            out.println("<fieldset><div class=\"cortana\"><legend>Cortana</legend>");
            out.println("<img class=\"thumbnail\" src=\"http://cdn.dribbble.com/users/289910/screenshots/1714369/cortanagif.gif\" /><p>Hello there <b>"+request.getParameter("q")+"</b>. It's nice to meet you.</p>");
            out.println("<p>I've pulled up the latest news for you</p></div></fieldset>");  
            
            
//================================================================================
//HttpURLConnection & JSON - to get the latest news from ABC
//================================================================================
            StringBuilder content = new StringBuilder();
            URL url = new URL("http://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Fabcnews.go.com%2Fabcnews%2Ftopstories");
            
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            
            try{
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                
                String line;
                
                while((line = bufferedReader.readLine()) != null){
                    content.append(line).append("\n");
                }
                
            HashMap hm = (HashMap)JSONUtilities.parse(content.toString());
            
//================================================================================
//This will generate the HTML for each news article
//================================================================================
            ABC abc = new ABC(hm);
            for(Item i : abc.getItems()){
                
                out.println(news(i));
            }
            }
            catch(Exception ex)
            {
                Logit.error(ex.getMessage());
            }
            finally{
                
                urlConnection.disconnect();
            }
            
            out.println("</body>");
            out.println("</html>");
                        
                        
        }
    }

//================================================================================
//private methods
//================================================================================
    private String news(Item item){
        String result = "";
        result+="<div class=\"news\">";
        result+="<h1>"+item.getTitle()+"</h1>";
        result+="<img class=\"thumbnail\" src=\"" + item.getThumbnail() + "\" />";
        result+="<p>"+item.getDescription()+"</p>";
        result+="<p><a href=\""+item.getLink()+"\">"+item.getLink()+"</a></p>";
        result+="</div>";
        return result;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
