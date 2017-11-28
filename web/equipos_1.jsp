<%-- 
    Document   : clientes_1
    Created on : 15-nov-2017, 20:05:58
    Author     : Fran y Angie
--%>

<%@page import="Clientes.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Equipos.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
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
    Object usuario = sesion.getAttribute("user") == null ? null : sesion.getAttribute("user");
    Object nivel = sesion.getAttribute("nivel") == null ? null : sesion.getAttribute("nivel");

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
        <%            String user = null;
            if (session.getAttribute("user") == null) {
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
                        </ul>
                    </div>
                </nav>
            </div>
           </div>
        <div class="containter fluid">
        <section id="panelFiltro">
            <form class="form container" action="" method="GET">
                <div id="formulario" class="form group">
                    <div class='col-md-6 col-ms-6 col-xs-12 col-lg-6'>
                        <input required="" class="form-control" list="clientes" name="equipo_cliente" id="equipo_cliente" placeholder="Cliente" maxlength="200" />
         
                        <datalist id="clientes">
                            <% 
                               ArrayList<Persona> clientes = Clientes.PersonaDao.getInstance().obtener();
                               for( int i =0; i< clientes.size() ;  i++ ){ 
                                   Persona cliente = clientes.get(i);
                                   %>
                                   <option value="<%= cliente.getId() %> " >( <%= cliente.getNombre()%> )</option>>
                            <% }%>
                        </datalist>                        <input required="" class="form-control" type="text" name="equipo_modelo" id="equipo_modelo" placeholder="Modelo" maxlength="200" />
                        <br> 
                        <input required="" class="form-control" type="text" name="equipo_serie" id="equipo_serie" placeholder="Serie" maxlength="200" />
                        <input class="form-control" type="text" name="equipo_diag" id="equipo_diag" placeholder="Diagnostico" maxlength="200" />
                        <h5>Fecha entrada<span><input required="" class="form-control" type="date" name="equipo_fechain" id="equipo_fechain" title="Fecha Entrada"/></span></h5>
                        <input class="form-control" type="text" name="equipo_presup" id="equipo_presup" placeholder="Presupuesto" maxlength="200" />
                        <h5>Fecha entrega<span><input class="form-control" type="date" name="equipo_fechaout" id="equipo_fechaout" title="Fecha Entrega"/></span></h5>
                        <input class="btn btn-primary" id="btnInsertar" value="Insertar" />
                        <input class="btn btn-info" id="btnConsultar" value="Consultar listado equipos"/>
                        <input class="btn btn-danger" id="btnEliminar" value="Eliminar" style="visibility: hidden" />
                        <input class="btn btn-warning" id="btnActualizar" value="Actualizar" style="visibility: hidden" />
                    </div>
                </div>
            </form>
        </section>
        
        <br>
        
        
        <section id="panelResultados" class="table-responsive container ">

        </section>
        </div>
</div>
    
        <script src="js/mustache.js"></script>
        <script src="js/equipo.js"></script>

    </body>
</html>
