<%-- 
    Document   : rezervisi
    Created on : Aug 19, 2020, 8:35:28 PM
    Author     : Jovana
--%>


<%@page import="RepoPattern.teretanaRepo"%>
<%@page import="Models.Teretana"%>
<%@page import="RepoPattern.rezervacijaRepo"%>
<%@page import="Models.Rezervacija"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Trening"%>
<%@page import="RepoPattern.treningRepo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rezervisanje treninga</title>
    </head>
    <body>
        <%
            ArrayList<Rezervacija> aktivneRezervacije = new rezervacijaRepo().aktivneRezervacije(request.getParameter("treningId"));
        %>

        <%@ include file="navbar.jsp" %> 

        <form action = "KreiranjeRezervacije" method="post" >
            <div style=" margin-left:5%">
                <div class="row">
                    <div class="span6" style="margin-top: 7%">

                    </div>

                    <div class="jumbotron" style="margin-bottom:  30%; border-radius: 0px; margin-top: 4.5%; background: rgba(0,0,0,0.5); ">
                        <div class="span6" style="margin-bottom:  30%">
                            <%  
                                Trening trening = new treningRepo().select(request.getParameter("treningId"));
                                String ulogovanaRola = "";
                                if (request.getSession().getAttribute("UlogovanaRola") != null) {
                                    ulogovanaRola = "" + request.getSession().getAttribute("UlogovanaRola");
                                }

                                Korisnik korisnik = new korisnikRepo().selectByUsername("" + request.getSession().getAttribute("ulogovan"));
                                
                                Teretana teretana = new teretanaRepo().selectByUsername("teretanaId");

                                {%>

                            <h3 style="color:white; font-weight: bold"> Izabrani trening</h3>
                            <div class="card" style="width: 18rem; float:left; margin:7.5px; background: rgba(0,0,0,0.5); color: white">              
                                <div class="card-body">

                                    <input value="<%=trening.korisnik.getKorisnikId()%>" name="korisnikId" type="hidden">
                                    <input value="<%=trening.getTreningId()%>" name="treningId" type="hidden">
                                    <input value="<%=trening.getTeretanaId()%>" name="teretanaId" type="hidden">
                                    <p class="card-text">Korisnik: <%=korisnik.getImeKorisnika()%> </p>
                                    <p class="card-text">Datum: <%=trening.getDatum()%> </p>
                                    <p class="card-text">Vreme: <%=trening.getVreme()%> </p>
                                    <p class="card-text">Trajanje: <%=trening.getTrajanje()%> </p>
                                    <p class="card-text">Opis: <%=trening.getOpis()%> </p>
                                    <p class="card-text">Cena: <%=trening.getCena()%> </p>


                                </div>  
                                <input type="submit" value="Idi na rezervacije" class="btn btn-success" style="background-color:darkgreen"></a>
                            </div>  
                            <%}


                            %>
                        </div>
                    </div>
                </div>
            </div>

        </form>
    </body>
</html>
<%    String rezultat = (String) request.getAttribute("Greska");

    if (rezultat != null)
        if (rezultat.equals("False")) {%>
<script type="text/javascript">
    swal("Neispravno popunjeni podaci rezervacije", "Rezervacija nije uspela", "error")
            .then(function () {

            });

</script> <%}
%>
