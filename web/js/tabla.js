`
    <table  border = 1 class='table'>
             <th>ID</th>
              <th>Nombre</th>
              <th>Apellido</th>
              <th>DNI</th>
              <th>Telefono</th>
              <th>Email</th>
             <th>Direccion</th>
              <th>Acciones</th>
    ${ personas.map( persona => 
    `
              <tr class='persona_item'>
                  <td scope='col' >${persona.id}</td>
                  <td scope='col' ><input class="form-control" type='text' value='${persona.nombre}' id='persona_nombre_${persona.id}' /></td>
                  <td scope='col' ><input class="form-control" type='text' value='${persona.apellido}' id='persona_apellido_${persona.id}' /></td>
                  <td scope='col' ><input class="form-control" type='text' value='${persona.dni}' id='persona_dni_${persona.id}' /></td>
                  <td scope='col' ><input class="form-control" type='text' value='${persona.telefono}' id='persona_telefono_${persona.id}' /></td>
                  <td><input class="form-control" type='email' value='${persona.email}' id='persona_email_${persona.id}' /></td>
                  <td><input class="form-control" type='text' value='${persona.direccion}' id='persona_direccion_${persona.id}' /></td>
                  <td><input class='btn btn-warning' value='Modificar datos  ${persona.id}' onclick='PERSONA.actualizar(${persona.id});PERSONA.consultar();' />
                  <input class='btn btn-danger' value='Eliminar cliente ${persona.id}' onclick='PERSONA.eliminar(${persona.id});PERSONA.consultar();'/></td>
              </tr>
    `
        ).join('')
      }
    </table>
`            