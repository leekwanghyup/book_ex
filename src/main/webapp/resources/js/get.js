$(function(){
    var replyUL = $(".chat");

    showList(1);
	function showList(page){
		
	    replyService.getList(
	        {bno : bnoValue, page : page || 1},
	        function(list){
	            
	            var str = ""; 
	            
	            if(list == null || list.lenght == 0){
	                replyUL.html(""); 
	                alert('?'); 
	                return; 
	            }
	            
	            for(var i=0, len = list.length || 0 ; i<len; i++){
  					str+=`
				    <li class='list-group-item left clearfix' data-rno=${list[i].rno}>
					    <div>
					        <div class='header'><strong class='primary-font'>${list[i].replyer}</strong>
                                <small class='pull-right text-muted'>${replyService.displayTime(list[i].replyDate)}</small><br>
					        </div><br>
					        <p>${list[i].reply}</p>
					    </div>
					</li>`;
  					
	            }
	            replyUL.html(str);
	    });
	}    
})