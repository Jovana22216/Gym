/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Trening;
import RepoPattern.treningRepo;
import java.io.IOException;
import java.io.PrintWriter;
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
public class KreiranjeTreninga extends HttpServlet {

   
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
            Trening trening = new  Trening();
            
            trening.setTeretanaId(Integer.parseInt(request.getParameter("teretanaId")));
            trening.setDatum(request.getParameter("datum"));
            trening.setVreme(request.getParameter("vreme"));
            trening.setTrajanje(request.getParameter("trajanje")); 
            trening.setOpis(request.getParameter("opis"));
            trening.setCena(Integer.parseInt(request.getParameter("cena")));
       

            if(new treningRepo().insert(trening)){
                  request.setAttribute("kreiranjeTreninga", "Uspesno ste kreirali trening!");
                request.getRequestDispatcher("teretana.jsp").forward(request, response);
                
            }
            else{
                response.sendRedirect("index.jsp");
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
