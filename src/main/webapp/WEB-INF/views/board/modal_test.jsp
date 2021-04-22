<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<div>
	<button id="addReplyBtn" class="btn btn-primary">모달버튼</button>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">조회</div>
			<div class="panel-body">
				<div class="form-group">
					<label>번호</label>
					<input type="text" name="bno" class="form-control" value="${board.bno}" readonly="readonly">
				</div>

				<div class="form-group">
					<label>제목</label>
					<input type="text" name="title" class="form-control" value="${board.title}" readonly="readonly">
				</div>
				<div class="form-group">
					<label>content</label>
					<textarea rows="8" cols="" class="form-control" name="content" readonly="readonly">
						${board.content}
					</textarea>
				</div>
				<div class="form-group">					
					<label>writer</label>
					<input type="text" name="writer" class="form-control" value="${board.writer}" readonly="readonly">
				</div>
				<button data-oper='modify' class="btn btn-default">수정</button>
				<button data-oper='list' class="btn btn-info">목록</button>
				<form id="operForm">
					<input hidden="text" id="bno" name="bno" value="${board.bno}">
					<input hidden="text" id="pageNum" name="pageNum" value="${cri.pageNum}">
					<input hidden="text" id="amount" name="amount" value="${cri.amount}">
					<input type="hidden" id="type" name="type" value="${cri.type}"> 
					<input type="hidden" id="keyword" name="keyword" value="${cri.keyword}">  
				</form>
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="addReplyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">새로운 댓글 쓰기 </h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>작성자 </label>
					<input type="text" class="form-control" name="replyer" placeholder="작성자">
				</div>
				<div class="form-group">
					<label>댓글</label>
					<input type="text" class="form-control" name="reply" placeholder="내용을 입력하세요.">
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="modalModBtn" class="btn btn-warning">수정</button>
				<button type="button" id="modalRemoveBtn" class="btn btn-danger">삭제</button>
				<button type="button" id="modalRegisterBtn" class="btn btn-primary">등록</button>
				<button type="button" id="modalCloseBtn" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<script>
$(function(){
//댓글 모달창 이벤트 
	var replyModal = $("#addReplyModal"); 
	var modal = $(".modal");
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");
	
	var modalModBtn = $("#modalModBtn") 
	var modalRemoveBtn = $("#modalRemoveBtn") 
	var modalRegisterBtn = $("#modalRegisterBtn")

	$("#addReplyBtn").on("click",function(){
		console.log('executing modal'); 
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide(); 
		modal.find("button[id !='modalCloseBtn']").hide();
		modalRegisterBtn.show();    
		replyModal.modal("show"); 
	});
})
</script>

<%@ include file="../includes/footer.jsp" %>