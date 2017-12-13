/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmbalance;

import atm.model.Account;
import atm.controller.Controller;
import examples.Logging.Logit;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.quickconnectfamily.json.JSONUtilities;

/**
 *
 * @author neldo
 */
@WebServlet(name = "ATMBalanceServlet", urlPatterns = {"/ATMBalanceServlet"})
public class ATMBalanceServlet extends HttpServlet {

    
    
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
                Account tmpAccount = new Account();
        try (PrintWriter out = response.getWriter()) {
            
            try{
                //Read the JSON from the parameters
                String _content = request.getParameter("q");
                
                //Controller
                Controller c = new Controller();
                
                
                String jsonacc = c.login("11111","11111");
                out.println("Account Found:>>" + jsonacc + "</br>");
                //out.println("Account Deposit:>>" + c.depositFunds(jsonacc, 100) + "</br>");
                //out.println("Account Withdrawn:>>" + c.withdrawalFunds(jsonacc, 100) + "</br>");
                out.println("Account Balance:>>" + c.getBalance(jsonacc) + "</br>");
                
            /* write the JSON back to the client. */
            //out.println(JSONUtilities.stringify(tmpAccount));
            
            }catch(Exception ex)
            {
                //System.out.println(ex.getMessage());
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
