<%-- 
    Document   : index
    Created on : Jul 9, 2020, 3:22:37 PM
    Author     : Jovana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style> 
        #poruka{
            text-align: center;
            margin-top: 50px;
            color: #000;
        }
    </style>
    <%@ include file="navbar2.jsp" %>
    <h2 align="center" style="color: whitesmoke;" id="poruka"></h2>
        <form action="Korisnici">

            <%            String msg = (String) request.getAttribute("msg");
                if (msg != null) {
            %>
            <%= msg%>
            <%
                }

            %>

            <%            String Ime = (String) request.getSession().getAttribute("ulogovan");
                if (request.getAttribute("prvoLogovanje") != null)
                    if (request.getAttribute("prvoLogovanje").equals("True")) {%>
            <script type="text/javascript">
                swal("Dobrodošli  <%=Ime%>!", "Uspešno ste se ulogovali! ", "success")
                        .then(function () {
                            window.location = "index.jsp";
                        });

            </script>
            <%   }

                if (request.getAttribute("prvoLogovanje") != null)
                    if (request.getAttribute("prvoLogovanje").equals("False")) {%>
            <script type="text/javascript">
                $(window).on('load', function () {
                    $('#exampleModal').modal('show');
                });
            </script>
            <%}

            %>
        </form>
    </head>
    <body>
        <form  enctype="multipart/form-data" style=" background-color:darkgreen; position: fixed; margin: 16% 0% ; width: 60.6rem; background: rgba(0,0,0,1); color: white;" align="center">

            <br>
            <h1>POSTANI DEO!</h1>
            <br>

        </form>

        <form  enctype="multipart/form-data" style=" background-color:darkgreen; position: fixed; margin-left: 71% ; margin-top: -3.65%; width:30rem; height: 40rem; background: rgba(0,0,0,1); color: white;" align="center">
            <div style="margin-right: 13%">
                <br>
                <h1>Trenirajte kod Nas!</h1>
                <br>
                <h3 >Pronadjite nas više</h3>
                <h3>lokacija u Beogradu</h3>
                <br>
               <a href="https://www.google.com/maps/place/%D0%A2%D0%B5%D1%80%D0%B0%D0%B7%D0%B8%D1%98%D0%B5+40,+%D0%91%D0%B5%D0%BE%D0%B3%D1%80%D0%B0%D0%B4/@44.8112823,20.4595269,17z/data=!3m1!4b1!4m5!3m4!1s0x475a7aaefa691507:0x435d130a2a21aaf4!8m2!3d44.8112823!4d20.4617156"> <h4>Centar </h4></a>
                <br>
                <a href="https://www.google.com/maps/place/%D0%94%D1%80%D0%B0%D0%B3%D0%B0%D0%BD%D0%B0+%D0%A0%D0%B0%D0%BA%D0%B8%D1%9B%D0%B0+18,+%D0%91%D0%B5%D0%BE%D0%B3%D1%80%D0%B0%D0%B4/@44.8431624,20.3865695,17z/data=!3m1!4b1!4m5!3m4!1s0x475a65c714a6e06b:0xa68d81dc25a0bfab!8m2!3d44.8431624!4d20.3887582"> <h4>Zemun </h4></a>
               
                <br>
                 <a href="https://www.google.com/maps/place/%D0%9F%D0%BE%D0%B6%D0%B5%D1%88%D0%BA%D0%B0+29,+%D0%91%D0%B5%D0%BE%D0%B3%D1%80%D0%B0%D0%B4/@44.7832392,20.4193002,17z/data=!3m1!4b1!4m5!3m4!1s0x475a6fda712a1935:0x1012a05c0eae5b0f!8m2!3d44.7832392!4d20.4214889"> <h4>Banovo brdo </h4></a>
               
                <br>
                 <a href="https://www.google.com/maps/place/%D0%88%D1%83%D1%80%D0%B8%D1%98%D0%B0+%D0%93%D0%B0%D0%B3%D0%B0%D1%80%D0%B8%D0%BD%D0%B0+10,+%D0%91%D0%B5%D0%BE%D0%B3%D1%80%D0%B0%D0%B4+11070/@44.8054534,20.4055776,17z/data=!3m1!4b1!4m5!3m4!1s0x475a6f8fcfe55555:0xa1f3cdb45a121b1e!8m2!3d44.8054534!4d20.4077663"> <h4>Novi Beograd </h4></a>
               
                 </br>
                 </br>
                 
                 <h3 class="txt13 m-b-32">
						Radno Vreme
					</h3>

					<ul>
						<li class="txt14">
							08:00  - 23:00 
						</li>

						<li class="txt14">
							Pon-Ned
						</li>
					</ul>
                 
            </div>
        </form>
    </body>
</script>
</html>
