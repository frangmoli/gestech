PERSONA = {};

PERSONA.insertar = function(){
    var xhr = new XMLHttpRequest();
    // Metodo INSERTAR, Accion PersonaServer
    xhr.open("POST","PersonaServer");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        }
    };
    // objeto para enviar los parametros del formulario
    var persona = {};
    persona.nombre = document.querySelector("#persona_nombre").value;
    persona.apellido = document.querySelector("#persona_apellido").value;
    persona.dni = document.querySelector("#persona_dni").value;
    persona.telefono = document.querySelector("#persona_telefono").value;
    persona.email = document.querySelector("#persona_email").value;
    persona.direccion = document.querySelector("#persona_direccion").value;
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);
    xhr.send(  personaStringJSON );
};
PERSONA.actualizar = function(paramId){
    var xhr = new XMLHttpRequest();
    // Metodo ACTUALIZAR, Accion PersonaServer
    xhr.open("PUT","PersonaServer");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        }
    };
    // objeto para enviar los parametros del formulario
    var persona = {};
    persona.id = paramId;
    persona.nombre = document.querySelector("#persona_nombre_"+paramId).value;
    persona.apellido = document.querySelector("#persona_apellido_"+paramId).value;
    persona.dni = document.querySelector("#persona_dni_"+paramId).value;
    persona.telefono = document.querySelector("#persona_telefono_"+paramId).value;
    persona.email = document.querySelector("#persona_email_"+paramId).value;
    persona.direccion = document.querySelector("#persona_direccion_"+paramId).value;
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);
    xhr.send( personaStringJSON );
};
PERSONA.eliminar = function(paramId){

    // objeto para enviar los parametros del formulario
    var persona = {};
    persona.id = paramId;
    persona.nombre = document.querySelector("#persona_nombre_"+paramId).value;
    persona.apellido = document.querySelector("#persona_apellido_"+paramId).value;
    persona.dni = document.querySelector("#persona_dni_"+paramId).value;
    persona.telefono = document.querySelector("#persona_telefono_"+paramId).value;
    persona.email = document.querySelector("#persona_email_"+paramId).value;
    persona.direccion = document.querySelector("#persona_direccion_"+paramId).value;
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);

    var xhr = new XMLHttpRequest();
    // Metodo ELIMINAR, Accion PersonaServer
    xhr.open("DELETE","PersonaServer?&q=" + personaStringJSON);
    
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        }
    };
    //xhr.send( personaStringJSON );
    xhr.send(  );
};

PERSONA.consultar = function(){
    var xhr = new XMLHttpRequest();
    // Metodo CONSULTAR, Accion PersonaServer
    xhr.open("GET","clientes_listado.jsp");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            //document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
           // var personas = JSON.parse( xhr.responseText );
           // var templatePersonas = document.querySelector("#templatePersonasES6").innerHTML;
            document.querySelector('#panelResultados').innerHTML = xhr.responseText;
        }
    };
    // objeto para enviar los parametros del formulario
    var persona = {};
    persona.nombre = document.querySelector("#persona_nombre").value;
    persona.apellido = document.querySelector("#persona_apellido").value;
    persona.dni = document.querySelector("#persona_dni").value;
    persona.telefono = document.querySelector("#persona_telefono").value;
    persona.email = document.querySelector("#persona_email").value;
    persona.direccion = document.querySelector("#persona_direccion").value;
    
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);
    xhr.send( personaStringJSON );
};
/////////////////////////////////////////

PERSONA.inicializar = function(){
   var elemInsertar = document.querySelector('#btnInsertar');    
   elemInsertar.setAttribute('onclick',"PERSONA.insertar();PERSONA.consultar();");
   var elemActualizar = document.querySelector('#btnActualizar');
   
   elemActualizar.setAttribute('onclick',"PERSONA.actualizar();PERSONA.consultar();");
   //elemActualizar.setAttribute('onclick',"PERSONA.consultar();");
   var elemEliminar = document.querySelector('#btnEliminar');    
   elemEliminar.setAttribute('onclick',"PERSONA.eliminar();PERSONA.consultar();");
   var elemConsultar = document.querySelector('#btnConsultar');    
   elemConsultar.setAttribute('onclick',"PERSONA.consultar();");
//   var elemShutdown = document.querySelector('#btnShutdown');    
//   elemShutdown.setAttribute('onclick',"PERSONA.shutdown();");
   
};
PERSONA.inicializar();

