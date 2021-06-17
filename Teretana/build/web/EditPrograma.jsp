<%-- 
    Document   : EditPrograma
    Created on : Aug 4, 2020, 6:25:19 PM
    Author     : Jovana
--%>

<%@page import="RepoPattern.programRepo"%>
<%@page import="Models.Program"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body style=" color:white; font-weight: bold">
        <%@ include file="navbar.jsp" %>  
        <%      if (request.getSession().getAttribute("UlogovanaRola") != null) {
                if (!(request.getSession().getAttribute("UlogovanaRola").equals("1"))) {
                    response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
            String id = request.getParameter("programId");
            Program program = new programRepo().select(id);


        %>
       <div  align="center" style="margin-top: 2%" >
                <form   action="EditPrograma" method="post" enctype="multipart/form-data" style=" width: 380px; background: rgba(0,0,0,0.5); ">
                    <input value="<%= request.getParameter("programId")%>" name="programId" type="hidden">
                   <div style="padding-left:3%; ">
                       <h1>Izmena podataka o Programu</h1>
                        <table style="margin-top: -14%; text-align: right; display:inline-block">
                            <tr>   
                            <div class="form-inline">
                                <td style="padding-top:9%"><label> Naziv: </label></td>
                                <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="nazivPrograma" value="<%= program.getNazivPrograma()%>"  name="nazivPrograma"></td>
                            </div>
                            </tr>
                             <br>
                             <tr>
                            <div class="form-inline">
                               
                               <td style="padding-top:9%"><label>Opis:  </label></td>
                                 <td style="padding-top:6%; padding-left:2%"><textarea required name="opis" rows="4" cols="30"><%=program.getOpis()%></textarea></td>

                            </div>
                            </tr>
                            <br>
                            <tr>
                            <div class="form-inline">
                                <td style="padding-top:9%"><label> Cena: </label></td>
                                <td style="padding-top:6%; padding-left:2%"><input required minLength="2"  maxLength="4" required type="text" class="form-control" placeholder="cena" value="<%= program.getCena()%>" name="cena"></td>
                            </div>
                            </tr>
                            <br>
                            <tr>
                            <div class="form-inline">
                                <td style="padding-top:9%"><label> Trajanje: </label></td>
                                <td style="padding-top:6%; padding-left:2%"><input required minLength="2"  maxLength="3" type="text" class="form-control" placeholder="trajanje" value="<%= program.getTrajanje()%>"  name="trajanje"></td>
                            </div>

                            
                            </tr>

                        </table> <br><br>
                        <input type="submit" value ="Izmeni" class="btn btn-success" style=" background-color:darkgreen; margin-left: 0%; ">
                       
                        <form action="BrisanjePrograma" method="post">
                            <a class="delete_link btn btn-danger btn-large"  
                               href="${pageContext.request.contextPath}/BrisanjePrograma?programId=<%=id%>" >
                                <i class="fa fa-trash"> Obriši</i>                                  
                            </a>
                        </form>
                    </div>
                </form>

            </div>
       
    </body>
</html>
