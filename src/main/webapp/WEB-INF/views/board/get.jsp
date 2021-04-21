<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../includes/header.jsp" %>
<div class="container">
	
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"> 조회페이지 </h1>
	</div>
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

<div class="row"> <!-- 댓글 목록 -->
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                댓글 
            </div>
            <div class="panel-body">
                <ul class="list-group chat">
                    <li class="list-group-item left clearfix " data-rno="12">
                        <div>
                            <div class="header">
                                <strong class="primary-font">user00</strong>        
                                <small class="pull-right text-muted">2020-10-10</small>
                            </div>
                            <p>
                            	Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ab quaerat praesentium nisi quisquam. 
                            	Eveniet dolor cum maxime consequuntur
                            	culpa accusantium, esse facilis corporis ea, voluptas optio placeat earum quo doloribus!
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

	
</div>
<script src="/resources/js/reply.js"></script>
<script src="/resources/js/get.js"></script>

<%@ include file="../includes/footer.jsp" %>
<script>
	var operForm = $("#operForm");
	var bnoValue = "${board.bno}" // 게시물 번호 
	
	$("button").on("click",function(e){
		e.preventDefault();
		var operation = $(this).data('oper')
		if(operation === 'list'){
			operForm.find("#bno").remove(); 
			operForm.attr("action", "/board/list");  
		} else if(operation === 'modify'){
			operForm.attr("action", "/board/modify"); 
		}
		operForm.submit(); 
	})
</script>

