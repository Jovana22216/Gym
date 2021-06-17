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
import javax.servlet.http.HttpSession;
/**
 *
 * @author Jovana
 */
public class Registracija extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            Korisnik korisnik = new Korisnik();
            korisnik.setImeKorisnika(request.getParameter("imeKorisnika"));
            korisnik.setPrezimeKorisnika(request.getParameter("prezimeKorisnika"));
            korisnik.setKorisnickoIme(request.getParameter("korisnickoIme"));
            korisnik.setSifra(request.getParameter("sifra"));
            korisnik.setEmail(request.getParameter("email"));
            korisnik.setTelefonKorisnika(request.getParameter("telefonKorisnika"));
            korisnik.setAdresaKorisnika(request.getParameter("adresaKorisnika"));
            korisnik.setGradKorisnika(request.getParameter("gradKorisnika"));

            
            if(new korisnikRepo().insert(korisnik)){
                request.setAttribute("rezultat", "True");
                request.getRequestDispatcher("Registracija.jsp").forward(request, response);
                HttpSession sesija = request.getSession();
                sesija.setAttribute("ulogovan", korisnik.getKorisnickoIme());
                sesija.setAttribute("UlogovanaRola", "3");
                 }
            else{
                request.setAttribute("rezultat", "False");
                request.getRequestDispatcher("Registracija.jsp").forward(request, response);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Registracija.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
