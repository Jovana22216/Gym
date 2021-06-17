package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import RepoPattern.podaciRepo;
import Models.Podaci;
import RepoPattern.rezervacijaRepo;
import Models.Rezervacija;
import RepoPattern.korisnikRepo;
import Models.Korisnik;
import Models.Korisnik;
import RepoPattern.korisnikRepo;

public final class profil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/navbar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Moji podaci</title>\n");
      out.write("        <script src=\"jQuery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\"> \n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.3.1.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#Tabela').DataTable();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .container{\n");
      out.write("                padding-top: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            b{\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container, .row, .col-xl-8, h1{\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            p{\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #profilna{\n");
      out.write("                height: 300px;\n");
      out.write("                width: 230px;\n");
      out.write("                margin-bottom: 30px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #karta{\n");
      out.write("                margin-top: 20px;\n");
      out.write("                padding-top: 20px;\n");
      out.write("                background: rgba(0,0,0,0.5); \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #tip{\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn {\n");
      out.write("                border: none;\n");
      out.write("                color: black;\n");
      out.write("                padding: 15px 32px;\n");
      out.write("                text-align: center;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: inline-block;\n");
      out.write("                font-size: 16px;\n");
      out.write("                margin: 4px 2px;\n");
      out.write("                cursor: pointer;\n");
      out.write("\n");
      out.write("                \n");
      out.write("                #poruka{\n");
      out.write("                margin-top: 50px;\n");
      out.write("                color: #ccffcc;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            </style>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"sr\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Copatible\" content=\"ie-etge; \">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <title>Teretana</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" integrity=\"sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"jQuery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\"> \n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.3.1.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.1.0/css/all.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("\n");
      out.write("        .logo{\n");
      out.write("            color: #9999ff;\n");
      out.write("            text-transform: uppercase;\n");
      out.write("            letter-spacing: 5px;\n");
      out.write("            font-size: 20px;\n");
      out.write("        }\n");
      out.write("        *{\n");
      out.write("            margin: 0px;\n");
      out.write("            padding: 0px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("        nav{\n");
      out.write("            display: flex;\n");
      out.write("            justify-content:space-around;\n");
      out.write("            align-items: center;\n");
      out.write("            min-height: 8vh;\n");
      out.write("            background-color: #5d4954;\n");
      out.write("            font-family: 'Poppins', sans-serif;\n");
      out.write("        }\n");
      out.write("        .navbar-nav{\n");
      out.write("            display: flex;\n");
      out.write("            justify-content:space-around;\n");
      out.write("            width: 70%;\n");
      out.write("        }\n");
      out.write("        .navbar-nav li{\n");
      out.write("            list-style: none;\n");
      out.write("        }\n");
      out.write("        .navbar-nav a{\n");
      out.write("            text-decoration: none;\n");
      out.write("            background-color: #5d4954;\n");
      out.write("            letter-spacing: 3px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            font-size: 14px;\n");
      out.write("        }\n");
      out.write("        .dropdown-menu{\n");
      out.write("            display: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        .dropdown-menu div{\n");
      out.write("            width: 25px;\n");
      out.write("            height: 3px; \n");
      out.write("            background-color: #5d4954;\n");
      out.write("            margin: 5px;\n");
      out.write("        }\n");
      out.write("        .nav-item a{\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("     \n");
      out.write("         .background-image {\n");
      out.write("            position: fixed;\n");
      out.write("            background-image: url( 'https://images.unsplash.com/photo-1493690283958-32df2c86326e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=748&q=80' );\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-size: cover;\n");
      out.write("            width: 100%;\n");
      out.write("            height: 100%;\n");
      out.write("            z-index: -1;\n");
      out.write("        } \n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body> \n");
      out.write("<div class=\"background-image\"></div>\n");
      out.write("        ");


            Boolean pom = false;
            if (request.getSession().getAttribute("ulogovan") != null) {
                pom = true;
            }
        
      out.write("      \n");
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark\" style=\"background: #5d4954;\">\n");
      out.write("            <div class=\"logo\">\n");
      out.write("                <a href=\"index.jsp\"  ><h4> Fitness</h4> </a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n");
      out.write("                <ul class=\"navbar-nav \">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"teretana.jsp\"> TERETANE <span class=\"sr-only\">(current)</span></a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"program.jsp\"> PROGRAMI <span class=\"sr-only\">(current)</span></a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    ");

                        if (!pom) {
      out.write("\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"Registracija.jsp\">REGISTRACIJA</a></li>\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"\" data-toggle=\"modal\" data-target=\"#exampleModal\" >PRIJAVI SE</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
   } else {
      out.write("\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"Logout\">ODJAVI SE</a></li>\n");
      out.write("                        ");
   }
                        
      out.write("\n");
      out.write("\n");
      out.write("                    <!-- Modal -->\n");
      out.write("                    <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">Prijava</h5>\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                                <form action=\"Login\" method=\"post\">\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        <div class=\"input-group mb-3\">\n");
      out.write("                                            <div class=\"input-group-prepend\">\n");
      out.write("                                                <span class=\"input-group-text\" id=\"basic-addon1\" for=\"validationServer03\">Korisničko ime: </span>\n");
      out.write("                                            </div>\n");
      out.write("                                            <input required name=\"username\" type=\"text\" class=\"form-control\" placeholder=\"Korisničko ime\" aria-label=\"Username\" aria-describedby=\"basic-addon1\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"input-group mb-3\">\n");
      out.write("                                            <div class=\"input-group-prepend\">\n");
      out.write("                                                <span class=\"input-group-text\" id=\"basic-addon1\">Lozinka: </span>\n");
      out.write("                                            </div>\n");
      out.write("                                            <input required name=\"password\" type=\"password\" class=\"form-control\" placeholder=\"Lozinka\" aria-label=\"Password\" aria-describedby=\"basic-addon1\">\n");
      out.write("                                            ");

                                                String loginGreska = "" + request.getAttribute("prvoLogovanje");
                                                if (loginGreska != null)
                                                    if (loginGreska.equals("False")) {
      out.write("\n");
      out.write("                                            <div class=\"invalid-feedback\">\n");
      out.write("                                                Pogresan unos podataka !\n");
      out.write("                                            </div>\n");
      out.write("                                            ");
}
                                            
      out.write(" \n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-footer\">\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Zatvori</button>\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-primary\">Prijavi  se</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("            </div> \n");
      out.write("\n");
      out.write("            ");
if (pom) {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

                String ulogovanaRola = "";
                if (request.getSession().getAttribute("UlogovanaRola") != null) {
                    ulogovanaRola = "" + request.getSession().getAttribute("UlogovanaRola");
                }
            
      out.write("\n");
      out.write("            ");

                if ((request.getSession().getAttribute("ulogovan")) != null) {
      out.write("\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/profil.jsp?korisnikId=");
      out.print(new korisnikRepo().selectByUsername("" + request.getSession().getAttribute("ulogovan")).getKorisnikId());
      out.write("\">PROFIL</a>          \n");
      out.write("            </li> \n");
      out.write("            ");
}
            
      out.write("\n");
      out.write("            ");

                if (ulogovanaRola.equals("1") || ulogovanaRola.equals("2") || ulogovanaRola.equals("3")) {
            
      out.write("\n");
      out.write("            <li class=\"nav-item dropdown\">\n");
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                    PREGLED OPCIJA\n");
      out.write("                </a>\n");
      out.write("                <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n");
      out.write("\n");
      out.write("                    ");

                        if (ulogovanaRola.equals("1")) {
                    
      out.write(" \n");
      out.write("                    <a class=\"dropdown-item\" href=\"KreiranjeTeretane.jsp\">KREIRANJE TERETANE</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"KreiranjePrograma.jsp\">KREIRANJE PROGRAMA</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"korisnici.jsp\">KORISNICI</a>\n");
      out.write("                   \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        }
                        if (ulogovanaRola.equals("2")) {
                    
      out.write(" \n");
      out.write("\n");
      out.write("                    <a class=\"dropdown-item\" href=\"korisnici.jsp\">KORISNICI</a>\n");
      out.write("                     <a class=\"dropdown-item\" href=\"pregledRezervacija.jsp\">REZERVACIJE</a>\n");
      out.write("\n");
      out.write("                    ");

                        }
                        if (ulogovanaRola.equals("3")) {
                    
      out.write(" \n");
      out.write("                    <a class=\"dropdown-item\" href=\"ishrana.jsp\">ISHRANA</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"mojiPodaci.jsp\">MOJI PODACI</a>\n");
      out.write("\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            ");
}
            
      out.write("\n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<main>\n");
      out.write("    <div class=\"background\"></div>\n");
      out.write("    <div class=\"foreground\"></div>\n");
      out.write("</main>\n");
      out.write("\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            ");
   
            String UlogovanaRola = "";
                if (request.getSession().getAttribute("UlogovanaRola") != null) {
                    UlogovanaRola = "" + (request.getSession().getAttribute("UlogovanaRola"));
                }
                String id = request.getParameter("korisnikId");
                Korisnik p = new korisnikRepo().select(id);
            
      out.write("\n");
      out.write("            <i><h2 align=\"center\" style=\"color: whitesmoke; font-family: fantasy;\" id=\"poruka\"></h2>\n");
      out.write("            <form style=\"margin: 2%  auto; color: white; font-family: sans-serif;   width: 480px; background: black; \">\n");
      out.write("                <input value=\"");
      out.print(request.getParameter("korisnikId"));
      out.write("\" name=\"korisnikId\" type=\"hidden\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-2\"></div>\n");
      out.write("                        <div class=\"col-xl-8 shadow rounded\"  id=\"karta\" align=\"center\">\n");
      out.write("                            <h1>Korisnička karta</h1>\n");
      out.write("                            <br>\n");
      out.write("                            <div class=\"row shadow\">\n");
      out.write("                                <div class=\"col-xl-8\">\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Ime</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getImeKorisnika());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Prezime</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getPrezimeKorisnika());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Korisnicko ime</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getKorisnickoIme());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Email </b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getEmail());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Broj telefona</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getTelefonKorisnika());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Adresa</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getAdresaKorisnika());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Grad</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getGradKorisnika());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                    <a class=\"delete_link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/EditKorisnika.jsp?korisnikId=");
      out.print( p.getKorisnikId());
      out.write("\" >\n");
      out.write("                                        <i class=\"fa fa-address-card\" > Izmeni</i>\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                            </div> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col\" style=\"margin-top:3%;\">\n");
      out.write("            <form action=\"PromeniLozinku\" method=\"post\">\n");
      out.write("                <a data-toggle=\"collapse\" data-target=\"#demo\"><i class=\"fas fa-plus-circle fa-plus-circle fa-2x\"> Promeni lozinku</i> </a>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div id=\"demo\" class=\"collapse\"> <br>\n");
      out.write("                        Stara lozinka: <input style=\"width:250px\"  type=\"text\" name=\"StaraLozinka\" class=\"form-control\"> <br>\n");
      out.write("                        Nova lozinka: <input style=\"width:250px\" type=\"text\" name=\"NovaLozinka\" class=\"form-control\"> <br>\n");
      out.write("                        <input type=\"submit\" value=\"Promeni\" class=\"btn btn-warning\"> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                ");
  if (UlogovanaRola.equals("3")) {
      out.write("                   \n");
      out.write("                <form method=\"post\" action=\"BrisanjeRezervacije\">\n");
      out.write("                    <a data-toggle=\"collapse\" data-target=\"#demo1\"><i class=\"fas fa-plus-circle fa-plus-circle fa-2x\"> Moje Aktivne Rezervacije</i> </a>\n");
      out.write("                    <div class=\"form-group\">          \n");
      out.write("                        <div id=\"demo1\" class=\"collapse\" style=\"width:94%; margin-left:3%\">\n");
      out.write("                            <table id=\"Tabela\" class=\"table table-hover table-dark\" style=\"background-color: #dae0e5; color:black;  font-family: Roboto;\">\n");
      out.write("                            <thead style=\"font-size: 13px;\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Redni broj</th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Ime korisnika</th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Datum </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Vreme </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Trajanje </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Opis </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Cena </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Placeno </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Status </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Opcije </th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
 String status = "";
                                    Korisnik korisnik1 = new korisnikRepo().selectByUsername((String) request.getSession().getAttribute("ulogovan"));

                                    int i = 1;
                                    for (Rezervacija rezervacija : new rezervacijaRepo().listaAktivnih()) {
                                        {
                                            if (korisnik1.getKorisnikId() == rezervacija.getKorisnikId()) {
                                                if (new rezervacijaRepo().aktivnaRezervacija(rezervacija.getRezervacijaId())) {
                                                    status = "Istekla";
                                                } else {
                                                    status = "Aktivna";
                                
      out.write("\n");
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td class=\"align-middle text-center\"> ");
      out.print(i++);
      out.write("  </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija.korisnik.getImeKorisnika());
      out.write("</td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija.trening.getDatum());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija.trening.getVreme());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija.trening.getTrajanje());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija.trening.getOpis());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija.trening.getCena());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija.getPlaceno());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(status);
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <td class=\"align-middle text-center\">\n");
      out.write("                                        <a class=\"delete_link\" style=\"color:black\"\n");
      out.write("                                           href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Placanje.jsp?rezervacijaId=");
      out.print( rezervacija.getRezervacijaId());
      out.write("\">\n");
      out.write("                                                <i class=\"fa fa-trash\"> Plati</i>                                  \n");
      out.write("                                            </a>\n");
      out.write("                                            <br>\n");
      out.write("                                            <a class=\"delete_link\" style=\"color:red\"\n");
      out.write("                                               href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/BrisanjeRezervacije?rezervacijaId=");
      out.print( rezervacija.getRezervacijaId());
      out.write("\">\n");
      out.write("                                                <i class=\"fa fa-trash\"> Obriši</i>                                  \n");
      out.write("                                            </a>\n");
      out.write("\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
}
                                                   }
                                               }
                                           }
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <form method=\"post\" action=\"BrisanjeRezervacije\">\n");
      out.write("                    <a data-toggle=\"collapse\" data-target=\"#demo2\"><i class=\"fas fa-plus-circle fa-plus-circle fa-2x\"> Moje Istekle Rezervacije</i> </a>\n");
      out.write("                    <div class=\"form-group\">          \n");
      out.write("                        <div id=\"demo2\" class=\"collapse\" style=\"width:94%; margin-left:3%\">\n");
      out.write("                            <table id=\"Tabela\" class=\"table table-hover table-dark\" style=\"background-color: #dae0e5; color:black;  font-family: Roboto;\">\n");
      out.write("                            <thead style=\"font-size: 13px;\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Redni broj</th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Ime korisnika</th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Datum </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Vreme </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Trajanje </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Opis </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Cena </th>\n");
      out.write("\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Placeno </th>\n");
      out.write("                                    <th class=\"align-middle text-center\" scope=\"col\">Status </th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
 String status1 = "";
                                    Korisnik korisnik2 = new korisnikRepo().selectByUsername((String) request.getSession().getAttribute("ulogovan"));

                                    int ii = 1;
                                    for (Rezervacija rezervacija1 : new rezervacijaRepo().listaIsteklih()) {
                                        {
                                            if (korisnik2.getKorisnikId() == rezervacija1.getKorisnikId()) {
                                                if (new rezervacijaRepo().isteklaRezervacija(rezervacija1.getRezervacijaId())) {
                                                    status1 = "Aktivna";
                                                } else {
                                                    status1 = "Istekla";


                                
      out.write("\n");
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td class=\"align-middle text-center\"> ");
      out.print(ii++);
      out.write("  </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija1.korisnik.getImeKorisnika());
      out.write("</td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija1.trening.getDatum());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija1.trening.getVreme());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija1.trening.getTrajanje());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija1.trening.getOpis());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija1.trening.getCena());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(rezervacija1.getPlaceno());
      out.write(" </td>\n");
      out.write("                                    <td class=\"align-middle text-center\">");
      out.print(status1);
      out.write("</td>\n");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("\n");
      out.write("                                    <td>\n");
      out.write("                                        <a class=\"delete_link\" style=\"color:red\"\n");
      out.write("                                           href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/BrisanjeRezervacije?rezervacijaId=");
      out.print( rezervacija1.getRezervacijaId());
      out.write("\">\n");
      out.write("                                                <i class=\"fa fa-trash\"> Obriši</i>                                  \n");
      out.write("                                            </a>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
}
                                                }
                                            }
                                        }
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </form>\n");
      out.write("         \n");
      out.write("<script>\n");
      out.write("    function myFunction() {\n");
      out.write("        document.getElementById(\"showInDropDown\").style.visibility = \"visible\";\n");
      out.write("    }\n");
      out.write("    function funkcija() {\n");
      out.write("        document.getElementById(\"showInDropDown\").style.visibility = \"hidden\";\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("</script>\n");

            if (request.getAttribute("Promena") != null)
                if (request.getAttribute("Promena").equals("True")) {
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            swal(\"Uspeh!\", \"Uspešno ste promenili lozinku. \", \"success\")\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        ");
   }

            if (request.getAttribute("Promena") != null)
                if (request.getAttribute("Promena").equals("False")) {
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            swal(\"Greška!\", \"Uneli ste pogrešnu lozinku. \", \"error\")\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        ");
}

        
      out.write("\n");
      out.write("\n");
      out.write("   </body>\n");
      out.write("        </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
