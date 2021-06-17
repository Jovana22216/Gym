<%-- 
    Document   : FotografijeHotela
    Created on : 18-Sep-2019, 18:36:56
    Author     : Jovana
--%>


<%@page import="RepoPattern.teretanaRepo"%>
<% new teretanaRepo().fotografije(request, response, request.getParameter("teretanaId")); %>
