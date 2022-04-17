var token = $("meta[name='_csrf']").attr("content");

$(document).ready(function() {
			toastr.success('Are you the 6 fingered man?');
			toastr.warning('Are you the 6 fingered man?');
			toastr.info('Are you the 6 fingered man?');
			toastr.error('Are you the 6 fingered man?');
		});
		
function ajax_listar(){
	var token = $("meta[name='_csrf']").attr("content");
	nroContrato = 0;
	
	if($('#txtBuscar').val()!=''){
		nroContrato = $('#txtBuscar').val();
	}
   $.ajax({
      type : 'POST',
      headers : {"X-CSRF-TOKEN" : token},
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
				$('.modal-title').text("Agregar Contrato");
				console.log("Valor: "+ modoSelecc.val());
				if ( modoSelecc.val() == 'crear' ){
					// El modo 'crear' se atiende a través del botón 'btnCrear'
					return;
				}
				//$('#cliente').hide();
				//$('#txtnombreC').hide();	
				// Cargo los datos de la fila selecc. para modif. o elim.
				$('.modal-title').html(modoSelecc.html());
				//console.log("estoy aqui: "+ $(this).find('td').eq(1).text());
				$("#lblId").text( $(this).find('td').eq(0).text() );
				$("#txtnombreC").val( $(this).find('td').eq(1).text() );
				$("#txtFInicio").val( $(this).find('td').eq(2).text() );
				$("#txtFtermino").val( $(this).find('td').eq(3).text() );
				$("#txtperiodo").val( $(this).find('td').eq(4).text() );
				
				// Los inputs del modal quedan readonly en modo 'eliminar'
				if ( modoSelecc.val() == 'eliminar' ) {
					//$('#identificador').hide();
					$('#cliente').show();
					$('#selectName').hide();
					$('#txtnombreC').show;
					$('#inputsModal .input-sm').prop('readonly', true);
					console.log("Eliminar");
					$('#btnOk').text('Eliminar');
					$('#btnCancelar').focus();
				}
				else if(modoSelecc.val() == 'modificar') {
					$('#identificador').hide();
					$('#selectName').hide();
					//$('#txtnombreC').prop('readonly',true);
					$('#inputsModal .input-sm').prop('readonly', false);
					console.log("Modificar");
					$('#btnOk').text('Modificar');
				}
				
				// Abro el modal
				$("#modalEdicion").modal('show');
				
			})
		})
	})
	.fail( function(request) {
		toastr.error('No se pudo ejecutar "ajax:/contrato/listar"\n'+request.responseText);
   });
}

function ajax_crear() {
	toastr.options = {
				  "closeButton": true,
				  "debug": false,
				  "newestOnTop": true,
				  "progressBar": true,
				  "positionClass": "toast-top-right",
				  "preventDuplicates": false,
				  "onclick": null,
				  "showDuration": "3000",
				  "hideDuration": "1000",
				  "timeOut": "5000",
				  "extendedTimeOut": "1000",
				  "showEasing": "swing",
				  "hideEasing": "linear",
				  "showMethod": "fadeIn",
				  "hideMethod": "fadeOut"
				}
   $.ajax({
      type : 'POST',
      headers : {"X-CSRF-TOKEN" : token},
      url  : '/contrato/crear',
      data : { nIdCliente: $('#sel1').val(), 
      			fDesde: $('#txtFInicio').val(),
      			fHasta: $('#txtFtermino').val(),
      			nPeriodicidad: $('#txtperiodo').val(),
      			
      		 }
      		 
   })
   .done( function (resp) {
      if ( resp == '' )
         //alert('Hubo un error al intentar crear el contrato.');
         toastr.error('Hubo un error al intentar crear el contrato.');
      else 
			//alert('Se creó el contrato.');
			toastr.success('Se creó el contrato.');
			ajax_listar();
   })
   .fail( function (request) {
   	toastr.error('No se pudo ejecutar "ajax:/contrato/crear"\n'+request.responseText);
   })
}

function ajax_modificar() {
   $.ajax({
      type : 'POST',
       headers : {"X-CSRF-TOKEN" : token},
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
        toastr.error('Hubo un error al intentar modificar.');
      else 
			//alert('Se modificó el contrato.');
			toastr.success('Se modificó el contrato.');
			ajax_listar();
   })
   .fail( function (request) {
		toastr.error('No se pudo ejecutar "ajax:/contrato/modificar"\n'+request.responseText);
   })
}

function ajax_eliminar() {
   $.ajax({
      type : 'POST',
       headers : {"X-CSRF-TOKEN" : token},
      url  : 'contrato/eliminar',
      data : {id: $("#lblId").text()}
   })
   .done( function (resp) {
         if ( resp == '' )
            toastr.error('Hubo un error al intentar contrato.');
         else 
			toastr.success('Se eliminó el contrato.');
			ajax_listar();
   })
   .fail( function (request) {
         toastr.error('No se pudo ejecutar "ajax:/contrato/eliminar"\n'+request.responseText);
   })
}

function ajax_consultar() {
   $.ajax({
      type : 'POST',
       headers : {"X-CSRF-TOKEN" : token},
      url  : '/clientes/consultar',
      data : {id: $('#lblId').text()}
   })
   .done( function (resp) {
		if ( resp == '' )
         toastr.error('Hubo un error al intentar consultar.');
   })
   .fail( function (request) {
     toastr.error('No se pudo ejecutar "ajax:/clientes/consultar"\n'+request.responseText);
   })
}

function nuevoCliente() {
	// Limpio campos del modal
	$('#sel1').empty();
	$('#sel1').append("<option value='seleccione'>Seleccione</option>");
	$('.modal-title').text("Agregar Contrato");
	console.log("Valor: "+ modoSelecc.val());
	console.log("Crear");
	$('#btnOk').text('Grabar');
	$.ajax({
      type : 'POST',
       headers : {"X-CSRF-TOKEN" : token},
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
         toastr.error('Hubo un error al intentar consultar.');
   })
   .fail( function (request) {
      toastr.error('No se pudo ejecutar "ajax:/clientes/consultar"\n'+request.responseText);
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
	}

	if ( err == '' ) {
		ajax_listar();
		$('#modalEdicion').modal('hide');
	}
}	
