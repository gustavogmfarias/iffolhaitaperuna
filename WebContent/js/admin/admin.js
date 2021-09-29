"use strict";

(function() {
	$('nav.navbar .nav-link').each(function(i, link){
		var dashboardHref = urlPadrao+'adm';
		var linkHref = $(link).attr('href');
		var winHref = window.location.href;


		var isDashboard = linkHref == dashboardHref;

		if(		(!isDashboard 	&& winHref.startsWith(linkHref)) ||
				(isDashboard 	&& winHref == dashboardHref)){

			$(link).addClass('active');

			var navItem = $(link).closest('.nav-colapse-item');

			if(navItem){
				navItem.removeClass('collapsed');
				navItem.find('.collapse').addClass('show');
				navItem.find('.nav-link[data-toggle="collapse"]').attr('aria-expanded', 'true');
			}
		}
	})

	$(document).on('click', '.button-remove', function(){
		var $this = $(this);
		var url = $this.attr("data-url");
		var mensagem = $this.attr("data-message");

		new Notificacao('Atenção!', mensagem).dialogo().confirm(function(){
			document.location = url;
		});
	});

	$(document).on('click', '.button-remove-ajax', function(){
		var $this = $(this);
		var url = $this.attr("data-url");
		var mensagem = $this.attr("data-message");
		var removeClosest = $this.attr("data-remove-closest");

		new Notificacao('Atenção!', mensagem).dialogo().confirm(function(){
			$.ajax(url)
			.always(function(){
				new Notificacao('Sucesso!', '').sucesso();
				swal.close();
				if(removeClosest){
					$this.closest('.list-group-item').remove();
				}
			});
		});
	});
})();

function notificacao(background, message){
	var html = '' +
	'<div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-autohide="true">'+
		'<div class="toast-body bg-'+background+' text-white">'+
			message+
			'<button type="button" class="ml-2 mb-1 close text-white" data-dismiss="toast" aria-label="Close">'+
			  '<span aria-hidden="true">&times;</span>'+
			'</button>'+
		'</div>'+
	'</div>';

	$('.toast').remove();
	$('body').append(html);
	$('.toast').toast({delay: 3*1000}).toast('show')
}

function renderTipoUsuario(tipo){
	try{
		switch (tipo) {
			case 'ADMINISTRADOR': return 'Administrador';
			case 'FUNCIONARIO': return 'Funcionário';
			case 'MENSALISTA': return 'Mensalista';
			case 'PROFESSOR': return 'Professor';
			case 'ALUNO': return 'Aluno';
			case 'OUTRO': return 'Outro';
		}
		return '';
	}catch(err){
		console.error('function renderTipoUsuario(tipo)', tipo, err);
		return '';
	}
}
function renderDinheiro(data, type, row){
	if(data == null)
		return '';
	try{
		return parseFloat(data).emReal();
	}catch (e) {
		return '';
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

Number.prototype.emReal = function() {
	var numero = this.toFixed(2).split('.');
	numero[0] = "R$ " + numero[0].split(/(?=(?:...)*$)/).join('.');
	return numero.join(',');
};

function numeroParaReal(numero) {
	var numero = numero.toFixed(2).split('.');
	numero[0] = "R$ " + numero[0].split(/(?=(?:...)*$)/).join('.');
	return numero.join(',');
}
function numeroParaRealSemCifrao(numero) {
	var numero = numero.toFixed(2).split('.');
	numero[0] =  numero[0].split(/(?=(?:...)*$)/).join('.');
	return numero.join(',');
}

function fecharModal(modal){
	$(modal).modal('hide');
}
function closeModal(modal){
	$("#"+modal).modal('hide');
}
function abrirModal(modal){
	$(modal).modal('show');
}
function showModal(modal){
	$("#"+modal).modal('show');
}

function adicionaMensagem(mensagem){
	new Notificacao('Aten&ccedil;&atilde;o!', mensagem).sucesso();
}
function adicionaErro(erro){
	new Notificacao('Aten&ccedil;&atilde;o!', erro.responseJSON).erro();
}

function ativarCarregando(idLoading){
	carregando = false;
	jQuery('#' + idLoading).showLoading();
}
function desativarCarregando(idLoading){
	carregando = true;
	jQuery('#' + idLoading).hideLoading();
}

function renderDateMoment(data, type, row){
	if(data == null)
		return '';

	var m = moment(data.substring(0,19));
	var retorno = m.format('DD/MM/YYYY');

	if(retorno == 'Invalid date')
		return data;
	else
		return retorno;
}

function renderTipoDisponibilidade(tipo){
	try{
		switch (tipo) {
			case 'AULA': return 'Aula';
			case 'ALUGUEL': return 'Aluguel';
			case 'MENSALISTA': return 'Mensalista';
		}
		return '';
	}catch(err){
		console.error('function renderTipoDisponibilidade(tipo)', tipo, err);
		return '';
	}
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
		return retorno
}

function renderTimeMoment(data, type, row){
	if(data == null)
		return '';


	var retorno = moment(data, ["h:mm A"]).format('HH:mm');

	if(retorno == 'Invalid date')
		return data;
	else
		return retorno;
}

function openJanela(url,nomeJanela) {
	window.open(url,nomeJanela,'width=710,height=400,menubar,scrollbars,resizable');
}


function decodeEntities(s){
    var str, temp= document.createElement('p');
    temp.innerHTML= s;
    str= temp.textContent || temp.innerText;
    temp=null;
    return str;
}

function removerElementoForm(campo){
	var elemento = $("input[name*='." + campo +"'], textarea[name*='." + campo +"'], select[name*='." + campo +"'], input[name='" + campo +"'], textarea[name='" + campo +"'], select[name='" + campo +"'], checkbox[id='" + campo +"'], img[id='" + campo +"']").parents('div.control-group');
	if(elemento){
		elemento.remove();
	}
}

function renderDia(dia){
	try{
		switch (dia) {
			case 'SEGUNDA': return 'Segunda';
			case 'TERCA': return 'Terça';
			case 'QUARTA': return 'Quarta';
			case 'QUINTA': return 'Quinta';
			case 'SEXTA': return 'Sexta';
			case 'SABADO': return 'Sábado';
			case 'DOMINGO': return 'Domingo';
		}
		return '';
	}catch(err){
		console.error('function renderDia(dia)', dia, err);
		return '';
	}
}

