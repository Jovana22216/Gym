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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jovana
 */
@MultipartConfig(maxFileSize = 161772716)
public class EditKorisnika extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");    
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            processRequest(request, response);
            Korisnik korisnik = new Korisnik();
            korisnik.setKorisnikId(Integer.parseInt(request.getParameter("korisnikId")));
            korisnik.setImeKorisnika(request.getParameter("imeKorisnika"));
            korisnik.setPrezimeKorisnika(request.getParameter("prezimeKorisnika"));
            korisnik.setKorisnickoIme(request.getParameter("korisnickoIme"));
            korisnik.setEmail(request.getParameter("email"));
            korisnik.setTelefonKorisnika(request.getParameter("telefonKorisnika"));
            korisnik.setAdresaKorisnika(request.getParameter("adresaKorisnika"));
            korisnik.setGradKorisnika(request.getParameter("gradKorisnika"));

            if(new  korisnikRepo().update(korisnik)){
                
                request.setAttribute("editKorisnika", "Uspesno ste izmenili podatke!");
                request.getRequestDispatcher("EditKorisnika.jsp").forward(request, response);
            }      
            } catch (SQLException ex) {
            Logger.getLogger(EditKorisnika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
