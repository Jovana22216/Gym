<%-- 
    Document   : rezervacijeKorisnika
    Created on : Sep 15, 2020, 7:24:40 PM
    Author     : Jovana
--%>



<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="RepoPattern.korisnikRepo"%>
<%@page import="Models.Korisnik"%>
<%@page import="Models.Trening"%>
<%@page import="RepoPattern.rezervacijaRepo"%>
<%@page import="Models.Rezervacija"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pregled svih rezervacija</title>
        <%@ include file="navbar.jsp" %>  
        <script src="jQuery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"> 
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#Tabela').DataTable();
            });
        </script>

    </head>
    <body>
        <%      String id = request.getParameter("korisnikId");
            Korisnik korisnik = new korisnikRepo().select(id);
            String ulogovanaRola = "";
            if (request.getSession().getAttribute("UlogovanaRola") != null) {
                ulogovanaRola = "" + request.getSession().getAttribute("UlogovanaRola");
            }

        %>
        <br>
       <h1 align="center">REZERVACIJE</h1>

        <%  if (ulogovanaRola.equals("2")) {%>
        <div style="width:94%; margin-left:3%">
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
                    <%

                        String status1 = "";
                        int ii = 1;
                        for (Rezervacija rezervacija1 : new rezervacijaRepo().listaAktivnih()) {
                            {
                                if (korisnik.getKorisnikId() == rezervacija1.getKorisnikId()) {
                                    {

                                        if (new rezervacijaRepo().aktivnaRezervacija(rezervacija1.getRezervacijaId())) {
                                            status1 = "Aktivna";
                                        } else {
                                            status1 = "Aktivna";
                                            
                                            String placanje = "";
                            if (rezervacija1.getPlaceno()== false) {
                                placanje = "Nije placeno";
                            
                            } else {
                                placanje = "Placeno";
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
                        <td class="align-middle text-center"><%=placanje%> </td>
                        <td class="align-middle text-center"><%=status1%></td>
                        <td> 

                        </td>
                </tbody>
                <%}
                                    }
                                }
                            }
                        }
                    }%>
            </table>
        </div>


    </body>
</html>

