/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Program;
import RepoPattern.programRepo;
import java.io.IOException;
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
public class KreiranjePrograma extends HttpServlet {


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
            Program program = new  Program();
            program.setNazivPrograma(request.getParameter("nazivPrograma"));
            program.setOpis(request.getParameter("opis"));
            program.setCena(Double.parseDouble(request.getParameter("cena")));
            program.setTrajanje(request.getParameter("trajanje"));
           
            

            if(new programRepo().insert(program)){
                request.setAttribute("kreiranjeProg", "Uspesno ste kreirali program!");
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
