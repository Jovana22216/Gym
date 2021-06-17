<%-- 
    Document   : EditTeretane
    Created on : Jul 25, 2020, 6:31:19 PM
    Author     : Jovana
--%>



<%@page import="Models.Teretana"%>
<%@page import="RepoPattern.teretanaRepo"%>
<%@page import="Models.Korisnik"%>
<%@page import="RepoPattern.korisnikRepo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body style=" color:white; font-weight: bold">
        <%@ include file="navbar.jsp" %>  
  <% 
            String id = request.getParameter("teretanaId");
            Teretana teretana = new teretanaRepo().select(id);
            
      
        %>
       <div  align="center" style="margin-top: 2%" >
         <form   action="EditTeretane" method="post" enctype="multipart/form-data" style=" width: 440px; background: rgba(0,0,0,0.5); ">
           <input value="<%= request.getParameter("teretanaId")%>" name="teretanaId" type="hidden">
          <div style="padding-left:3%; ">
                <h1>Izmena podataka o Teretani</h1>
              <table style="margin-top: -35%; text-align: right; display:inline-block">
               <tr>
                 <div class="form-inline">
                  <td style="padding-top:2%"><label>Naziv: </label></td>
                  <td style="padding-left:2%"><input required type="text" class="form-control" placeholder="nazivTeretane" value="<%= teretana.getNazivTeretane()%>" name="nazivTeretane"></td>
                  <div class="invalid-feedback">Morate uneti  naziv</div>
                 </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Telefon </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input minLength="6"  maxLength="10" required type="text" class="form-control" placeholder="telefonTeretane" value="<%= teretana.getTelefonTeretane()%>"  name="telefonTeretane"></td>
                </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Adresa </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="Adresa" value="<%= teretana.getAdresaTeretane()%>"  name="adresaTeretane"></td>
                </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Grad</label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="grad" value="<%= teretana.getGrad()%>" name="grad"></td>
                </div>
               </tr>
               <br>
                <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Email  </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="email" value="<%=teretana.getEmail()%>"  name="email"></td>
                </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Opis: </label></td>
                    <td style="padding-top:6%; padding-left:2%"><textarea name="opis" rows="4" cols="42"><%=teretana.getOpis()%></textarea></td>
                </div>
               </tr>
               <br>
              
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Fotografija: </label></td>
                    <td style="padding-top:6%; padding-left:2%">
                        <img height="180px" width="286px" src="FotografijeTeretane.jsp?teretanaId=<%=teretana.getTeretanaId()%>" /> 
                        <input type="file" class="form-control" placeholder="Fotografija" value="<%= teretana.getFotografija()%>"  name="file"></td>
                </div>
               </tr>
               <br>
               <tr>
             
              </table> <br><br>
              <div >
               <input type="submit" value ="Izmeni" class="btn btn-success" style=" background-color:darkgreen; margin-left: 0%;">
               <form action="BrisanjeTeretane" method="post">
                  <a class="delete_link btn btn-danger btn-large"  
                                    href="${pageContext.request.contextPath}/BrisanjeTeretane?teretanaId=<%=id %>" >
                                   <i class="fa fa-trash"> Obriši</i>                                  
                  </a>
               </form>
              </div>
           </div>
         </form>

         </div>

        </body>
  </html>
