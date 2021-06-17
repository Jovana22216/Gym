package Controllers;

import Models.Korisnik;
import Models.Rezervacija;
import Models.Teretana;
import Models.Trening;
import RepoPattern.korisnikRepo;
import RepoPattern.rezervacijaRepo;
import RepoPattern.teretanaRepo;
import RepoPattern.treningRepo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jovana
 */
//@MultipartConfig(maxFileSize = 161772716)
public class KreiranjeRezervacije extends HttpServlet {

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

        try {  
            Rezervacija rezervacija = new Rezervacija();
            Trening trening = new treningRepo().select(request.getParameter("treningId"));
            Korisnik korisnik = new korisnikRepo().selectByUsername((String) request.getSession().getAttribute("ulogovan"));
            Teretana teretana = new teretanaRepo().select(request.getParameter("teretanaId"));

            rezervacija.setKorisnikId(korisnik.getKorisnikId());
            rezervacija.setTreningId(trening.getTreningId());
            rezervacija.setStatus(true);
            rezervacija.setTeretanaId(teretana.getTeretanaId());
            rezervacija.setPlaceno(false);
            try {

                if (new rezervacijaRepo().insert(rezervacija)) {
                    request.setAttribute("kreiranjeRez", "Uspesno ste kreirali rezervaciju!");
                request.getRequestDispatcher("pregledRezervacija.jsp").forward(request, response);
                
                } else {
                    response.sendRedirect("Greska.jsp");
                }

            } catch (SQLException ex) {
                Logger.getLogger(KreiranjeRezervacije.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KreiranjeRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
