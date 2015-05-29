//
$('document').ready(function() {
	////Asignacion del plugin de autocomplete
	/// Jquery
	//TODO:Externalizar la direccion url
	$('#nombreUsuarioResponsable').autocomplete({
		serviceUrl: '/Inventario/equipo/buscarUsuario.html',
		paramName: "apellido",
		delimiter: ",",
		onSelect: function (suggestion) {
			$('input#idNombreUsuarioResponsable').val(suggestion['data']);
			console.log("seleccionado " + $('input#idNombreUsuarioResponsable').val());
		} 
		,
	    transformResult: function(response) {
	        return {
	            suggestions: $.map($.parseJSON(response), function(item) {
	                return { value: item.tagName, data: item.id };
	            })
	        };
	    }
	});
	
});

