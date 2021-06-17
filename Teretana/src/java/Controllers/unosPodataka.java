/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Podaci;
import RepoPattern.podaciRepo;
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
public class unosPodataka extends HttpServlet {

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
            Podaci podaci = new  Podaci();
            podaci.setKorisnikId(Integer.parseInt(request.getParameter("korisnikId")));
            podaci.setZahtev(request.getParameter("zahtev"));
            podaci.setKilaza(Double.parseDouble(request.getParameter("kilaza")));
            podaci.setPritisak(request.getParameter("pritisak"));
            podaci.setAktivnost(request.getParameter("aktivnost"));
            podaci.setPol(request.getParameter("pol"));
           
           
            if(new podaciRepo().insert(podaci)){
               request.setAttribute("unosP", "Uspesno ste uneli podatke!");
                request.getRequestDispatcher("program.jsp").forward(request, response);
                
            }
            else{
                
                response.sendRedirect("index.jsp");
            }
        }catch(Exception  ex){
              response.sendRedirect("index.jsp");
        }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
