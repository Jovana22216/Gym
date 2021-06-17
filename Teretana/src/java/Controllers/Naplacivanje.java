/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.KreditnaKartica;
import Models.Rezervacija;
import RepoPattern.rezervacijaRepo;
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
public class Naplacivanje extends HttpServlet {
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
        processRequest(request, response);
    
        KreditnaKartica kreditnaKartica = new KreditnaKartica();
        kreditnaKartica.setVrstaKartice(request.getParameter("VrstaKartice"));
        kreditnaKartica.setBrojKartice(request.getParameter("BrojKartice"));
        kreditnaKartica.setDatumIstekaMesec(Integer.parseInt(request.getParameter("DatumIstekaMesec")));
        kreditnaKartica.setDatumIstekaGodina(Integer.parseInt(request.getParameter("DatumIstekaGodina")));

        
        Rezervacija rezervacija = new Rezervacija();

        rezervacija.setRezervacijaId(Integer.parseInt(request.getParameter("rezervacijaId")));
        rezervacija.setPlaceno(true);

      try {
            if (new rezervacijaRepo().updateRezervacije(rezervacija)) {
                request.setAttribute("naplata", "Uspesno ste platili trening!");
                request.getRequestDispatcher("pregledRezervacija.jsp").forward(request, response);

            } 
            else{
                request.setAttribute("naplata", "Greska prilikom placanja");
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Naplacivanje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
