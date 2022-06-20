jQuery(function(){
	jQuery("#YEAR").val("2000");
	jQuery("#MONTH").val("1");
	jQuery("#DAY").val("1");
	
	//まずユーザネーム欄の入力チェック！
	jQuery("input[name='name']").blur(function(){
		//まず、スペースや改行を潰す。
		//\sは、空白文字全て、の意味。スラッシュで挟んで後ろにgつけるのはreplaceメソッド。挟んでgで全ての\Sをってなる。
		var username = jQuery(this).val().replace(/\s/g,"");
		jQuery(this).val(username);
		
		//次にNameがかぶってないかのチェック！
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
				//別の名前で登録してくださいの表示を消す。
				jQuery("span#username").text("");	
			}
		});	
	});
	//パスワードの空白も潰そ！
	jQuery("input[name='pass']").blur(function(){
		//\sは、空白文字全て、の意味。スラッシュで挟んで後ろにgつけるのはreplaceメソッド。挟んでgで全ての\Sをってなる。
		var password = jQuery(this).val().replace(/\s/g,"");
		jQuery(this).val(password);
	});
	
	//最後、日付チェック！
	jQuery("form").submit(function(){
		var y = jQuery("select[name='year']").val();
		var m = jQuery("select[name='month']").val();
		var d = jQuery("select[name='day']").val();
		var date = new Date(y, m-1, d);
		
		var month = date.getMonth() + 1;
		// 月は「0」を起点とするので今度は「+1」で調整します
		if(m==month){
			//正しい日付を入力してくださいの表示を消す。
			//でユーザネーム欄も問題なかったら、ここで送っちゃう。問題あったらここで止める。
			jQuery("span#dob").text("");
			if(jQuery("span#username").text() != "") {
				return false;
			}
		} else {
			if(jQuery("span#dob").css("font-weight") != "bold") {   //文字が入ってない場合のみ
				//正しい日付を入力してくださいと表示
				jQuery("span#dob").text("正しい日付を入力してください");
				jQuery("span#dob").css({"color":"red","font-weight":"bold"});
			}
			return false;
		}
		
	});
	
});
