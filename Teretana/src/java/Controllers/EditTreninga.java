/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Trening;
import RepoPattern.treningRepo;
import java.io.IOException;
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
public class EditTreninga extends HttpServlet {

   
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
        
        Trening trening = new Trening();
        trening.setTreningId(Integer.parseInt(request.getParameter("treningId")));
        trening.setDatum(request.getParameter("datum"));
        trening.setVreme(request.getParameter("vreme"));
        trening.setTrajanje(request.getParameter("trajanje"));
        trening.setOpis(request.getParameter("opis"));
        trening.setCena(Integer.parseInt(request.getParameter("cena")));
       
        try {
            if(new treningRepo().update(trening)){
                request.setAttribute("editTreninga", "Uspesno ste izmenili trening!");
                request.getRequestDispatcher("teretana.jsp").forward(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditTreninga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
