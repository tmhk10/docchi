jQuery("button").click(function(){
	// もしキャンセルをクリックしたら
	if (!confirm('この投稿を削除します。よろしいですか？')) {
    	// submitボタンの効果をキャンセルし、クリックしても何も起きない
    	return false; 
	 // 「OK」をクリックした際の処理を記述
  	} else { 
		//ajax。削除。
		var formurl = jQuery(this).prop("id");
		jQuery.ajax({
			type:'GET',
			url:formurl,			
			async:true

		});
    	// HTMLに完了メッセージを表示    
    	$(this).parents(".box").html('<strong>削除しました！</strong>');
    }
 
});
