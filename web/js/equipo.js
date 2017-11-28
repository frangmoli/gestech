EQUIPO = {};

EQUIPO.insertar = function(){
    var xhr = new XMLHttpRequest();
    // Metodo INSERTAR, Accion EquipoServer
    xhr.open("POST","EquipoServer");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        }
    };
    // objeto para enviar los parametros del formulario
    var equipo = {};
    equipo.cliente = document.querySelector("#equipo_cliente").value;
    equipo.modelo = document.querySelector("#equipo_modelo").value;
    equipo.serie = document.querySelector("#equipo_serie").value;
    equipo.diag = document.querySelector("#equipo_diag").value;
    equipo.fin = document.querySelector("#equipo_fechain").value;
    equipo.presup = document.querySelector("#equipo_presup").value;
    equipo.fout = document.querySelector("#equipo_fechaout").value;
    // formato del mensaje en JSON
    var equipoStringJSON = JSON.stringify(equipo);
    xhr.send(  equipoStringJSON );
};
EQUIPO.actualizar = function(paramId){
    var xhr = new XMLHttpRequest();
    // Metodo ACTUALIZAR, Accion EquipoServer
    xhr.open("PUT","EquipoServer");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        }
    };
    // objeto para enviar los parametros del formulario
    var equipo = {};
    equipo.id = paramId;
    equipo.cliente = document.querySelector("#equipo_cliente_"+paramId).value;
    equipo.modelo = document.querySelector("#equipo_modelo_"+paramId).value;
    equipo.serie = document.querySelector("#equipo_serie_"+paramId).value;
    equipo.diag = document.querySelector("#equipo_diag_"+paramId).value;
//    equipo.fechain = document.querySelector("#equipo_fechain_"+paramId).value;
    equipo.fin = document.querySelector("#equipo_fechain_"+paramId).value;
    equipo.presup = document.querySelector("#equipo_presup_"+paramId).value;
    equipo.fout = document.querySelector("#equipo_fechaout_"+paramId).value;
    // formato del mensaje en JSON
    var equipoStringJSON = JSON.stringify(equipo);
    xhr.send( equipoStringJSON );
};
EQUIPO.eliminar = function(paramId){

    // objeto para enviar los parametros del formulario
    var equipo = {};
    equipo.id = paramId;
    equipo.cliente = document.querySelector("#equipo_cliente_"+paramId).value;
    equipo.modelo = document.querySelector("#equipo_modelo_"+paramId).value;
    equipo.serie = document.querySelector("#equipo_serie_"+paramId).value;
    equipo.diag = document.querySelector("#equipo_diag_"+paramId).value;
    equipo.fin = document.querySelector("#equipo_fechain_"+paramId).value;
    equipo.presup = document.querySelector("#equipo_presup_"+paramId).value;
    equipo.fout = document.querySelector("#equipo_fechaout_"+paramId).value;
    // formato del mensaje en JSON
    var equipoStringJSON = JSON.stringify(equipo);

    var xhr = new XMLHttpRequest();
    // Metodo ELIMINAR, Accion EquipoServer
    xhr.open("DELETE","EquipoServer?&q=" + equipoStringJSON);
    
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        }
    };
    //xhr.send( equipoStringJSON );
    xhr.send(  );
};
EQUIPO.consultar = function(){
    var xhr = new XMLHttpRequest();
    // Metodo CONSULTAR, Accion EquipoServer
    //xhr.open("GET","../EquipoServer");
    xhr.open("GET","equipo_listado.jsp");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            //document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
//            var equipos = JSON.parse( xhr.responseText );
//            var templateEquipos = document.querySelector("#templateEquiposES6").innerHTML;
            document.querySelector('#panelResultados').innerHTML = xhr.responseText;
        }
    };
    // objeto para enviar los parametros del formulario
    var equipo = {};
    equipo.cliente = document.querySelector("#equipo_cliente").value;
    equipo.modelo = document.querySelector("#equipo_modelo").value;
    equipo.serie = document.querySelector("#equipo_serie").value;
    equipo.diag = document.querySelector("#equipo_diag").value;
    equipo.fin = document.querySelector("#equipo_fechain").value;
    equipo.presup = document.querySelector("#equipo_presup").value;
    equipo.fout = document.querySelector("#equipo_fechaout").value;
    
    // formato del mensaje en JSON
    var equipoStringJSON = JSON.stringify(equipo);
    xhr.send( equipoStringJSON );
};
/////////////////////////////////////////

EQUIPO.inicializar = function(){
   var elemInsertar = document.querySelector('#btnInsertar');    
   elemInsertar.setAttribute('onclick',"EQUIPO.insertar();");
   var elemActualizar = document.querySelector('#btnActualizar');
   
   elemActualizar.setAttribute('onclick',"EQUIPO.actualizar();");
   //elemActualizar.setAttribute('onclick',"EQUIPO.consultar();");
   var elemEliminar = document.querySelector('#btnEliminar');    
   elemEliminar.setAttribute('onclick',"EQUIPO.eliminar();");
   var elemConsultar = document.querySelector('#btnConsultar');    
   elemConsultar.setAttribute('onclick',"EQUIPO.consultar();");
//   var elemShutdown = document.querySelector('#btnShutdown');    
//   elemShutdown.setAttribute('onclick',"EQUIPO.shutdown();");
   
};
EQUIPO.inicializar();

