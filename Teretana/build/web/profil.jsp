<%-- 
    Document   : profil
    Created on : Aug 4, 2020, 7:56:01 PM
    Author     : Jovana
--%>

<%@page import="RepoPattern.podaciRepo"%>
<%@page import="Models.Podaci"%>
<%@page import="RepoPattern.rezervacijaRepo"%>
<%@page import="Models.Rezervacija"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="RepoPattern.korisnikRepo"%>
<%@page import="Models.Korisnik"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Moji podaci</title>
        <script src="jQuery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"> 
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#Tabela').DataTable();
            });
        </script>
        <style>
            .container{
                padding-top: 10px;
            }

            b{
                color: white;
            }

            .container, .row, .col-xl-8, h1{
                color: white;
            }

            p{
                color: white;
            }

            #profilna{
                height: 300px;
                width: 230px;
                margin-bottom: 30px;
            }

            #karta{
                margin-top: 20px;
                padding-top: 20px;
                background: rgba(0,0,0,0.5); 
            }

            #tip{
                margin-bottom: 20px;
            }

            .btn {
                border: none;
                color: black;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            </style>
        </head>
        <body>
            <%@include file="navbar.jsp" %>
            <%  String UlogovanaRola = "";
                if (request.getSession().getAttribute("UlogovanaRola") != null) {
                    UlogovanaRola = "" + (request.getSession().getAttribute("UlogovanaRola"));
                }
                String id = request.getParameter("korisnikId");
                Korisnik p = new korisnikRepo().select(id);
            %>
            <h2 align="center" style="color: whitesmoke; font-family: fantasy;" id="poruka"></h2>
            <h2 id="poruka" align="center"><%
                String lozinka = (String) request.getAttribute("lozinka");
                if (lozinka != null) {
                %>
                <%= lozinka%>
                <%
                    }
                %>
            </h2>
            <form style="margin: 2%  auto; color: white; font-family: sans-serif;   width: 480px; background: black; ">
                <input value="<%=request.getParameter("korisnikId")%>" name="korisnikId" type="hidden">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-2"></div>
                        <div class="col-xl-8 shadow rounded"  id="karta" align="center">
                            <h1>Korisnička karta</h1>
                            <br>
                            <div class="row shadow">
                                <div class="col-xl-8">
                                    <table class="table">
                                        <tr>
                                            <td><b>Ime</b></td>
                                            <td><p><%= p.getImeKorisnika()%></p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Prezime</b></td>
                                            <td><p><%= p.getPrezimeKorisnika()%></p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Korisnicko ime</b></td>
                                            <td><p><%= p.getKorisnickoIme()%></p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Email </b></td>
                                            <td><p><%= p.getEmail()%></p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Broj telefona</b></td>
                                            <td><p><%= p.getTelefonKorisnika()%></p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Adresa</b></td>
                                            <td><p><%= p.getAdresaKorisnika()%></p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Grad</b></td>
                                            <td><p><%= p.getGradKorisnika()%></p></td>
                                        </tr>
                                    </table>
                                    <a class="delete_link" href="${pageContext.request.contextPath}/EditKorisnika.jsp?korisnikId=<%= p.getKorisnikId()%>" >
                                        <i class="fa fa-address-card" > Izmeni</i>
                                    </a>
                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </form>
            <div  style="margin-top:3%;">
            <form action="PromeniLozinku" method="post">
                <a data-toggle="collapse" data-target="#demo"><i class="fas fa-plus-circle fa-plus-circle fa-2x"> Promeni lozinku</i> </a>
                <div class="form-group">
                    <div id="demo" class="collapse"> <br>
                        Stara lozinka: <input style="width:250px"  type="text" name="StaraLozinka" class="form-control"> <br>
                        Nova lozinka: <input style="width:250px" type="text" name="NovaLozinka" class="form-control"> <br>
                        <input type="submit" value="Promeni" class="btn btn-warning"> 
                    </div>
                </div>
            </form>
        </div>
            <%  if (UlogovanaRola.equals("3")) {%>                   
            <form method="post" action="BrisanjeRezervacije">
                <a data-toggle="collapse" data-target="#demo1"><i class="fas fa-plus-circle fa-plus-circle fa-2x"> Moje Aktivne Rezervacije</i> </a>
                <div class="form-group">          
                    <div id="demo1" class="collapse" style="width:94%; margin-left:3%">
                            <table id="Tabela" class="table table-hover table-dark" style="background-color: #dae0e5; color:black;  font-family: Roboto;">
                            <thead style="font-size: 13px;">
                                <tr>
                                    <th class="align-middle text-center" scope="col">Redni broj</th>
                                    <th class="align-middle text-center" scope="col">Ime korisnika</th>
                                    <th class="align-middle text-center" scope="col">Datum </th>
                                    <th class="align-middle text-center" scope="col">Vreme </th>
                                    <th class="align-middle text-center" scope="col">Trajanje </th>
                                    <th class="align-middle text-center" scope="col">Opis </th>
                                    <th class="align-middle text-center" scope="col">Cena </th>
                                    <th class="align-middle text-center" scope="col">Placeno </th>
                                    <th class="align-middle text-center" scope="col">Status </th>
                                    <th class="align-middle text-center" scope="col">Opcije </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% String status = "";
                                    Korisnik korisnik1 = new korisnikRepo().selectByUsername((String) request.getSession().getAttribute("ulogovan"));

                                    int i = 1;
                                    for (Rezervacija rezervacija : new rezervacijaRepo().listaAktivnih()) {
                                        {
                                            if (korisnik1.getKorisnikId() == rezervacija.getKorisnikId()) {
                                                if (new rezervacijaRepo().aktivnaRezervacija(rezervacija.getRezervacijaId())) {
                                                    status = "Istekla";
                                                } else {
                                                    status = "Aktivna";
                                                    
                                                    String placanje = "";
                            if (rezervacija.getPlaceno()== false) {
                                placanje = "Nije placeno";
                            
                            } else {
                                placanje = "Placeno";
                                }
                                %>

                                <tr>
                                    <td class="align-middle text-center"> <%=i++%>  </td>
                                    <td class="align-middle text-center"><%=rezervacija.korisnik.getImeKorisnika()%></td>
                                    <td class="align-middle text-center"><%=rezervacija.trening.getDatum()%> </td>
                                    <td class="align-middle text-center"><%=rezervacija.trening.getVreme()%> </td>
                                    <td class="align-middle text-center"><%=rezervacija.trening.getTrajanje()%> </td>
                                    <td class="align-middle text-center"><%=rezervacija.trening.getOpis()%> </td>
                                    <td class="align-middle text-center"><%=rezervacija.trening.getCena()%> </td>
                                    <td class="align-middle text-center"><%=placanje%> </td>
                                    <td class="align-middle text-center"><%=status%></td>


                                    <td class="align-middle text-center">
                                        <a class="delete_link" style="color:black"
                                           href="${pageContext.request.contextPath}/Placanje.jsp?rezervacijaId=<%= rezervacija.getRezervacijaId()%>">
                                                <i class="fa fa-trash"> Plati</i>                                  
                                            </a>
                                            <br>
                                            
                                            <a class="delete_link" style="color:red"
                                               href="${pageContext.request.contextPath}/BrisanjeRezervacije?rezervacijaId=<%= rezervacija.getRezervacijaId()%>">
                                                <i class="fa fa-trash"> Obriši</i>                                  
                                            </a>

                                        </td>
                                    </tr>
                                    <%}
                                                }
                                            }
                                        }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </form>
                <form method="post" action="BrisanjeRezervacije">
                    <a data-toggle="collapse" data-target="#demo2"><i class="fas fa-plus-circle fa-plus-circle fa-2x"> Moje Istekle Rezervacije</i> </a>
                    <div class="form-group">          
                        <div id="demo2" class="collapse" style="width:94%; margin-left:3%">
                            <table id="Tabela" class="table table-hover table-dark" style="background-color: #dae0e5; color:black;  font-family: Roboto;">
                            <thead style="font-size: 13px;">
                                <tr>
                                    <th class="align-middle text-center" scope="col">Redni broj</th>
                                    <th class="align-middle text-center" scope="col">Ime korisnika</th>
                                    <th class="align-middle text-center" scope="col">Datum </th>
                                    <th class="align-middle text-center" scope="col">Vreme </th>
                                    <th class="align-middle text-center" scope="col">Trajanje </th>
                                    <th class="align-middle text-center" scope="col">Opis </th>
                                    <th class="align-middle text-center" scope="col">Cena </th>

                                    <th class="align-middle text-center" scope="col">Placeno </th>
                                    <th class="align-middle text-center" scope="col">Status </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% String status1 = "";
                                    Korisnik korisnik2 = new korisnikRepo().selectByUsername((String) request.getSession().getAttribute("ulogovan"));

                                    int ii = 1;
                                    for (Rezervacija rezervacija1 : new rezervacijaRepo().listaIsteklih()) {
                                        {
                                            if (korisnik2.getKorisnikId() == rezervacija1.getKorisnikId()) {
                                                if (new rezervacijaRepo().isteklaRezervacija(rezervacija1.getRezervacijaId())) {
                                                    status1 = "Aktivna";
                                                } else {
                                                    status1 = "Istekla";

                                                    String placanje1 = "";
                            if (rezervacija1.getPlaceno()== false) {
                                placanje1 = "Nije placeno";
                            
                            } else {
                                placanje1 = "Placeno";
                                }

                                %>

                                <tr>
                                    <td class="align-middle text-center"> <%=ii++%>  </td>
                                    <td class="align-middle text-center"><%=rezervacija1.korisnik.getImeKorisnika()%></td>
                                    <td class="align-middle text-center"><%=rezervacija1.trening.getDatum()%> </td>
                                    <td class="align-middle text-center"><%=rezervacija1.trening.getVreme()%> </td>
                                    <td class="align-middle text-center"><%=rezervacija1.trening.getTrajanje()%> </td>
                                    <td class="align-middle text-center"><%=rezervacija1.trening.getOpis()%> </td>
                                    <td class="align-middle text-center"><%=rezervacija1.trening.getCena()%> </td>
                                    <td class="align-middle text-center"><%=placanje1%> </td>
                                    <td class="align-middle text-center"><%=status1%></td>

                                    <td>
                                        <a class="delete_link" style="color:red"
                                           href="${pageContext.request.contextPath}/BrisanjeRezervacije?rezervacijaId=<%= rezervacija1.getRezervacijaId()%>">
                                                <i class="fa fa-trash"> Obriši</i>                                  
                                            </a>
                                        </td>
                                    </tr>
                                    <%}
                                                }
                                            }
                                        }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <%}%>
                </form>
                <script>
                    function myFunction() {
                        document.getElementById("showInDropDown").style.visibility = "visible";
                    }
                    function funkcija() {
                        document.getElementById("showInDropDown").style.visibility = "hidden";
                    }

                </script>
            </body>
        </html>
