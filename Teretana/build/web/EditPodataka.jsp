<%-- 
    Document   : EditPodataka
    Created on : Sep 18, 2020, 2:59:29 PM
    Author     : Jovana
--%>

<%@page import="Models.Podaci"%>
<%@page import="RepoPattern.podaciRepo"%>
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
            request.setAttribute("Podaci", new podaciRepo().select(request.getParameter("podatakId")));
           String ulogovanaRola ="";
            if( request.getSession().getAttribute("UlogovanaRola")!=null)
                ulogovanaRola =(String) request.getSession().getAttribute("UlogovanaRola");
            Podaci podaci = (Podaci) request.getAttribute("Podaci");{
        %>
        <div  align="center" style="margin-top: 2%" >
         <form   action="EditPodataka" method="post" enctype="multipart/form-data" style=" width: 380px; background: rgba(0,0,0,0.5); ">
           <input value="<%= request.getParameter("podatakId")%>" name="podatakId" type="hidden">
           <div style="padding-left:3%; ">
                <h1>Izmena Podataka</h1>
             <table style="margin-top: -30%; text-align: right; display:inline-block">
               <tr>
                 <div class="form-inline">
                  <td style="padding-top:2%"><label>Zahtev:  </label></td>
                  <td style="padding-left:2%"><select  class="form-control" name="zahtev">
                          
                          <option value="rekreacija">Rekreacija</option>
                            <option value="mrsavljenje">Mrsavljenje</option>
                            <option value="zatezanje">Zatezanje</option>
                            <option value="treniranje">Body Builder</option>
                        </select></td></div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Težina </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required minLength="2"  maxLength="3" type="text" class="form-control" placeholder="kilaza" value="<%= podaci.getKilaza()%>"  name="kilaza"></td>
                </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Pritisak:  </label></td>
                     <td style="padding-top:6%; padding-left:2%"><select  class="form-control" name="pritisak">
                          
                             <option value="visok">Visok</option>
                            <option value="normalan">Normalan</option>
                            <option value="nizak">Nizak</option>
                        </select></td> </div>
               </tr>
               <br>
               <br>
               <br>
                <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Aktivnost:  </label></td>
                     <td style="padding-top:6%; padding-left:2%"><select  class="form-control" name="aktivnost">
                            
                             <option value="aktivan">Aktivan</option>
                            <option value="povremeno">Povremeno</option>
                            <option value="neaktivan">Neaktivan</option>
                        </select></td>
                </div>
               </tr>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Pol: </label></td>
                    <td style="padding-top:6%; padding-left:2%"><select  class="form-control" name="pol">
                           
                            <option value="musko">Musko</option>
                            <option value="zensko">Zensko</option>
                        </select></td></div>
               </tr>
               
               <br>
               <tr>
             
              </table> <br><br>
               <input type="submit" value ="Izmeni" class="btn btn-success" style=" background-color:darkgreen; margin-left:0%;">
               <form action="BrisanjePodataka" method="post">
                  <a class="delete_link btn btn-danger btn-large"  
                                    href="${pageContext.request.contextPath}/BrisanjePodataka?podatakId=<%=podaci.getPodatakId()%>" >
                                   <i class="fa fa-trash"> Obriši</i>                                  
                  </a>
               </form>
           </div>
        </form>
       
         </div>
                   <% }
%>              
    </body>
</html>
