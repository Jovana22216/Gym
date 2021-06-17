<%-- 
    Document   : program
    Created on : Aug 3, 2020, 8:10:52 PM
    Author     : Jovana
--%>

<%@page import="RepoPattern.podaciRepo"%>
<%@page import="Models.Podaci"%>
<%@page import="RepoPattern.programRepo"%>
<%@page import="Models.Program"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Programi</title>
    </head> 
    <style> 
        #poruka{
            text-align: center;
            margin-top: 50px;
            color: #000;
        }
    </style>
    <body>
        <%@ include file="navbar.jsp" %> 
    <center>
        <input type="text" id="myInput" onkeyup="myFunction()" style="width:250px;" placeholder="Pretraga programa.." class="form-control">
    </center>
    <h2 id="poruka" align="center"><%        String unosP = (String) request.getAttribute("unosP");
        if (unosP != null) {
        %>
        <%=unosP%>
        <%
            }
        %>
    </h2>
    <h2 id="poruka" align="center"><%
        String editPodataka = (String) request.getAttribute("editPodataka");
        if (editPodataka != null) {
        %>
        <%=editPodataka%>
        <%
            }
        %>
    </h2>

    <%            String ulogovanaRola = "";
        if ((String) request.getSession().getAttribute("UlogovanaRola") != null) {
            ulogovanaRola = (String) request.getSession().getAttribute("UlogovanaRola");
        }
        Podaci podaci = new podaciRepo().select(request.getParameter("podatakId"));

          if (ulogovanaRola.equals("3")) {%> 


    <div class="card" style="width: 70rem;  float:left; margin-bottom:10px; margin-left: 100px; margin-top: 20px; background: rgba(0,0,0,0.7); color: white" >              
        <h1 style="text-align:center; color:white">Dragi korisnici</h1>
        <h4 style="text-align:center; color:white">Želimo da Vam pomognemo u odabiru programa koji je najbolji za Vaše fizičko stanje.
            Odradite kratak unos podataka o sebi, a mi ćemo vam odrediti programe po Vašim karakteristikama.
            <h4 style="text-align:center; color:white">Vas Fitness centar!</h4>
            <div style="text-align:center; color:white"> 
                <a href="unosPodataka.jsp"  style="text-align:center; color:white; background-color: #17a2b8;"  class="btn btn-success ">Unesite podatke o sebi</a>
            </div>
    </div>
    <%}%>
    </br>
    </br>
    <h2 id="poruka" align="center"><%
        String brisanjePrograma = (String) request.getAttribute("brisanjePrograma");
        if (brisanjePrograma != null) {
        %>
        <%= brisanjePrograma%>
        <%
            }
        %>
    </h2>
    <h2 id="poruka" align="center"><%
        String brisanjePodataka = (String) request.getAttribute("brisanjePodataka");
        if (brisanjePodataka != null) {
        %>
        <%= brisanjePodataka%>
        <%
            }
        %>
    </h2>
    <h2 id="poruka" align="center"><%
        String editPrograma = (String) request.getAttribute("editPrograma");
        if (editPrograma != null) {
        %>
        <%=editPrograma%>
        <%
            }
        %>
    </h2>
    <h2 id="poruka" align="center"><%
        String kreiranjeProg = (String) request.getAttribute("kreiranjeProg");
        if (kreiranjeProg != null) {
        %>
        <%=kreiranjeProg%>
        <%
            }
        %>
    </h2>

    <ul id="myUL" class="list-unstyled" >
        <%
            for (Program program : new programRepo().lista()) {
                {%>
        <li>
            <div  class="card" style="width: 70rem;  float:left; margin-bottom:10px; margin-left: 100px; margin-top: 20px; background: rgba(0,0,0,0.5); color: white" >              
                <div id="myUL" class="card-body" style="display:inline-table;">
                    <a>
                        <p class="card-text">Naziv: <%=program.getNazivPrograma()%> </p>
                        <p class="card-text">Cena:  <%=program.getCena()%> </p>
                        <p class="card-text">Trajanje: <%=program.getTrajanje()%> </p>
                        <p class="card-text">Opis: <%=program.getOpis()%> </p>
                    </a>        

                    <%}
                    %>
                </div>   
                <div class="card-footer">
                    <% if (ulogovanaRola.equals("1")) {%> 
                    <a href="${pageContext.request.contextPath}/EditPrograma.jsp?programId=<%=program.getProgramId()%>" class="btn btn-success">Izmeni</a>

                    <%--    <%} if (UlogovanaRola.equals("3")) {%> 
                          <a href="${pageContext.request.contextPath}/Placanje.jsp?programId=<%=program.getProgramId()%>" class="btn btn-success">Uplati</a>
                    --%>

                </div>
            </div>
        </li>
        <%
                }
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
