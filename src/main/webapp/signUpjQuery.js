jQuery(function(){
	jQuery("#YEAR").val("2000");
	jQuery("#MONTH").val("1");
	jQuery("#DAY").val("1");
	
	//Nameがかぶってないかのチェック！
	jQuery("input[name='name']").blur(function(){
		jQuery.ajax({
			type:'GET',
			url:"/docchi/CheckUserNameServlet",			
			async:true,
			data: {"userName" : jQuery("input[name='name']").val()},
			dataType:'json'
		})
		.done(function(json) {
			var data_stringify = JSON.stringify(json);
      		var data = JSON.parse(data_stringify);
			if(data.result == 1){
				if(jQuery("span#username").css("font-weight") != "bold") {   //文字が入ってない場合のみ
					//別の名前で登録してくださいと表示
					jQuery("span#username").text("その名前は使われています。別の名前で登録してください。");
					jQuery("span#username").css({"color":"red","font-weight":"bold"});					
				}
			}else {
				if(jQuery("span#username").css("font-weight") == "bold") {   //文字が入ってる場合のみ
					//別の名前で登録してくださいの表示を消す。
					jQuery("span#username").text("");
				}
			}
		});	
	});
	
	jQuery("button").click(function(){
		//まず日付チェック！
		var y = jQuery("select[name='year']").val();
		var m = jQuery("select[name='month']").val();
		var d = jQuery("select[name='day']").val();
		var date = new Date(y, m-1, d);
		
		var month = date.getMonth() + 1;
		// 月は「0」を起点とするので今度は「+1」で調整します
		if(m==month){
			//何もなし。文字消すだけ。
			if(jQuery("span#dob").css("font-weight") == "bold") {   //文字が入ってる場合のみ
				//正しい日付を入力してくださいの表示を消す。
				jQuery("span#dob").text("");
			}
		} else {
			if(jQuery("span#dob").css("font-weight") != "bold") {   //文字が入ってない場合のみ
				//正しい日付を入力してくださいと表示
				jQuery("span#dob").text("正しい日付を入力してください");
				jQuery("span#dob").css({"color":"red","font-weight":"bold"});
			}
			
		}
		
/*		//次にNameがかぶってないかのチェック！
		jQuery.ajax({
			type:'GET',
			url:"/docchi/CheckUserNameServlet",			
			async:true,
			data: {"userName" : jQuery("input[name='name']").val()},
			dataType:'json'
		})
		.done(function(json) {
			var data_stringify = JSON.stringify(json);
      		var data = JSON.parse(data_stringify);
			if(data.result == 1){
				if(jQuery("span#username").css("font-weight") != "bold") {   //文字が入ってない場合のみ
					//別の名前で登録してくださいと表示
					jQuery("span#username").text("その名前は使われています。別の名前で登録してください。");
					jQuery("span#username").css({"color":"red","font-weight":"bold"});					
				}
			}else {
				if(jQuery("span#username").css("font-weight") == "bold") {   //文字が入ってる場合のみ
					//別の名前で登録してくださいの表示を消す。
					jQuery("span#username").text("");
				}
			}
		});	
*/
			
		
	});
	if(jQuery("span#dob").text().length == 0 && jQuery("span#username").text().length == 0) {
			jQuery("button").submit();
	}
});
