
console.log("Reply module");

var replyService = (() => {
	function add(reply,callback,error){
		$.ajax({
			type : "post",
			url : "/replies/new",
			data : JSON.stringify(reply),
			contentType : "application/json;charset=utf-8",
			success : function(result){
				if(callback) callback(result); 
			}, 
			error : function(er){
				if(error) error(er); 
			}
		}); 
	}

	// 댓글 목록 
	var getList = (param, callback, error) =>{
		
		var bno = param.bno;
		var page = param.page || 1; 
		
		// $.getJSON(url, SuccessCallback).fail(failCallback)
		$.getJSON("/replies/pages/" + bno + "/" + page, 
			(data) => {
				if(callback) callback(data);
		}).fail((xhr, status, err) => {
			if(error) error(); 
		});
	}; 

	// 댓글 조회 
	var get = (rno, callback, error)=>{
		$.get("/replies/" + rno ,  
			(result) => {
				if(callback) callback(result)
		}).fail((xhr, status, er)=>{
			if(error) error() 
		})
	}; 

	// 댓글 수정 
	var update = (reply, callback, error)=>{
		$.ajax({
			type : "put",
			url : "/replies/" + reply.rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : (result, status, xhr)=>{
				if(callback) callback(result)
			},
			error : (xhr, status, er) => {
				if(error) error(er)
			}
		})
	}; 

	// 댓글 삭제 
	var remove = (rno, callback, error)=>{
		$.ajax({
			type : "delete",
			url : "/replies/" + rno ,
			success : (result, status, xhr) => {
				if(callback) callback(result)
			},
			error : (xhr, status, er) => {
				if(error) error(er); 
			}
		})
	}

	// 시간처리 
	var displayTime = (timeValue) => {
		var today = new Date();
		var gap = today.getTime() - timeValue; 
		var dateObj = new Date(timeValue);
		var str = ""; 
		
		if(gap<(1000*60*60*24)){ // 24시간이 지나면 
			var hh = dateObj.getHours(); 
			var mi = dateObj.getMinutes(); 
			var ss = dateObj.getSeconds(); 
			return [
				(hh > 9 ? '':'0') + hh, ':',
				(mi > 9 ? '':'0') + mi, ':',
				(ss > 9 ? '':'0') + ss
			].join(''); 
		} else{
			var yy = dateObj.getFullYear(); 
			var mm = dateObj.getMonth() + 1; 
			var dd = dateObj.getDate(); 
			return [
				yy, '/', 
				(mm > 9 ? '':'0') + mm, '/',
				(dd > 9 ? '':'0') + dd
			].join('');
		}
	} 
	

return {
		add : add, 
		getList : getList, 
		get : get, 
		update : update, 
		remove : remove, 
		displayTime : displayTime,
	}
})();

