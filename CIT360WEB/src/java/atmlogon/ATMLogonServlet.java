/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmlogon;

import atm.model.Account;
import atm.controller.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quickconnectfamily.json.JSONUtilities;

/**
 *
 * @author neldo
 */
@WebServlet(name = "ATMLogonServlet", urlPatterns = {"/ATMLogonServlet"})
public class ATMLogonServlet extends HttpServlet {

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
            try{
                //Read the JSON from the parameters
                //String a = request.getParameter("a");
                //String p = request.getParameter("p");
                
                StringBuilder sb = new StringBuilder();
                BufferedReader br = request.getReader();
                String str;
                while((str = br.readLine()) != null){
                    sb.append(str);
                }
                str = URLDecoder.decode(sb.toString(), "UTF-8");
                
            //Convert the JSON string to an object
            Account account = new Account((HashMap)JSONUtilities.parse(str));
            
                //Controller
                Controller c = new Controller();
                
                //out.println(""+":"+p);
                out.println(c.login(account.getAccountNumber(),account.getPinCode()));
                
            /* write the JSON back to the client. */
            //out.println(JSONUtilities.stringify(tmpAccount));
            
            }catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        
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
