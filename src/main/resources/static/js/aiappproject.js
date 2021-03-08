window.onload = function() {
   	$('.ui.dropdown').dropdown();
	$('#langdropdown').on('change',function(lang){
		alert("lang changed");
		$.ajax({
			type: 'POST',
			data: { lang: lang },
			datatype: 'json',
			url: 'languageAjax',
			async: false,
			success: function(data) {
				console.log(data);
				setTimeout(function() {
					window.location.reload();
				}, 100);
			},
			error: function(xhr, status, error) {
			}
		});
	});
};


