function ajax_listar(){
	nroContrato = 0;
	
	if($('#txtBuscar').val()!=''){
		nroContrato = $('#txtBuscar').val();
	}
   $.ajax({
      type : 'POST',
      url  : '/contrato/listar',
      data: {
			nContrato:nroContrato
		}
   })
   .done( function(resp) {
		// Cargo los datos en '#tablaDatos'
		//console.log(resp);
		var tbody = '';
		for ( let i=0; i < resp.length; i++) {
			tbody += '<tr>';
			tbody += '<td>'+resp[i].nContrato+'</td>'
			tbody += '<td>'+resp[i].cNombre+'</td>'
			tbody += '<td>'+resp[i].fDesde+'</td>'
			tbody += '<td>'+resp[i].fHasta+'</td>'
			tbody += '<td>'+resp[i].nPeriodicidad+'</td>'
	/*
			for ( let k in resp[i] )
				tbody += '<td>' + resp[i][k] + '</td>';
*/
			tbody += '</tr>';
		}
		$('#tablaDatos tbody').html(tbody);

		$(document).ready(function() {
			// Programo el evento clic sobre una fila de datos 
			$("#tablaDatos tbody").on('click','tr', function() {
				if ( modoSelecc.val() == 'crear' )
				
					// El modo 'crear' se atiende a través del botón 'btnCrear'
					return;
				//$('#cliente').hide();
				//$('#txtnombreC').hide();	
				// Cargo los datos de la fila selecc. para modif. o elim.
				$('.modal-title').html(modoSelecc.html()+' cliente');
				console.log("estoy aqui: "+ $(this).find('td').eq(1).text());
				$("#lblId").text( $(this).find('td').eq(0).text() );
				$("#txtnombreC").val( $(this).find('td').eq(1).text() );
				$("#txtFInicio").val( $(this).find('td').eq(2).text() );
				$("#txtFtermino").val( $(this).find('td').eq(3).text() );
				$("#txtperiodo").val( $(this).find('td').eq(4).text() );
				//$("#txtFono").val( $(this).find('td').eq(4).text() );
				//$("#txtEmail").val( $(this).find('td').eq(5).text() );
				
				// Abro el modal
				$("#modalEdicion").modal('show');

				
				// Los inputs del modal quedan readonly en modo 'eliminar'
				if ( modoSelecc.val() == 'eliminar' ) {
					//$('#identificador').hide();
					$('#cliente').show();
					$('#selectName').hide();
					$('#txtnombreC').show;
					$('#inputsModal .input-sm').prop('readonly', true);
					$('#btnOk').text('Eliminar');
					$('#btnCancelar').focus();
				}
				else {
					$('#identificador').hide();
					$('#selectName').hide();
					//$('#txtnombreC').prop('readonly',true);
					$('#inputsModal .input-sm').prop('readonly', false);
					$('#btnOk').text('Grabar');
					$('#txtRut').focus();
				}
			})
		})
	})
	.fail( function(request) {
		alert('No se pudo ejecutar "ajax:/contrato/listar"\n'+request.responseText);
   });
}

function ajax_crear() {
   $.ajax({
      type : 'POST',
      url  : '/contrato/crear',
      data : { nIdCliente: $('#sel1').val(), 
      			fDesde: $('#txtFInicio').val(),
      			fHasta: $('#txtFtermino').val(),
      			nPeriodicidad: $('#txtperiodo').val(),
      			
      		 }
      		 
   })
   .done( function (resp) {
      if ( resp == '' )
         alert('Hubo un error al intentar crear el contrato.');
      else 
			alert('Se creó el contrato.');
			ajax_listar();
   })
   .fail( function (request) {
   	alert('No se pudo ejecutar "ajax:/contrato/crear"\n'+request.responseText);
   })
}

function ajax_modificar() {
   $.ajax({
      type : 'POST',
      url  : '/contrato/modificar',
      data : { id:  $('#lblId').text(),
				nIdCliente: $('#sel1').val(), 
      			fDesde: $('#txtFInicio').val(),
      			fHasta: $('#txtFtermino').val(),
      			nPeriodicidad: $('#txtperiodo').val(),
      		 }
   })
 	.done( function (resp) {
      if ( resp == 0 )
         alert('Hubo un error al intentar modificar.');
      else 
			alert('Se modificó el contrato.');
			ajax_listar();
   })
   .fail( function (request) {
      alert('No se pudo ejecutar "ajax:/contrato/modificar"\n'+request.responseText);
   })
}

function ajax_eliminar() {
   $.ajax({
      type : 'POST',
      url  : 'contrato/eliminar',
      data : {id: $("#lblId").text()}
   })
   .done( function (resp) {
         if ( resp == '' )
            alert('Hubo un error al intentar contrato.');
         else 
			alert('Se eliminó el contrato.');
			ajax_listar();
   })
   .fail( function (request) {
         alert('No se pudo ejecutar "ajax:/contrato/eliminar"\n'+request.responseText);
   })
}

function ajax_consultar() {
   $.ajax({
      type : 'POST',
      url  : '/clientes/consultar',
      data : {id: $('#lblId').text()}
   })
   .done( function (resp) {
		if ( resp == '' )
         alert('Hubo un error al intentar consultar.');
   })
   .fail( function (request) {
      alert('No se pudo ejecutar "ajax:/clientes/consultar"\n'+request.responseText);
   })
}

function nuevoCliente() {
	// Limpio campos del modal
	$.ajax({
      type : 'POST',
      url  : '/clientes/listar'
   })
   .done( function (resp) {
	console.log(resp);
	for(j=0 ; j<resp.length;j++)
	{
		$('#sel1').append("<option value="+resp[j].nId+">"+resp[j].cNombre+"</option>");
		console.log(resp[j]);
		
	}
		if ( resp == '' )
         alert('Hubo un error al intentar consultar.');
   })
   .fail( function (request) {
      alert('No se pudo ejecutar "ajax:/clientes/consultar"\n'+request.responseText);
   });
   
   $('#identificador').hide();
   $('#cliente').hide();
   $('#selectName').show();
   
   
	$('#lblId').text('');
	$('#modalEdicion input').val('');

	// ...y lo abro 
	$("#modalEdicion").modal('show');
}

function accion() {
	// Gatillada por el clic en 'btnOk' del modal
	let op = modoSelecc.val();
	let err='';
	
	if ( op == 'eliminar' ) 
		if ( confirm('Confirme la eliminación de este contrato.') ){
			ajax_eliminar();
		}
		else{
			err = '!'
			}
	else {
		//err = validar_datos();
		
		if ( err != '' ) 
			alert(err);
		else if ( op =='crear' )
			ajax_crear();
		else if ( op =='modificar' )
			ajax_modificar();	

		if ( err != '' )
			$('#txtRut').focus();
	}

	if ( err == '' ) {
		ajax_listar();
		$('#modalEdicion').modal('hide');
	}
}	
