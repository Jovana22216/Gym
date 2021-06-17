/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Teretana;
import RepoPattern.teretanaRepo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Jovana
 */
@MultipartConfig(maxFileSize = 161772716)
public class EditTeretane extends HttpServlet {

    
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
        
        Teretana teretana = new Teretana();
        teretana.setTeretanaId(Integer.parseInt(request.getParameter("teretanaId")));
        teretana.setNazivTeretane(request.getParameter("nazivTeretane"));
        teretana.setTelefonTeretane(request.getParameter("telefonTeretane"));
        teretana.setAdresaTeretane(request.getParameter("adresaTeretane"));
        teretana.setGrad(request.getParameter("grad"));
        teretana.setEmail(request.getParameter("email"));
        teretana.setOpis(request.getParameter("opis"));
       
        Part part = request.getPart("file");
        
        try {
            if(new teretanaRepo().update(teretana, part)){
                request.setAttribute("editTeretane", "Uspesno ste izmenili teretanu!");
                request.getRequestDispatcher("teretana.jsp").forward(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditTeretane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
