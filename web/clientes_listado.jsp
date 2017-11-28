<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Clientes.*"%>
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
                    ArrayList<Persona> clientes = PersonaDao.getInstance().obtener();
                for( int i = 0 ; i<clientes.size() ; i++){
                    Persona persona = clientes.get(i);
                out.println("<tr class='persona_item'>"
                              +"<td>"+ persona.getId() +"</td>"
                              +"<td><input class='form-control' type='text' value='"+ persona.getNombre() +"' id='persona_nombre_"+ persona.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ persona.getApellido() +"' id='persona_apellido_"+ persona.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ persona.getDni() +"' id='persona_dni_"+ persona.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ persona.getTelefono() +"' id='persona_telefono_"+ persona.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ persona.getEmail()+"' id='persona_email_"+ persona.getId() +"' /></td>"
                              +"<td><input class='form-control' type='text' value='"+ persona.getDireccion()+"' id='persona_direccion_"+ persona.getId() +"' /></td>"
                              +"<td><input class='btn btn-warning' value='Guardar cambios  "+ persona.getId() +"' onclick='PERSONA.actualizar("+ persona.getId() +");' />"
                              +"<input class='btn btn-danger' value='Eliminar "+ persona.getId() +"' onclick='PERSONA.eliminar("+ persona.getId() +");'/></td>"
                              +"</tr>");
            }
                out.println("</table>");
            %>    
 </div>