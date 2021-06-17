<%-- 
    Document   : navbar
    Created on : Jul 9, 2020, 3:27:48 PM
    Author     : Jovana
--%>


<%@page import="Models.Korisnik"%>
<%@page import="RepoPattern.korisnikRepo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="sr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Copatible" content="ie-etge; ">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Teretana</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <script src="jQuery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"> 
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.1.0/css/all.css">



    </head>

    <style>

        .logo{
            color: #9999ff;
            text-transform: uppercase;
            letter-spacing: 5px;
            font-size: 20px;
        }
        *{
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }
        nav{
            display: flex;
            justify-content:space-around;
            align-items: center;
            min-height: 8vh;
            background-color: #5d4954;
            font-family: 'Poppins', sans-serif;
        }
        .navbar-nav{
            display: flex;
            justify-content:space-around;
            width: 70%;
        }
        .navbar-nav li{
            list-style: none;
        }
        .navbar-nav a{
            text-decoration: none;
            background-color: #5d4954;
            letter-spacing: 3px;
            font-weight: bold;
            font-size: 14px;
        }
        .dropdown-menu{
            display: none;
            cursor: pointer;
        }
        .dropdown-menu div{
            width: 25px;
            height: 3px; 
            background-color: #5d4954;
            margin: 5px;
        }
        .nav-item a{
            align-items: center;
        }
     
         .background-image {
            position: fixed;
            background-image: url( 'https://iili.io/2cqSAF.jpg' );
            background-repeat: no-repeat;
            background-size: initial;
            width: 100%;
            height: 100%;
            z-index: -1;
        } 

    </style>


    <body> 
<div class="background-image"></div>
        <%

            Boolean pom = false;
            if (request.getSession().getAttribute("ulogovan") != null) {
                pom = true;
            }
        %>      


        <nav class="navbar navbar-expand-lg navbar-dark" style="background: #5d4954;">
            <div class="logo">
                <a href="index.jsp"  ><h4> Fitness</h4> </a>
            </div>

            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav ">
                    <li class="nav-item">
                        <a class="nav-link" href="teretana.jsp"> TERETANE <span class="sr-only">(current)</span></a>

                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="program.jsp"> PROGRAMI <span class="sr-only">(current)</span></a>

                    </li>
                    <%
                        if (!pom) {%>

                        <li class="nav-item"><a class="nav-link" href="Registracija.jsp">REGISTRACIJA</a></li>
                    <li class="nav-item"><a class="nav-link" href="" data-toggle="modal" data-target="#exampleModal" >PRIJAVI SE</a></li>


                    <%   } else {%>
                    <li class="nav-item"><a class="nav-link" href="Logout">ODJAVI SE</a></li>
                        <%   }
                        %>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Prijava</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="Login" method="post">
                                    <div class="modal-body">
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="basic-addon1" for="validationServer03">Korisničko ime: </span>
                                            </div>
                                            <input required name="username" type="text" class="form-control" placeholder="Korisničko ime" aria-label="Username" aria-describedby="basic-addon1">
                                        </div>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="basic-addon1">Lozinka: </span>
                                            </div>
                                            <input required name="password" type="password" class="form-control" placeholder="Lozinka" aria-label="Password" aria-describedby="basic-addon1">
                                            <%
                                                String loginGreska = "" + request.getAttribute("prvoLogovanje");
                                                if (loginGreska != null)
                                                    if (loginGreska.equals("False")) {%>
                                            <div class="invalid-feedback">
                                                Pogresan unos podataka !
                                            </div>
                                            <%}
                                            %> 
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Zatvori</button>
                                        <button type="submit" class="btn btn-primary">Prijavi  se</button>
                                </form>
                            </div>
                        </div>
                    </div>
            </div> 

            <%if (pom) {%>


            <%
                String ulogovanaRola = "";
                if (request.getSession().getAttribute("UlogovanaRola") != null) {
                    ulogovanaRola = "" + request.getSession().getAttribute("UlogovanaRola");
                }
            %>
            <%
                if ((request.getSession().getAttribute("ulogovan")) != null) {%>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/profil.jsp?korisnikId=<%=new korisnikRepo().selectByUsername("" + request.getSession().getAttribute("ulogovan")).getKorisnikId()%>">PROFIL</a>          
            </li> 
            <%}
            %>
            <%
                if (ulogovanaRola.equals("1") || ulogovanaRola.equals("2") || ulogovanaRola.equals("3")) {
            %>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    PREGLED OPCIJA
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">

                    <%
                        if (ulogovanaRola.equals("1")) {
                    %> 
                    <a class="dropdown-item" href="KreiranjeTeretane.jsp">KREIRANJE TERETANE</a>
                    <a class="dropdown-item" href="KreiranjePrograma.jsp">KREIRANJE PROGRAMA</a>
                    <a class="dropdown-item" href="korisnici.jsp">KORISNICI</a>
                   



                    <%
                        }
                        if (ulogovanaRola.equals("2")) {
                    %> 

                    <a class="dropdown-item" href="korisnici.jsp">KORISNICI</a>
                     <a class="dropdown-item" href="pregledRezervacija.jsp">REZERVACIJE</a>

                    <%
                        }
                        if (ulogovanaRola.equals("3")) {
                    %> 
                    <a class="dropdown-item" href="ishrana.jsp">ISHRANA</a>
                    <a class="dropdown-item" href="mojiPodaci.jsp">MOJI PODACI</a>

                    <%
                        }
                    %>

                    <% } %>
                </div>
            </li>

            <%}
            %>

        </ul>
    </div>

</nav>

<main>
    <div class="background"></div>
    <div class="foreground"></div>
</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</body>
</html>
