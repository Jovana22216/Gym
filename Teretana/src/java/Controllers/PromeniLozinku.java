/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Korisnik;
import RepoPattern.korisnikRepo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jovana
 */
public class PromeniLozinku extends HttpServlet {

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
        
         try {
             processRequest(request, response);
            String staraLozinka = request.getParameter("StaraLozinka");
            String novaLozinka = request.getParameter("NovaLozinka");
            Korisnik ulogovanKorisnik = new korisnikRepo().selectByUsername((String)request.getSession().getAttribute("ulogovan"));
            
            if(new korisnikRepo().promenaLozinke(ulogovanKorisnik.getKorisnickoIme(), staraLozinka, novaLozinka)){
               request.setAttribute("lozinka", "Uspesno ste promenili lozinku!");
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                //request.setAttribute("Promena", "True");
                request.getRequestDispatcher("profil.jsp?korisnikId=" + ulogovanKorisnik.getKorisnikId()).forward(request, response);   
            }
            else{
                request.setAttribute("lozinka", "Greska!");
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                //request.setAttribute("Promena", "False");
                request.getRequestDispatcher("profil.jsp?korisnikId=" + ulogovanKorisnik.getKorisnikId()).forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PromeniLozinku.class.getName()).log(Level.SEVERE, null, ex);
        }  
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
