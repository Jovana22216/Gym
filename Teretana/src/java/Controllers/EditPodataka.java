/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Podaci;
import Models.Trening;
import RepoPattern.podaciRepo;
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
public class EditPodataka extends HttpServlet {

    
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
        
          Podaci podaci = new Podaci();
        podaci.setPodatakId(Integer.parseInt(request.getParameter("podatakId")));
        podaci.setZahtev(request.getParameter("zahtev"));
        podaci.setKilaza(Double.parseDouble(request.getParameter("kilaza")));
        podaci.setPritisak(request.getParameter("pritisak"));
        podaci.setAktivnost(request.getParameter("aktivnost"));
        podaci.setPol(request.getParameter("pol"));
       
        try {
            if(new podaciRepo().update(podaci)){
               request.setAttribute("editPodataka", "Uspesno ste izmenili podatke!");
                request.getRequestDispatcher("program.jsp").forward(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditPodataka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
