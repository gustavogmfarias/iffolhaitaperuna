function confirmPaginateFuncion(url, message){
	new Notificacao('Atenção!', message?message:'Vai excluir?').dialogo().confirm(function(){
		window.location = url;
	});
}
/*
 * Paginate.js - a nds library
 */
$.fn.DataTable.ext.errMode = 'none';

function Paginate(idTable) {

	var datatable;

	var url;
	var form;
	var initParams = {
		"rowId": 		"id",
//		"ajax": 		url,
		"columns": 		[],
//		"destroy": 		true,
//		"retrieve": 	false,
//		"searching": 	true,
//		"autoWidth": 	false,
		"serverSide": 	true,
		"processing": true,
		"dom":
			"<'row'<'col-sm-12 col-md-12'l>>" +
			"<'row'<'col-sm-12'tr>>" +
			"<'row'<'col-sm-12 col-md-5'i><'col-sm-12 col-md-7'p>>",
		"language": {
		    "sEmptyTable": "Nenhum registro encontrado",
		    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
		    "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
		    "sInfoFiltered": "(Filtrados de _MAX_ registros)",
		    "sInfoPostFix": "",
		    "sInfoThousands": ".",
		    "sLengthMenu": "_MENU_ resultados por página",
		    "sLoadingRecords": "Carregando...",
		    "sProcessing": "Processando...",
		    "sZeroRecords": "Nenhum registro encontrado",
		    "sSearch": "Pesquisar",
		    "oPaginate": {
		        "sNext": "Próximo",
		        "sPrevious": "Anterior",
		        "sFirst": "Primeiro",
		        "sLast": "Último"
		    },
		    "oAria": {
		        "sSortAscending": ": Ordenar colunas de forma ascendente",
		        "sSortDescending": ": Ordenar colunas de forma descendente"
		    }
		}
	};


	return {
		getDatatable: function(){
			return datatable;
		},
		url: function(pUrl) {
			url = pUrl;
			return this;
		},
		columns: function(columns) {
			initParams.columns = columns;
			return this;
		},
		buttons: function(buttons) {
			var render = function(data, type, row, meta){
				return $(buttons).map(function(i, item){
					if(!item)
						return '';

					var url = eval("'"+item.url.replace(/{(.*?)}/gm, "'+row.$1+'")+"'");

					if(item.confirm){
						return '<a href="javascript:confirmPaginateFuncion(\''+url+'\', \''+item.confirmMessage+'\');" title="'+item.title+'" class="btn btn-sm btn-outline-'+(item.warning?'warning':'secondary')+' mr-2">'+
									'<i class="fa-fw '+item.icon+'"></i>'+
								'</a>';
					}else{
						return '<a href="'+url+'" title="'+item.title+'" class="btn btn-sm btn-outline-'+(item.warning?'warning':'secondary')+' mr-2">'+
									'<i class="fa-fw '+item.icon+'"></i>'+
							   '</a>';
					}
				}).get().join('');
			};

			initParams.columns.push({ "title": "", "data": "", "orderable": false, "render": render});
			return this;
		},
		form: function(pIdForm) {
			if(pIdForm && $('#'+pIdForm).length > 0){
				form = $('#'+pIdForm);
				form.on('submit', function(e){

					datatable.ajax.url(url + "?" + form.serialize()).load();

					e.preventDefault();
					e.stopPropagation();
					return false;
				});
			}
			return this;
		},
		start: function() {
			try {

				var urlAjax = url;

				if(form){
					urlAjax = urlAjax + "?" + form.serialize();
				}

				initParams.ajax = urlAjax;

				datatable = $('#' + idTable).DataTable(initParams);

			}catch(err){
				console.error(err);
			}
		}
	}
}


/***** renders ********************/
function renderStatus(data, type, row){
	if(data == 'ATIVO')
		return '<label class="label label-primary label-outline">Ativo</label>';
	if(data == 'INATIVO')
		return '<label class="label label-danger label-outline">Inativo</label>';
	if(data == 'PENDENTE')
		return '<label class="label label-warning label-outline">Pendente</label>';
	return '';
}
function renderActive(data, type, row){
	return renderBoolean(data, type, row);
}
function renderBoolean(data, type, row){
	if(data == true)
		return '<label class="badge badge-pill badge-success p-2 pl-3 pr-3">Sim</label>';
	return '<label class="badge badge-pill badge-danger p-2 pl-3 pr-3">N&atilde;o</label>';
}
function renderObjeto(data, type, row){
	if(data == null)
		return '';
	return data;
}
function renderDateMoment(data, type, row){
	if(data == null || !data)
		return '';

	var m = moment(data.substring(0,19));

	var retorno = m.format('DD/MM/YYYY');

	if(retorno == 'Invalid date')
		return data;
	else
		return retorno;
}
function renderDateTimeMoment(data, type, row){
	if(data == null)
		return '';
	var dateFormat = new Date(data);
	var m = moment(dateFormat);
	var retorno = m.format('DD/MM/YYYY HH:mm');

	if(retorno == 'Invalid date')
		return data;
	else
		return retorno;
}

function renderTimeMoment(data, type, row){
	if(data == null)
		return '';

	//var dateFormat = Date.parseExact(data, 'Hh:mm:ss');
	//var m = moment(dateFormat);
	//var retorno = m.format('HH:mm');

//	var retorno = moment(data, 'HH:mm', true);

//	if(retorno == 'Invalid date')
//		return data;
//	else
	return data;
}

function renderDinheiro(data, type, row){
	if(data == null)
		return '-';

	try{
		return 'R$ ' + parseFloat(data).toFixed(2);
	}catch (e) {
		return '-';
	}
}
function renderDecimal(data, type, row){
	if(data == null)
		return '';

	try{
		return parseFloat(data).toFixed(2);
	}catch (e) {
		return '';
	}
}

function renderDecimal1(data, type, row){
	if(data == null)
		return '';

	try{
		return parseFloat(data).toFixed(1);
	}catch (e) {
		return '';
	}
}

function renderDateMomentDiaSemana(data, type, row){
	if(data == null)
		return '';

	var m = moment(data.substring(0,19), 'DD/MM/YYYY');
	var retorno = m.format('DD/MM/YYYY (dddd)');

	if(retorno == 'Invalid date')
		return data;
	else
		return retorno;
}

function renderAtivo(data, type, row) {
	return renderActive(data, type, row);
}


function convert_to_24h(time_str) {
    // Convert a string like 10:05:23 PM to 24h format, returns like [22,5,23]
    var time = time_str.match(/(\d+):(\d+):(\d+) (\w)/);
    var hours = Number(time[1]);
    var minutes = Number(time[2]);
    var seconds = Number(time[3]);
    var meridian = time[4].toLowerCase();

    if (meridian == 'p' && hours < 12) {
      hours += 12;
    }
    else if (meridian == 'a' && hours == 12) {
      hours -= 12;
    }
    return (hours<10?'0':'')+hours+":"+(minutes<10?'0':'')+minutes;
  };