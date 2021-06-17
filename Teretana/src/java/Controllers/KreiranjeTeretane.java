/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Teretana;
import RepoPattern.teretanaRepo;
import java.io.IOException;
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
public class KreiranjeTeretane extends HttpServlet {

  
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
        
        try{
            Teretana teretana = new  Teretana();
            
            teretana.setNazivTeretane(request.getParameter("nazivTeretane"));
            teretana.setTelefonTeretane(request.getParameter("telefonTeretane"));
            teretana.setAdresaTeretane(request.getParameter("adresaTeretane")); 
            teretana.setGrad(request.getParameter("grad"));
            teretana.setEmail(request.getParameter("email"));
            teretana.setOpis(request.getParameter("opis"));
            //klasa koja pomaze  za insert fotografije u bazu
            Part part = request.getPart("fotografija");
           

            if(new teretanaRepo().insert(teretana, part)){
                    request.setAttribute("kreiranjeTeretane", "Uspesno ste kreirali teretanu!");
                request.getRequestDispatcher("teretana.jsp").forward(request, response);
                
            }
            else{
                response.sendRedirect("Greska.jsp");
            }
        }catch(Exception  ex){
             response.sendRedirect("Greska.jsp");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
