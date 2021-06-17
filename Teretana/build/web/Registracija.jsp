<%-- 
    Document   : Registracija
    Created on : Sep 8, 2020, 5:25:27 PM
    Author     : Jovana
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="sr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registracija</title>
    </head>

    <body>
         <%@ include file="navbar.jsp" %>
        <% 
            HttpSession sesija = request.getSession();
            
            if(sesija.getAttribute("ulogovan")!=null)
                response.sendRedirect("index.jsp");
        %>
        
        
       
        <%
            String rezultat =(String) request.getAttribute("rezultat");
            
            if(rezultat!=null)
            if(rezultat.equals("True")){%>
            <script type="text/javascript">
                    swal("Dobar  posao", "Registracija uspela", "success")
                    .then(function() {
                        window.location = "index.jsp";
                    });

            </script>
             
                     <%   }
            
            else if (rezultat.equals("False"))  {%>

                   <script type="text/javascript">
                        swal("Greška", "Uneli ste postojeće korisničko ime ili E-mail.", "error")
                       .then(function() {
                           window.location = "Registracija.jsp";
                       });
                   </script>

            <% }%>
            
    <center>
        <form action="Registracija" style=" margin: 2% 2%; width: 25rem; background: rgba(0,0,0,0.5); color: white" align="center" >
            <h2>Registracija</h2>
            <table cellspacing="20px" >
                <tr>
                    <td style="margin: 10px; padding: 10px;"> Korisničko ime:</td>
                    <td style="margin: 10px; padding: 10px;"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje za korisničko ime. Min dužina 3 karaktera')" class="form-control" required minLength="3" type="text" name="korisnickoIme"></td>
                </tr>
                <tr>
                    <td style="margin: 10px; padding: 10px;"> Lozinka:</td>
                    <td style="margin: 10px; padding: 10px;"><input oninvalid="this.setCustomValidity('Neophodna lozinka. Min dužina 3 karaktera')" class="form-control" required minLength="3" type="password" type="text" name="sifra"></td>
                </tr>
                <tr>
                    <td style="margin: 10px; padding: 10px;">Ime:</td>
                    <td style="margin: 10px; padding: 10px;"><input oninvalid="this.setCustomValidity('Neophodno polje za ime. Min dužina 2 karaktera)" class="form-control" required minLength="2" type="text" name="imeKorisnika"></td>
                </tr>
                <tr>
                    <td style="margin: 10px; padding: 10px;">Prezime:</td>
                    <td style="margin: 10px; padding: 10px;"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje za prezime. Min dužina 2 karaktera')" class="form-control" required minLength="3" type="text" name="prezimeKorisnika"></td>
                </tr>
                <tr>
                    <td style="margin: 10px; padding: 10px;">Email:</td>
                    <td style="margin: 10px; padding: 10px;"><input  oninvalid="this.setCustomValidity('Neophodno popuniti polje za email. Min dužina 8 karaktera')" class="form-control" required minLength="8" type="text" name="email"></td>
                </tr>
                
                <tr>
                    <td style="margin: 10px; padding: 10px;">Adresa:</td>
                    <td style="margin: 10px; padding: 10px;"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje za adresu')" class="form-control" required minLength="3" type="text" name="adresaKorisnika"></td>
                </tr>
                 <tr>
                    <td style="margin: 10px; padding: 10px;">Telefon:</td>
                    <td style="margin: 10px; padding: 10px;"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje za telefon')" class="form-control" required minLength="6"  maxLength="10" type="text" name="telefonKorisnika"></td>
                </tr>
                 <tr>
                    <td style="margin: 10px; padding: 10px;">Grad:</td>
                    <td style="margin: 10px; padding: 10px;"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje za gred')" class="form-control" required minLength="3" type="text" name="gradKorisnika"></td>
                </tr>
            </table><br>
            <input id ="button-a" type="submit" style="background-color: #002db3; width: 23rem; margin-bottom: 1rem" value="Registruj se" class="btn btn-success" >
        </form>
    </center>
    </body>
</html>


