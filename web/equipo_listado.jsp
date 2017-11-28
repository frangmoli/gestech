<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Equipos.*"%>
<%@page import="java.util.*"%>
<div class='col-md-12 col-ms-12 col-xs-12 col-lg-12'>
<table border = 1 class='table'>
            <th>ID</th>
            <th>Cliente</th>
            <th>Modelo</th>
            <th>Serie</th>
            <th>Observaciones</th>
            <th>Fecha ingreso</th>
            <th>Presupuesto</th>
            <th>Fecha entrega</th>
            <%
                    ArrayList<Equipo> equipos = EquipoDao.getInstance().obtener();
                for( int i = 0 ; i<equipos.size() ; i++){
                    Equipo equipo = equipos.get(i);
                out.println("<tr class='equipo_item'>"
                              +"<td>"+ equipo.getId() +"</td>"
                              +"<td><input class='form-control' type='text' value='"+ equipo.getCliente() +"' id='equipo_cliente_"+ equipo.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ equipo.getModelo() +"' id='equipo_modelo_"+ equipo.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ equipo.getSerie() +"' id='equipo_serie_"+ equipo.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ equipo.getDiag()+"' id='equipo_diag_"+ equipo.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ equipo.getFin() +"' id='equipo_fechain_"+ equipo.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ equipo.getPresup()+"' id='equipo_presup_"+ equipo.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ equipo.getFout()+"' id='equipo_fechaout_"+ equipo.getId() +"' /></td>"
                              +"<td><input class='btn btn-warning' value='Guardar cambios  "+ equipo.getId() +"' onclick='EQUIPO.actualizar("+ equipo.getId() +");' />"
                              +"<input class='btn btn-danger' value='Eliminar "+ equipo.getId() +"' onclick='EQUIPO.eliminar("+ equipo.getId() +");'/></td>"
                              +"</tr>");
            }
                out.println("</table>");
            %>    
</div>