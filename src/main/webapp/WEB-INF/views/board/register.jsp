<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

<div class="container">
	
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"> 글쓰기 </h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">글쓰기</div>
			<div class="panel-body">
				<form role="form" action="/board/register" method="post">
					<div class="form-group">
						<label>title</label>
						<input type="text" name="title" class="form-control">
					</div>
					<div class="form-group">
						<label>content</label>
						<textarea rows="8" cols="" class="form-control" name="content"></textarea>
					</div>
					<div class="form-group">					
						<label>writer</label>
						<input type="text" name="writer" class="form-control">
					</div>
					<button type="submit" class="btn bnt-default">확인</button>
				</form>
			</div>
		</div>
	</div>
</div>
	
</div>

<%@ include file="../includes/footer.jsp" %>