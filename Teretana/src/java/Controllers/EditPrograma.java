package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Models.Program;
import RepoPattern.programRepo;
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
public class EditPrograma extends HttpServlet {

  
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
        
        Program program = new Program();
        program.setProgramId(Integer.parseInt(request.getParameter("programId")));
        program.setNazivPrograma(request.getParameter("nazivPrograma"));
        program.setOpis(request.getParameter("opis"));
        program.setCena(Double.parseDouble(request.getParameter("cena")));
        program.setTrajanje(request.getParameter("trajanje"));
        
       

        
        try {
            if(new programRepo().update(program)){
                request.setAttribute("editPrograma", "Uspesno ste izmenili program!");
                request.getRequestDispatcher("program.jsp").forward(request, response);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EditPrograma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
