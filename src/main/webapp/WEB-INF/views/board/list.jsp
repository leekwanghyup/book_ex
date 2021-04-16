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
							<td><a class="move" href="${board.bno}">
            					${board.title}
        					</a></td>
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

<!-- 페이지네이션  -->
<div class="pull-right">
    <ul class="pagination">
        <li class="paginate_button">
            <a href="1">처음으로</a>
        </li>
        <c:if test="${pageMaker.prev}"> 
            <li class="paginate_button previous"><a href="${pageMaker.startPage-1}">이전</a></li>
        </c:if>
        
        <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
            <li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' : '' }">
                <a href="${num}">${num}</a>
            </li>
        </c:forEach>
        
        <c:if test="${pageMaker.next}">
            <li class="paginate_button next"><a href="${pageMaker.endPage + 1}">다음</a></li>
        </c:if>
    </ul>
    <form action="/board/list" id="actionForm" method="get">
        <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}"/>
        <input type="hidden" name="amount" value="${pageMaker.cri.amount}"/>
    </form>
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
	console.log("result 값 확인 : "+result);
	
	checkModal(result);
	
	history.replaceState({},null,null);
	function checkModal(result){
		if(result === '' || history.state) return; 
		if(parseInt(result) > 0){
			$(".modal-body").html("게시글" + parseInt(result) + "번이 등록되었습니다.");
		}		
		$("#myModal").modal("show");
	}
	
	// 글쓰기 페이지 이동 
	$("#regBtn").on("click",function(){
	    self.location = "/board/register";
	});
	
	//페이지네이션 폼 
	var actionForm = $("#actionForm"); 
	$(".paginate_button a").on("click",function(e){
	    e.preventDefault();
	    console.log('click');
	    actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	    actionForm.submit(); 
	})
	
	//조회페이지로 이동
	$(".move").on("click",function(e){
		e.preventDefault(); 
		actionForm.append("<input type='hidden' name='bno' value='"+ $(this).attr("href")+"'>");
	    actionForm.attr("action","/board/get");
	    actionForm.submit(); 
	}); 
	
}); 
</script>