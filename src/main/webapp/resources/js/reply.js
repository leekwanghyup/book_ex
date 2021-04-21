
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
return {
		add : add, 
	}
})();

