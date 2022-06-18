jQuery(function(){
	jQuery(".pictures").mousedown(function(){
		jQuery(this).css("opacity",0.5);
	});
});



jQuery(function() {
	jQuery("a#pictinfo").click(function(e){
		e.preventDefault();
		var formurl = jQuery(this).prop("href");
		jQuery.ajax({
			type:'GET',
			url:formurl,			
			async:true,
			dataType:'json'

		})
		.done(function(json) {
			var data_stringify = JSON.stringify(json);
      		var data = JSON.parse(data_stringify);
      		jQuery("div.numbers").each(function(){
				if(jQuery(this).prop("id") == data.id) {
					jQuery(this).html(data.vote1 + "票&emsp;" + data.vote2 + "票");
				}
			});

		});		
		jQuery(this).parent().find("a").attr("href","javascript:void(0)");
		return false;
	});
	
});