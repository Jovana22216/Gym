<%-- 
    Document   : teretana
    Created on : Jul 23, 2020, 7:59:27 PM
    Author     : Jovana
--%>



<%@page import="RepoPattern.treningRepo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="RepoPattern.teretanaRepo"%>

<%@page import="Models.Trening"%>
<%@page import="Models.Teretana"%>
<%@page import="RepoPattern.treningRepo"%>
<%@page import="Models.Trening"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teretane</title>
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
        <input type="text" id="myInput" onkeyup="myFunction()" style="width:250px;" placeholder="Pretraga teretana.." class="form-control">
    </center>
    <h2 id="poruka" align="center"><%
            String brisanjeTeretane = (String) request.getAttribute("brisanjeTeretane");
            if (brisanjeTeretane != null) {
            %>
            <%= brisanjeTeretane%>
            <%
                }
            %>
        </h2>
         <h2 id="poruka" align="center"><%
            String brisanjeTreninga = (String) request.getAttribute("brisanjeTreninga");
            if (brisanjeTreninga != null) {
            %>
            <%= brisanjeTreninga%>
            <%
                }
            %>
        </h2>
        <h2 id="poruka" align="center"><%
            String kreiranjeTeretane = (String) request.getAttribute("kreiranjeTeretane");
            if (kreiranjeTeretane != null) {
            %>
            <%= kreiranjeTeretane%>
            <%
                }
            %>
        </h2>
         <h2 id="poruka" align="center"><%
            String editTeretane = (String) request.getAttribute("editTeretane");
            if (editTeretane != null) {
            %>
            <%= editTeretane%>
            <%
                }
            %>
        </h2>
        <h2 id="poruka" align="center"><%
            String editTreninga = (String) request.getAttribute("editTreninga");
            if (editTreninga != null) {
            %>
            <%= editTreninga%>
            <%
                }
            %>
        </h2>
        <h2 id="poruka" align="center"><%
            String kreiranjeTreninga = (String) request.getAttribute("kreiranjeTreninga");
            if (kreiranjeTreninga != null) {
            %>
            <%= kreiranjeTreninga%>
            <%
                }
            %>
        </h2>
    <ul id="myUL" class="list-unstyled">
        <%            String UlogovanaRola = "";
            if (request.getSession().getAttribute("UlogovanaRola") != null) {
                UlogovanaRola = "" + (request.getSession().getAttribute("UlogovanaRola"));
            }

            for (Teretana teretana : new teretanaRepo().lista()) {
                {%>
        <li>
            <div  class="card" style="width: 18rem;  float:left; margin:7.5px; background: rgba(0,0,0,0.5); color: white">              
                <img height="180px" width="286px" src="FotografijeTeretane.jsp?teretanaId=<%=teretana.getTeretanaId()%>" /> 
                <div id="myUL" class="card-body" style="display:inline-table;">
                    <a>
                        <h4 class="card-title"> <%=teretana.getNazivTeretane()%> </h4>
                        <p class="card-text"><b> Email:</b> <%=teretana.getEmail()%> </p>
                        <p class="card-text"><b> Grad:</b>  <%=teretana.getGrad()%> </p>
                        <p class="card-text" ><b> Adresa:</b> <%=teretana.getAdresaTeretane()%></p>
                        <p class="card-text"><b> Telefon:</b>  <%=teretana.getTelefonTeretane()%> </p>
                        <p class="card-text"><b> Opis:</b> <%=teretana.getOpis()%> </p>
                    </a>        
                    <%}
                    %>
                </div>   
                <div class="card-footer">


                    <a href="${pageContext.request.contextPath}/treninzi.jsp?teretanaId=<%=teretana.getTeretanaId()%>" class="btn btn-primary">Pogledaj treninge</a>
                    <% if (UlogovanaRola.equals("1")) {%> 
                    <a href="${pageContext.request.contextPath}/EditTeretane.jsp?teretanaId=<%=teretana.getTeretanaId()%>" class="btn btn-success">Izmeni</a>
                    <%}
                                    if (UlogovanaRola.equals("2")) {%> 
                    <a href="${pageContext.request.contextPath}/KreiranjeTreninga.jsp?teretanaId=<%=teretana.getTeretanaId()%>" class="btn btn-primary">Kreiraj Trening</a>

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