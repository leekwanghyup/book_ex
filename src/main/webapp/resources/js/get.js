$(function(){
	// 게시물 수정 목록 페이지로 이동 
	var operForm = $("#operForm"); 

	$("button[data-oper='modify']").on("click",function(){
		operForm.attr("action", "/board/modify").submit(); 
	})
	
	$("button[data-oper='list']").on("click",function(){
		operForm.find("#bno").remove();
		operForm.attr("action", "/board/list");
		operForm.submit(); 
	})

	// 댓글 목록 화면 처리 
	var replyUL = $(".chat");
	var bnoValue = $("#bno").val(); 

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
				    <li class='list-group-item left clearfix'>
					    <div>
					        <div class='header'><strong class='primary-font'>${list[i].replyer}</strong>
					        	<a href="#" data-rno=${list[i].rno} style="margin-left: 20px;"> 수정/삭제</a>
					            <small class='pull-right text-muted'>${replyService.displayTime(list[i].replyDate)}</small><br>
					        </div><br>
					        <p>${list[i].reply}</p>
					    </div>
					</li>`;
	            }
	            replyUL.html(str);
	    });
	}
	
	// 댓글 쓰기 화면 처리 (모달창)
	var replyModal = $("#addReplyModal");
	
	var modal = $(".modal");
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");
	
	var modalModBtn = $("#modalModBtn") 
	var modalRemoveBtn = $("#modalRemoveBtn") 
	var modalRegisterBtn = $("#modalRegisterBtn")
	
	$("#addReplyBtn").on("click",function(){
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide(); // ???
		modal.find("button[id !='modalCloseBtn']").hide();
		modalRegisterBtn.show();
		$("#myModalLabel").html("새로운 댓글 쓰기");
		replyModal.modal("show");
	});

	// 특정댓글 클릭시 이벤트 발생(수정/삭제) 
	$(".chat").on("click","a",function(e){ // <a> 태그에 이벤트 위임
		e.preventDefault();
		var rno = $(this).data("rno");
		
		replyService.get(rno, function(reply){
			modalInputReply.val(reply.reply); 
			modalInputReplyer.val(reply.replyer);
			modalInputReplyDate.val(replyService.displayTime(reply.replyDate))
			.attr("readonly", "readonly");  
			modal.data("rno", reply.rno);
			
			modal.find("button[id != 'modalCloseBtn']").hide();
			
			$("#myModalLabel").html("댓글 수정/삭제");
			modalModBtn.show(); 
			modalRemoveBtn.show(); 
			
			modal.modal("show");
		})
	})

	// 댓글 쓰기 등록 처리 
	modalRegisterBtn.on("click",function(){
		var reply = {
				reply : modalInputReply.val(),
				replyer : modalInputReplyer.val(),
				bno : bnoValue
		}; 
		replyService.add(reply, function(result) {
			if(result){
				alert("새로운 댓글이 등록되었습니다.")
			}			
			modal.find("input").val(""); // 등록한 내용으로 다시 등록할 수 없도록 입력항목을 모두 비운다.  
			modal.modal("hide"); 
			showList(1); // 목록 갱신
		}); 
	})

	// 댓글 수정 이벤트 처리 
	modalModBtn.on("click", function(){
		
		var reply = {
				rno : modal.data("rno"),
				reply : modalInputReply.val()
		};
		
		replyService.update(reply, function(result){
			modal.modal("hide");
			showList(1);
		});
	}); 

// 댓글 삭제 이벤트 처리 
	modalRemoveBtn.on("click",function(){
		var rno = modal.data("rno"); 
		replyService.remove(rno, function(){
			modal.modal("hide"); 
			showList(1);
		}); 
	});
})
 