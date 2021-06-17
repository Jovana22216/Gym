<%-- 
    Document   : ProgramiKorisnika
    Created on : Sep 17, 2020, 12:29:46 AM
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
    <body>
        <%@ include file="navbar.jsp" %> 
    <center>
        <input type="text" id="myInput" onkeyup="myFunction()" style="width:250px;" placeholder="Pretraga programa.." class="form-control">
    </center>
    <div  class="card" style="width: 70rem;  float:left; margin-bottom:10px; margin-left: 100px; margin-top: 20px; background: rgba(0,0,0,0.7); color: white" >              
        <h4 style="text-align:center; color:white">Prema Vasim podacima ovo su programi koje Vam preporucujemo!</h4>
        <h4 style="text-align:center; color:white">Vas Fitness centar!</h4>
    </div>
    <ul id="myUL" class="list-unstyled" >
        <%          
            Podaci podaci = new podaciRepo().select(request.getParameter("podatakId"));
        %>

       <input value="<%=podaci.getPodatakId()%>" name="podatakId" type="hidden"> 
        <%
            if (podaci.getZahtev().equals("mrsavljenje")) {
                for (Program program : new programRepo().listaMrsavljenje()) {
        %>
        <li>
  


            <div  class="card" style="width: 70rem;  float:left; margin-bottom:10px; margin-left: 100px; margin-top: 20px; background: rgba(0,0,0,0.5); color: white" >              
                <div id="myUL" class="card-body" style="display:inline-table;">
                    <a>
                        <p class="card-text">Naziv: <%=program.getNazivPrograma()%> </p>
                        <p class="card-text">Cena:  <%=program.getCena()%> </p>
                        <p class="card-text">Trajanje: <%=program.getTrajanje()%> </p>
                        <p class="card-text">Opis: <%=program.getOpis()%> </p>
                    </a>   
                </div>   
            </div>
        </li>
        <%
            }
        } else if (podaci.getZahtev().equals("treniranje")) {

            for (Program program1 : new programRepo().listaTreniranje()) {
        %>
        <li>
            <div  class="card" style="width: 70rem;  float:left; margin-bottom:10px; margin-left: 100px; margin-top: 20px; background: rgba(0,0,0,0.5); color: white" >              
                <div id="myUL" class="card-body" style="display:inline-table;">
                    <a>
                        <p class="card-text">Naziv: <%=program1.getNazivPrograma()%> </p>
                        <p class="card-text">Cena:  <%=program1.getCena()%> </p>
                        <p class="card-text">Trajanje: <%=program1.getTrajanje()%> </p>
                        <p class="card-text">Opis: <%=program1.getOpis()%> </p>
                    </a>        
                </div>   
            </div>
        </li>
        <%
            }
        } else if (podaci.getZahtev().equals("rekreacija")) {
            for (Program program2 : new programRepo().listaRekreacija()) {
        %>
        <li>
            <div  class="card" style="width: 70rem;  float:left; margin-bottom:10px; margin-left: 100px; margin-top: 20px; background: rgba(0,0,0,0.5); color: white" >              
                <div id="myUL" class="card-body" style="display:inline-table;">
                    <a>
                        <p class="card-text">Naziv: <%=program2.getNazivPrograma()%> </p>
                        <p class="card-text">Cena:  <%=program2.getCena()%> </p>
                        <p class="card-text">Trajanje: <%=program2.getTrajanje()%> </p>
                        <p class="card-text">Opis: <%=program2.getOpis()%> </p>
                    </a>        
                </div>   
            </div>
        </li>
        <%
            }
        } else if (podaci.getZahtev().equals("zatezanje")) {
            for (Program program3 : new programRepo().listaZatezanje()) {
        %>
        <li>
            <div  class="card" style="width: 70rem;  float:left; margin-bottom:10px; margin-left: 100px; margin-top: 20px; background: rgba(0,0,0,0.5); color: white" >              
                <div id="myUL" class="card-body" style="display:inline-table;">
                    <a>
                        <p class="card-text">Naziv: <%=program3.getNazivPrograma()%> </p>
                        <p class="card-text">Cena:  <%=program3.getCena()%> </p>
                        <p class="card-text">Trajanje: <%=program3.getTrajanje()%> </p>
                        <p class="card-text">Opis: <%=program3.getOpis()%> </p>
                    </a>        
                </div>   
            </div>
        </li>
        <%}
            }%>
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
