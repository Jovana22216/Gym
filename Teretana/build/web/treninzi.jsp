<%-- 
    Document   : treninzi
    Created on : Aug 11, 2020, 6:07:28 PM
    Author     : Jovana
--%>

<%@page import="Models.Teretana"%>
<%@page import="RepoPattern.teretanaRepo"%>
<%@page import="RepoPattern.treningRepo"%>
<%@page import="Models.Trening"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Treninzi</title>
    </head>

    <body>
        <%@ include file="navbar.jsp" %> 
        <%             HttpSession sesija = request.getSession();

            String teretanaSesija = "" + sesija.getAttribute("teretanaId");

            String teretanaID = request.getParameter("teretanaId");

            if (teretanaID == null) {
                response.sendRedirect("teretana.jsp");
            }
        %>

    <center>
        <input type="text" id="myInput" onkeyup="myFunction()" style="width:250px;" placeholder="Pretraga treninga.." class="form-control">
    </center>
    <ul id="myUL" class="list-unstyled">
        <%
            String ulogovanaRola = "";
            if ((String) request.getSession().getAttribute("UlogovanaRola") != null) {
                ulogovanaRola = (String) request.getSession().getAttribute("UlogovanaRola");
            }
            String IDk = "";

            if (request.getSession().getAttribute("UlogovanaRola") != null) {
                IDk = (String) request.getSession().getAttribute("UlogovanaRola");
            }
            String id = request.getParameter("teretanaId");
            String idk = request.getParameter("korisnikId");

            Korisnik p = new korisnikRepo().select(idk);

            Teretana teretana = new teretanaRepo().select(id);
            for (Trening trening : new treningRepo().listaSelektovaneTeretane(teretanaID)) {
                {%>
        <li>
            <div  class="card" style="width: 18rem; float:left; margin:7.5px; background: rgba(0,0,0,0.5); color: white">              
                <div id="myUL" class="card-body" style="display:inline-table;">
                    <a>
                        <input value="<%=teretana.getTeretanaId()%>" name="teretanaId" type="hidden">
                        <h3><%=teretana.getNazivTeretane()%></h3>

                        <p class="card-text">Datum:  <%=trening.getDatum()%> </p>
                        <p class="card-text">Vreme:  <%=trening.getVreme()%> </p>
                        <p class="card-text">Trajanje: <%=trening.getTrajanje()%> minuta </p>
                        <p class="card-text">Cena: <%=trening.getCena()%> dinara</p>
                        
                        <p class="card-text">Opis: <%=trening.getOpis()%> </p>
                    </a>        

                    <%}
                    %>
                </div>   
                <div class="card-footer">
                    <% if (ulogovanaRola.equals("3")) {%> 
                    <a href="${pageContext.request.contextPath}/rezervisi.jsp?treningId=<%=trening.getTreningId()%>" class="btn btn-success">rezervisi</a>


                    <%} else if (ulogovanaRola.equals("2")) {%> 
                    <a href="${pageContext.request.contextPath}/EditTreninga.jsp?treningId=<%=trening.getTreningId()%>" class="btn btn-success">Izmeni</a>
                </div>
            </div>
        </li>
        <%}
            }
        %>
    </ul>
</body>
</html>
<script>
    function myFunction() {
        // Declare variables
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById('myInput');
        filter = input.value.toUpperCase();
        ul = document.getElementById("myUL");
        li = ul.getElementsByTagName('li');

        // Loop through all list items, and hide those who don't match the search query
        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName("a")[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
    }
</script>
