jQuery(function(){
	jQuery(".pictures").click(function(){
		jQuery(this).css("opacity",0.3);
	});
});



jQuery(function() {
	jQuery("form").submit(function(e){
		e.preventDefault();
		var formurl = jQuery(this).prop("action");
		jQuery.ajax({
			type:'GET',
			url:formurl,
			
			async:true
		
		});
		return false;
	});
	
});