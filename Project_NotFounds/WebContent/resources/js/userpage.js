/**
 * 
 */

jQuery(document).ready(function($) {
	var count =0;
	Date.prototype.format = function(f) {
	    if (!this.valueOf()) return " ";
	 
	    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
	    var d = this;
	     
	    return f.replace(/(MM|dd|E|hh|mm|a\/p)/gi, function($1) {
	        switch ($1) {
	            case "MM": return (d.getMonth() + 1).zf(2);
	            case "dd": return d.getDate().zf(2);
	            case "E": return weekName[d.getDay()];
	            case "HH": return d.getHours().zf(2);
	            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
	            case "mm": return d.getMinutes().zf(2);
	            case "a/p": return d.getHours() < 12 ? "am" : "pm";
	            default: return $1;
	        }
	    });
	};
	 
	String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
	String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
	Number.prototype.zf = function(len){return this.toString().zf(len);};
	
	
	// get recentlist 
	  $.ajax({
          url: './recentlist/'+$("#page_id").val(),
          type: "GET",
          dataType: "text",
          // cache: false,
          processData: false,
          contentType: false,
          success: function(data, textStatus, jqXHR) {
        	  var newArr = JSON.parse(data);
        	  if(newArr.length != 0){
				   var value = newArr.pop();
				   $('#recentlist').empty();
				   $('#recentlist').append(
						   '<a>'
							   +'<table id = "perfrom_State">'
							   		+'<tr >'
							   			+'<td class ="music_icon"><i class="fa fa-check" aria-hidden="true"></i></td>'
							   			+'<td><p class="music_singer">'+value.maptitle+'</p></td>'
							   			+'<td class="music_name"><p class ="perform_contents">'+value.mapcontents+'</p></td>'
							   			+'<td><p class="music_name">'
							   				+new Date(value.map_starttime).format("MM-dd HH:mm")
							   				+' ~ '
							   				+ new Date(value.map_endtime).format("MM-dd HH:mm")
							   			+'</td>'
							   		+'</tr>'
							   	+'</table>'
							+'</a>'
				   );	
              }
          }, error: function(jqXHR, textStatus, errorThrown) {
         	 console.log('upcomming error');
          }
      });
	  
		  
		// get upcomming 
	  $.ajax({
          url: './upcomming/'+$("#page_id").val(),
          type: "GET",
          dataType: "text",
          // cache: false,
          processData: false,
          contentType: false,
          success: function(data, textStatus, jqXHR) {
        	  var newArr = JSON.parse(data);
        	  var length = newArr.length;
        	  if(length != 0){
        		  $('#upcomminglist').empty();
        	  }
        	  for(var i=0; i<length; ++i){
        		  var value = newArr.pop();
				   $('#upcomminglist').prepend(
						   '<a>'
							   +'<table id = "perfrom_State">'
							   		+'<tr >'
							   			+'<td class ="music_icon"><i class="fa fa-calendar-check-o" aria-hidden="true"></i></td>'
							   			+'<td><p class="music_singer">'+value.maptitle+'</p></td>'
							   			+'<td class="music_name"><p class ="perform_contents">'+value.mapcontents+'</p></td>'
							   			+'<td><p class="music_name">'
							   				+new Date(value.map_starttime).format("MM-dd HH:mm")
							   				+' ~ '
							   				+ new Date(value.map_endtime).format("MM-dd HH:mm")
							   			+'</td>'
							   		+'</tr>'
							   	+'</table>'
							+'</a>'
				   );	
        	  }
          }, error: function(jqXHR, textStatus, errorThrown) {
         	 console.log('upcomming error');
          }
      });
	  
	  
	
	$(".back_img").on('click',function(){
		$("#input_backimg").click();
		
	});
	
	$('#input_backimg').live('change',function() {
        var data = new FormData();
        $.each($('#input_backimg')[0].files, function(i, file) {          
            data.append('file-' + i, file);
        });
        data.append("page_id",$("#page_id").val());
        $.ajax({
            url: './backimg',
            type: "POST",
            dataType: "text",
            data: data,
            // cache: false,
            processData: false,
            contentType: false,
            success: function(data, textStatus, jqXHR) {
            	if(data == "Seccess"){
            		location.reload();
            	}else{
            		alert('잘못된 접근입니다.');
            	}
            }, error: function(jqXHR, textStatus, errorThrown) {
           	 
            }
        });
    });
	
	
	$(".user_img").on('click',function(){
			$("#input_proimg").click();
	});

	
	$('#input_proimg').live('change',function() {
        var data = new FormData();
        $.each($('#input_proimg')[0].files, function(i, file) {          
            data.append('file-' + i, file);
        });
        data.append("page_id",$("#page_id").val());
        $.ajax({
            url: './userimg',
            type: "POST",
            dataType: "text",
            data: data ,
            // cache: false,
            processData: false,
            contentType: false,
            success: function(data, textStatus, jqXHR) {
            	if(data == "Seccess"){
            		location.reload();
            	}else{
            		alert('잘못된 접근입니다.');
            	}
           	
            }, error: function(jqXHR, textStatus, errorThrown) {
           	 
            }
        });
    });
	
	// sing_edit click option
	
	$("#sing_edit").on('click',function(){
		// 작성하는 form 을 만들어야한다 . + 삭제 하는 마크 또한 만들어야한다 .  
		if(count%2 == 1){
			$("#sing_form").hide();
		}else{
			$("#sing_form").show();
		}
		count ++;
	});
	
	$("#sing_submit").on('click',function(){
		var data = new FormData();
		data.append("singer",$("#sing_singer").val());
		data.append("title",$("#song_title").val());
		  $.ajax({
	            url: './songedit',
	            type: "POST",
	            dataType: "text",
	            data: data ,
	            // cache: false,
	            processData: false,
	            contentType: false,
	            success: function(data, textStatus, jqXHR) {
	            	if(data == ""){
	            		$("#errormessage").append("7개 이상 등록할 수 없습니다.");
	            	}else{
		            	$("#song_list" ).empty();
		                   var newArr = JSON.parse(data);
		                   for(var i =0; i< newArr.length ; ++i){
		                	   var value = newArr.pop();
			            		$('#song_list').append("<a><table><tr><td class ='music_icon'><i class='fa fa-music' aria-hidden='true'></i></td><td class='music_name'><p class ='music_fonts'>"+value.song_name +"</p></td><td><p class='music_singer'>"+value.song_singer+"</p></td></tr></table></a>");
		                   }
	            	}
	            }, error: function(jqXHR, textStatus, errorThrown) {
	           	 
	            }
	        });
	});
	
	
		
	
});