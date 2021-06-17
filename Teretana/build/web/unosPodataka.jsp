

<%-- 
    Document   : unosPodataka
    Created on : Sep 12, 2020, 5:58:34 PM
    Author     : Jovana
--%>
<%@page import="Models.Korisnik"%>
<%@page import="Models.Podaci"%>
<%@page import="Models.Trening"%>
<%@page import="RepoPattern.podaciRepo"%>
<%@page import="RepoPattern.rezervacijaRepo"%>
<%@page import="Models.Rezervacija"%>
<%@page import="RepoPattern.treningRepo"%>

<%@page import="RepoPattern.korisnikRepo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unos Podataka</title>

    </head>

    <body>

        <%@ include file="navbar.jsp" %> 
        <%     String ulogovanaRola = "";
                                if (request.getSession().getAttribute("UlogovanaRola") != null) {
                                    ulogovanaRola = "" + request.getSession().getAttribute("UlogovanaRola");
                                }

                                Korisnik korisnik = new korisnikRepo().selectByUsername("" + request.getSession().getAttribute("ulogovan"));
                              Podaci podaci = new podaciRepo().select(request.getParameter("podatakId"));
           
        %>
        <form action="unosPodataka" method="post" enctype="multipart/form-data" style=" background-color:darkgreen; margin: 2% 37%; width: 25rem; background: rgba(0,0,0,0.5); color: white;" align="center">
           <h2 align="center">Unesite podatke</h2>
           
            <table  cellpadding="20px">
                 <input value="<%=korisnik.getKorisnikId()%>" name="korisnikId" type="hidden"> 
                    <td>Potrebe treniranja:  </td>
                    <td style="padding-top:6%; padding-left:2%"><select  class="form-control" name="zahtev">
                            <option value="rekreacija">Rekreacija</option>
                            <option value="mrsavljenje">Mrsavljenje</option>
                            <option value="zatezanje">Zatezanje</option>
                            <option value="treniranje">Body Builder</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Težina: </td>
                    <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 1 karaktera')" class="form-control" required minLength="2" maxlength="3" type="text" name="kilaza"></td>
                </tr>
               <tr>
                    <td>Pritisak: </td>
                    <td style="padding-top:6%; padding-left:2%"><select  class="form-control" name="pritisak">
                            <option value="visok">Visok</option>
                            <option value="normalan">Normalan</option>
                            <option value="nizak">Nizak</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Koliko ste aktivni: </td>
                    <td style="padding-top:6%; padding-left:2%"><select  class="form-control" name="aktivnost">
                            <option value="aktivan">Aktivan</option>
                            <option value="povremeno">Povremeno</option>
                            <option value="neaktivan">Neaktivan</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Pol: </td>
                    <td style="padding-top:6%; padding-left:2%"><select  class="form-control" name="pol">
                            <option value="musko">Musko</option>
                            <option value="zensko">Zensko</option>
                        </select></td>
                </tr>

              

                   </table><br>
              <%--     <a href="${pageContext.request.contextPath}/ProgramiKorisnika.jsp?podatakId=<%=podaci.getPodatakId()%>" class="btn btn-success">Unesi</a>
                 --%> 
           <input type="submit" value="Unesi" class="btn btn-success" style="width: 5rem; margin-bottom: 1rem; background-color: #17a2b8">
     </form>

    </body>

</html>
