function getListCentroDirectivo() {
	var ministerioId = $("#listMinisterio").find(":selected").val();
	$('#listCentroDirectivo')
		.find('option')
		.remove()
		.end();

	$('#listCentroDirectivo').append('<option value=""></option>');

	if (ministerioId != null && ministerioId != "") {

		$.ajax({
			type: "GET",
			url: "/publico/ajax/list/combo/ministerio/" + ministerioId + "/centrodirectivo",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					$('#listCentroDirectivo').append('<option value="' + datos.key + '">' + datos.value + '</option>');
				});
			}
		});
	} else {
		$.ajax({
			type: "GET",
			url: "/publico/ajax/list/combo/ministerio/centrodirectivo",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					$('#listCentroDirectivo').append('<option value="' + datos.key + '">' + datos.value + '</option>');
				});
			}
		});
	}
}

function getListUnidad() {
	var ministerioId = $("#listMinisterio").find(":selected").val();
	var centroDirectivoId = $("#listCentroDirectivo").find(":selected").val();
	$('#listUnidad')
		.find('option')
		.remove()
		.end();

	$('#listUnidad').append('<option value=""></option>');

	if (ministerioId != null && ministerioId != "" && (centroDirectivoId == null || centroDirectivoId == "")) {

		$.ajax({
			type: "GET",
			url: "/publico/ajax/list/combo/ministerio/" + ministerioId + "/centrodirectivo/unidad",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					$('#listUnidad').append('<option value="' + datos.key + '">' + datos.value + '</option>');
				});
			}
		});
	}
	else if (centroDirectivoId != null && centroDirectivoId != "") {
		$.ajax({
			type: "GET",
			url: "/publico/ajax/list/combo/ministerio/centrodirectivo/" + centroDirectivoId + "/unidad",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					$('#listUnidad').append('<option value="' + datos.key + '">' + datos.value + '</option>');
				});
			}
		});
	}

	else {
		$.ajax({
			type: "GET",
			url: "/publico/ajax/list/combo/ministerio/centrodirectivo/unidad",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					$('#listUnidad').append('<option value="' + datos.key + '">' + datos.value + '</option>');
				});
			}
		});
	}
}

function getListProvincia() {
	var comunidadAutonomaId = $("#listComunidadAutonoma").find(":selected").val();
	$('#listProvincia')
		.find('option')
		.remove()
		.end();

	$('#listProvincia').append('<option value=""></option>');


	if (comunidadAutonomaId != null && comunidadAutonomaId != "") {

		$.ajax({
			type: "GET",
			url: "/publico/ajax/list/combo/comunidadautonoma/" + comunidadAutonomaId + "/provincia",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					$('#listProvincia').append('<option value="' + datos.key + '">' + datos.value + '</option>');
				});
			}
		});
	} else {
		$.ajax({
			type: "GET",
			url: "/publico/ajax/list/combo/comunidadautonoma/provincia",
			dataType: "json",
			success: function(datos) {
				datos.forEach(function(datos) {
					$('#listProvincia').append('<option value="' + datos.key + '">' + datos.value + '</option>');
				});
			}
		});
	}
}


function changeProductividad() {
	var productividad = $("#listSalarioProductividad").find(":selected").val();


	if (productividad != null && productividad != "" && productividad == 1) {
		$("#listSalarioProductividadEspacioTemporalId").removeAttr("disabled");
		$("#salarioProductividadCuantia").removeAttr("disabled");
	} else {
		$("#listSalarioProductividadEspacioTemporalId").val("");
		$("#listSalarioProductividadEspacioTemporalId").prop("disabled", "disabled");
		$("#salarioProductividadCuantia").val("");
		$("#salarioProductividadCuantia").prop("disabled", "disabled");
	}
}

function changePrimaBufanda() {
	var prima = $("#listSalarioPrimaBufanda").find(":selected").val();
	if (prima != null && prima != "" && prima == 1) {
		$("#salarioPrimaBufandaExplicacion").removeAttr("disabled");
	} else {
		$("#salarioPrimaBufandaExplicacion").val("");
		$("#salarioPrimaBufandaExplicacion").prop("disabled", "disabled");
	}
}

function changeComisionServicioNivel() {
	var comision = $("#listSalarioComisionServicioNivel").find(":selected").val();
	if (comision != null && comision != "" && comision == 1) {
		$("#salarioComisionServicioNivelExplicacion").removeAttr("disabled");
	} else {
		$("#salarioComisionServicioNivelExplicacion").val("");
		$("#salarioComisionServicioNivelExplicacion").prop("disabled", "disabled");
	}
}

function movimientoBusquedaSalario() {
	var minimo = $("#salarioBrutoMinimo").val();
	var maximo = $("#salarioBrutoMaximo").val();
	if (minimo >= maximo) {
		minimo = maximo - 1;
		$("#salarioBrutoMinimo").val(minimo);
	}
	$("#valBusquedaSalarioMinimo").text(minimo + "€");
	$("#valBusquedaSalarioMaximo").text(maximo + "€");

}


