<%-- 
    Document   : clientes_1
    Created on : 15-nov-2017, 20:05:58
    Author     : Fran y Angie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Login.Conexion"%>
<%@page import="Usuario.Usuario"%>
<%@page session = "true"%>
<%
    HttpSession sesion = request.getSession();
    //String usuario;
    //String nivel;
    //               usuario=sesion.getAttribute("user").toString();
      //              nivel=sesion.getAttribute("nivel").toString();
    Object usuario = sesion.getAttribute("user") ==null ? null : sesion.getAttribute("user");
    Object nivel = sesion.getAttribute("nivel") ==null ? null : sesion.getAttribute("nivel");
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>GESTECH</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body style="background: #eee !important;">
        <% 
        String user = null;
        if(session.getAttribute("user") == null){
	//response.sendRedirect("../ingresar.html");
	request.getRequestDispatcher("/ingresar.jsp").forward(request, response);
        }
        %>
        <div class="container-fluid">
            <div>
           <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-brand">GESTECH</div>
                  <ul class="nav navbar-nav">
                  <li><a href="index.jsp">Inicio</a></li>    
                  <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#">Clientes
                  <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                
                  <li><a href="clientes_1.jsp">Clientes</a></li>
                  <!--<li><a href="listaclientes.html">Consultar listado de clientes</a></li>-->
                  </ul>
                  <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#">Equipos
                  <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                  <li><a href="equipos_1.jsp">Equipos</a></li>
                  <!--<li><a>Consultar listado</a></li>-->
                  </ul>  
                  </li>
                  <li class="nav navbar-nav navbar-right" style="background-color: aliceblue; font-:"><a href="logout.jsp">Cerrar Sesión</a></li> 
                   <!--<li class="nav navbar-nav"><form method="link" action="logout.jsp"><input type="submit" class="btn btn-danger" value="Logout"/></form></li>   -->
                 
                  </ul>
            </div>
                </nav>
            </div>
        </div>
        <div class="container">
           
        </div>
    </body>
</html>

