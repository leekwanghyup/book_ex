<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

<div class="container">
	
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"> 글수정 </h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">글수정</div>
			<div class="panel-body">
				<form role="form" action="/board/modify" method="post">
					<div class="form-group">
						<label>번호</label>
						<input type="text" name="bno" class="form-control" value="${board.bno}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>title</label>
						<input type="text" name="title" class="form-control" value="${board.title}">
					</div>
					<div class="form-group">
						<label>content</label>
						<textarea rows="8" cols="" class="form-control" name="content">
							${board.content}
						</textarea>
					</div>
					<div class="form-group">					
						<label>writer</label>
						<input type="text" name="writer" class="form-control" value="${board.writer}" readonly="readonly">
					</div>
				</form>
				<button type="submit" data-oper="modify" class="btn btn-default">수정</button>
				<button type="submit" data-oper="remove" class="btn btn-danger">삭제</button>
				<button type="submit" data-oper="list" class="btn btn-primary">목록</button>
			</div>
		</div>
	</div>
</div>
	
</div>

<%@ include file="../includes/footer.jsp" %>

<script>
$(function(){
	var formObj = $("form");

	$('button').on('click',function(e){
		e.preventDefault(); 
		var operation = $(this).data('oper'); 
		if(operation === 'remove'){
			formObj.attr("action","/board/remove")						
		}else if(operation === 'list'){
			formObj.attr("action","/board/list")
					.attr("method","get"); 
		}
		formObj.submit(); 
	})
})
</script>

    