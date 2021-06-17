package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import RepoPattern.korisnikRepo;
import Models.Korisnik;
import RepoPattern.podaciRepo;
import Models.Podaci;

public final class mojiPodaci_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Moji podaci</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");
  
                Korisnik korisnik1 = new korisnikRepo().selectByUsername((String) request.getSession().getAttribute("ulogovan"));
   
                //String idk = request.getParameter("korisnikId");
               // Korisnik k = new korisnikRepo().select(idk);

                
                String id = request.getParameter("podatakId");
                Podaci p = new podaciRepo().select(id);

            
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                        <input value=\"");
      out.print(request.getParameter("podatakId"));
      out.write("\" name=\"podatakId\" type=\"text\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-2\"></div>\n");
      out.write("                        <div class=\"col-xl-8 shadow rounded\"  id=\"karta\" align=\"center\">\n");
      out.write("                            <h1>Moji Podaci</h1>\n");
      out.write("                            <br>\n");
      out.write("                            <div class=\"row shadow\">\n");
      out.write("                                <div class=\"col-xl-8\">\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Zahtev</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getZahtev());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Kilaza</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getKilaza());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Pritisak</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getPritisak());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Aktivnost </b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getAktivnost());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><b>Pol</b></td>\n");
      out.write("                                            <td><p>");
      out.print( p.getPol());
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                    <a class=\"delete_link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/EditPodataka.jsp?podatakId=");
      out.print( p.getPodatakId());
      out.write("\" >\n");
      out.write("                                        <i class=\"fa fa-address-card\" > Izmeni</i>\n");
      out.write("                                    </a>\n");
      out.write("                                        <br>\n");
      out.write("                                         <a class=\"delete_link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ProgramiKorisnika.jsp?podatakId=");
      out.print( p.getPodatakId());
      out.write("\" >\n");
      out.write("                                        <i class=\"fa fa-address-card\" > Vidi Programe</i>\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                            </div> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                                     \n");
      out.write("                </div>\n");
      out.write("           \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
