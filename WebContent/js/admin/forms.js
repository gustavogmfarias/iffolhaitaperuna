var DEBUG = true;
(function(){
	console.groupCollapsed('forms.js');
	$( ".focus" ).focus();
	iniciarFuncoesForm();
	console.groupEnd();
})();


function iniciarFuncoesForm(){
	iniciarMeioMask();
	iniciarValidacao();
	iniciarTextarea();
	iniciarInputDate();
	iniciarInputTime();
	iniciarSelect();
	iniciarInputDateTime();

	iniciarInputFile();


}

function iniciarInputFile(){

	$(".file-imagem").each(function(){
		console.log('entrou');

		var elemento = $(this);

		var opcoes = {
					language:'pt-BR',
					theme: 'fa',
					dropZoneEnabled: false,
					showUpload:false,
					showCancel:false,
					initialPreviewShowDelete:false,
					browseClass:'btn btn-default'
				};

			var initial = $(this).attr('data-initialPreview');

				if(initial != undefined && initial != null && initial != 'null'){
					var json = JSON.parse(initial.replace(/'/g,'"'));


					var preview = [];
					var config = [];
					$.each(json, function(i, arquivo){
						if(arquivo != '' && (arquivo.urlCompleta.includes('.') || arquivo.nome != '')){
							var urlCompleta = arquivo.urlCompleta;

							preview.push('<img src="'+urlCompleta+'" class="file-preview-image kv-preview-data" style="width:auto;height:160px;" alt="'+arquivo.nome+'" title="'+arquivo.nome+'" />');
							config.push({
								caption: arquivo.nome,
								size: arquivo.tamanho
							});
						}
					});
					opcoes.initialPreview = preview;
					opcoes.initialPreviewConfig = config;
				}
		elemento.fileinput(opcoes);


	});




}


function iniciarSelect(){
	if(DEBUG) console.log('select inputinit');
    $('.custom-select').selectpicker(
	{liveSearchStyle:
	'startsWith'});
}


function iniciarInputDate(){
	if(DEBUG) console.log('date inputinit');
	try{

		$('.custom-date').attr('autocomplete', 'off');
		$('.custom-date').each(function() {
		    $(this).flatpickr({
		    	dateFormat: "d/m/Y",
		    	locale : "pt",
    			time_24hr: true,
    			allowInput: true
		    });
		});
	}catch(e){
		console.error('Falha iniciando meiomask!', e)
	}
}
function iniciarInputTime(){
	if(DEBUG) console.log('time inputinit');
	try{
		$('.custom-time').attr('autocomplete', 'off');
		$('.custom-time').each(function() {
		    $(this).flatpickr({
		    	enableTime: true,
			    noCalendar: true,
			    dateFormat: "H:i",
			    time_24hr: true,
		    	locale : "pt",
    			allowInput: true
		    });
		});
	}catch(e){
		console.error('Falha iniciando meiomask!', e)
	}
}

function iniciarInputDateTime(){
	if(DEBUG) console.log('date inputinit');
	try{
		$('.custom-date-time').attr('autocomplete', 'off');
		$('.custom-date-time').each(function() {
		    $(this).flatpickr({
		    	dateFormat: "d/m/Y H:i",
		    	enableTime: true,
		    	locale : "pt",
    			time_24hr: true,
    			allowInput: true
		    });
		});
	}catch(e){
		console.error('Falha iniciando meiomask!', e)
	}
}

function iniciarMeioMask(){
	if(DEBUG) console.log('meio mask init');
	try{
		$('input[alt]').each(function() {
			$(this).setMask();
		});
	}catch(e){
		console.error('Falha iniciando meiomask!', e)
	}
}

function iniciarTextarea(){
	if(DEBUG) console.log('textarea init');
	try{
		$('.custom-html').attr('autocomplete', 'off');
		$('.custom-html').summernote({
			minHeight: 600,
			lang: 'pt-BR',
			codemirror: {},
			toolbar: [
				['um', ['undo', 'redo']],
				['dois', ['fontname']],
				['tres', ['fontsize']],
				['quatro', ['bold', 'italic', 'underline']],
				['cinco', ['paragraph', 'ol', 'ul']],
				['seis', ['clear', 'codeview','picture', 'video', 'link']],
			],
		});
	}catch(e){
		console.error('Falha iniciando html textarea!', e)
	}
}

function iniciarValidacao(form){
	if(DEBUG) console.log('validacao de form init')

	var putError = function (element, errorClass, validClass) {
		var $element = $(element);
		var $group = $element.closest(".form-group");

		$element.addClass('is-invalid').removeClass('is-valid');
		$group.addClass('is-invalid').removeClass('is-valid');

	}
	var removeError = function (element, errorClass, validClass) {
		var $element = $(element);
		var $group = $element.closest(".form-group");

		$element.removeClass('is-invalid').addClass('is-valid');
		$group.removeClass('is-invalid').addClass('is-valid');
		$group.find('.invalid-feedback').remove();
	}
	try{
		if(form == null)
			form = $('.validateForm');

		console.log(form);

		$.validator.setDefaults({
		    ignore: '.novalidate',
		    errorClass: 'is-invalid',
		    validClass: 'is-valid',
		    highlight: putError,
			unhighlight: removeError,
		    errorPlacement: function(error, element) {
		    	var group = element.closest(".form-group");
		    	group.find('.invalid-feedback').remove();
		    	error.removeClass('is-invalid').addClass('invalid-feedback').appendTo(group);
			}
		});

		return form.validate();
	}catch(e){
		console.error('Falha iniciando validate!', e)
	}
}
