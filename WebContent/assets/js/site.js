"use strict";



(function() {

	$(document).on('change','.button-paginate', function(){
			var link = $(this).children('option:selected').attr('data-link');
			document.location.href = link;
		});


})();

