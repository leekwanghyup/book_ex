<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>

<div class="container">

<div class="row">
	<div class="col-lg-12 ">
		<h1 class="page-header">
			자유게시판 
			<button type="button" id="regBtn" class="btn btn-primary pull-right">새로운 글쓰기</button>
		</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>게시물리스트</h4>
			</div>
			<div class="panel-body">
				<table class="table table-hover table-bordered table-striped">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="board">
						<tr>
							<td>${board.bno}</td>
							<td>${board.title}</td>
							<td>${board.writer}</td>
							<td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm"/></td>
							<td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd HH:mm"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>

</div>

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">게시글 등록 확인</h4>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-defualt" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>

<script>
$(function(){
	var result = "${result}";
	
	checkModal(result);
	
	function checkModal(result){
		if(result === '') return; 
		if(parseInt(result) > 0){
			$(".modal-body").html("게시글" + parseInt(result) + "번이 등록되었습니다.");
		}		
		$("#myModal").modal("show");
	}
	
	// 글쓰기 페이지 이동 
	$("#regBtn").on("click",function(){
	    self.location = "/board/register";
	});
}); 
</script>