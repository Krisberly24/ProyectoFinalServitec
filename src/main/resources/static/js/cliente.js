function ajax_listar(){
   $.ajax({
      type : 'POST',
      url  : '/clientes/listar'
   })
   .done( function(resp) {
		// Cargo los datos en '#tablaDatos'
		var tbody = '';
		for ( let i=0; i < resp.length; i++) {
			tbody += '<tr>';

			for ( let k in resp[i] )
				tbody += '<td>' + resp[i][k] + '</td>';

			tbody += '</tr>';
		}
		$('#tablaDatos tbody').html(tbody);

		$(document).ready(function() {
			// Programo el evento clic sobre una fila de datos 
			$("#tablaDatos tbody").on('click','tr', function() {
				if ( modoSelecc.val() == 'crear' )
					// El modo 'crear' se atiende a través del botón 'btnCrear'
					return;
					
				// Cargo los datos de la fila selecc. para modif. o elim.
				$('.modal-title').html(modoSelecc.html()+' cliente');
				
				$("#lblId").text( $(this).find('td').eq(0).text() );
				$("#txtRut").val( $(this).find('td').eq(1).text() );
				$("#txtNombre").val( $(this).find('td').eq(2).text() );
				$("#txtDireccion").val( $(this).find('td').eq(3).text() );
				$("#txtFono").val( $(this).find('td').eq(4).text() );
				$("#txtEmail").val( $(this).find('td').eq(5).text() );
				
				// Abro el modal
				$("#modalEdicion").modal('show');
				
				// Los inputs del modal quedan readonly en modo 'eliminar'
				if ( modoSelecc.val() == 'eliminar' ) {
					$('#inputsModal .input-sm').prop('readonly', true);
					$('#btnOk').text('Eliminar');
					$('#btnCancelar').focus();
				}
				else {
					$('#inputsModal .input-sm').prop('readonly', false);
					$('#btnOk').text('Grabar');
					$('#txtRut').focus();
				}
			})
		})
	})
	.fail( function(request) {
		alert('No se pudo ejecutar "ajax:/clientes/listar"\n'+request.responseText);
   });
}

function ajax_crear() {
   $.ajax({
      type : 'POST',
      url  : '/clientes/crear',
      data : { rut: $('#txtRut').val(), 
      			nombre: $('#txtNombre').val(),
      			direccion: $('#txtDireccion').val(),
      			fono: $('#txtFono').val(),
      			email: $('#txtEmail').val(),
      		 }
   })
   .done( function (resp) {
      if ( resp == '' )
         alert('Hubo un error al intentar crear el cliente.');
      else 
			alert('Se creó el cliente.');
   })
   .fail( function (request) {
   	alert('No se pudo ejecutar "ajax:/clientes/crear"\n'+request.responseText);
   })
}

function ajax_modificar() {
   $.ajax({
      type : 'POST',
      url  : '/clientes/modificar',
      data : { id:  $('#lblId').text(),
					rut: $('#txtRut').val(), 
      			nombre: $('#txtNombre').val(),
      			direccion: $('#txtDireccion').val(),
      			fono: $('#txtFono').val(),
      			email: $('#txtEmail').val(),
      		 }
   })
 	.done( function (resp) {
      if ( resp == 0 )
         alert('Hubo un error al intentar modificar.');
      else 
			alert('Se modificó el cliente.');
   })
   .fail( function (request) {
      alert('No se pudo ejecutar "ajax:/clientes/modificar"\n'+request.responseText);
   })
}

function ajax_eliminar() {
   $.ajax({
      type : 'POST',
      url  : '/clientes/eliminar',
      data : {id: $('#lblId').text()}
   })
   .done( function (resp) {
         if ( resp == '' )
            alert('Hubo un error al intentar eliminar.');
         else 
				alert('Se eliminó el cliente.');
   })
   .fail( function (request) {
         alert('No se pudo ejecutar "ajax:/clientes/eliminar"\n'+request.responseText);
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
		if ( confirm('Confirme la eliminación de este cliente.') )
			ajax_eliminar();
		else
			err = '!'
	else {
		err = validar_datos();
		
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

function validar_datos() {
	// Retorna '' si todo ok. Si hay un error, retorna un mensaje que lo describe. 
	let rut = $('#txtRut').val().trim(); 
	let nombre = $('#txtNombre').val().trim();
	let direcc = $('#txtDireccion').val().trim();
	let fono = $('#txtFono').val().trim();
	let email = $('#txtEmail').val().trim();
	
	let msg = '';
	if ( isNaN(rut) )
		msg = 'Sólo números en el Rut.';
	else if ( parseInt(rut) < 10)
		msg = 'Al menos 2 dígitos en el Rut.';
	else if ( nombre == '' )
		msg = 'Debe indicar el nombre.';
	else if ( direcc == '' )
		msg = 'Debe indicar la dirección.';
	else if ( fono == '' )
		msg = 'Indique algún teléfono.';
	else if ( email == '' )
		msg = 'Indique algún correo electrónico.';
	else if ( !(/\S+@\S+\.\S+/).test(email) )
		msg = 'El correo electrónico indicado no es correcto.';
	
	return msg;
}
