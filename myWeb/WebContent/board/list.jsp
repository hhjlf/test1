<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<%--검색 스크립트--%>

<script type="text/javascript">

jQuery.fn.highlight = function(pat) {
    function innerHighlight(node, pat) {
        var skip = 0;
        if (node.nodeType == 3) {
            var pos = node.data.toUpperCase().indexOf(pat);
            if (pos >= 0) {
                var spannode = document.createElement('span');
                spannode.className = 'highlight';
                var middlebit = node.splitText(pos);
                var endbit = middlebit.splitText(pat.length);
                var middleclone = middlebit.cloneNode(true);
                spannode.appendChild(middleclone);
                middlebit.parentNode.replaceChild(spannode, middlebit);
                skip = 1;
            }
        }
        else if (node.nodeType == 1 && node.childNodes && !/(script|style)/i.test(node.tagName)) {
            for (var i = 0; i < node.childNodes.length; ++i) {
                i += innerHighlight(node.childNodes[i], pat);
            }
        }
        return skip;
    }
    return this.length && pat && pat.length ? this.each(function() {
        innerHighlight(this, pat.toUpperCase());
    }) : this;
};
	function test() {
		var query = "${find_box}";
		var q = "${find}";
		$("."+q).highlight(query);
		
	}
	function check() {
		if (document.find_frm.find_box.value == "") {

			alert("검색어를 입력해 주세요");
			return false;
		}
	}
</script>
<style type="text/css">
.highlight {
	background: yellow;
}
</style>
</head>
<body>
	<center>
	<a href="/myWeb/board/list.do"><b>글목록</a> (전체 글:${count }) </b>
		<table width="700">
			<tr>
				<td><a href="/myWeb/board/writeForm.do">글쓰기</a></td>
			</tr>
		</table>
		<c:if test="${count==0 }">
			<table width="700" border="1">
				<tr>
					<td align="center">게시판에 저장된 글이 없네요?</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${count>0 }">
			<table border="1" width="700" class="table-boardred">
				<tr>
					<td width="50">글번호</td>
					<td width="250">제 목</td>
					<td width="100">작성자</td>
					<td width="150">작성일</td>
					<td width="50">조회수</td>
					<td width="100">ip</td>
				</tr>
				<c:forEach var="article" items="${articleList }">
					<tr  height="30">
						<td align="center" width="50">
						<c:out value="${number}" />
						 <c:set
						var="number" value="${number-1 }" />
						</td>
						<td width="250">
						<c:if test="${article.depth>0 }">
								<img src="images/lebel.gif" width="${5*article.depth }"
									height="16">
								<img src="images/re.gif">
							</c:if> 
							<c:if test="${article.depth==0 }">
								<img src="images/level.gif" width="${5*article.depth }"
									height="16">
							</c:if>
							 <c:if test="${article.de eq 0 }">
								<a class="subject"
									href="/myWeb/board/content.do?num=${article.num}&number=${number }&pageNum=${currentPage}">
									${article.subject}</a>
								<c:if test="${article.readcount >= 20 }">
									<img src="images/hot.gif" border="0" height="16">
								</c:if>
							</c:if> 
							<c:if
							 
							test="${article.de eq 1 }">삭제된글입니다.
						
							</c:if>			
							</td>
						<td align="center" width="100"><a class="writer"
							href="mailto:${article.email }">${article.writer }</a></td>
						<td align="center" width="150">${article.regdate }</td>
						<td align="center" width="50">${article.readcount }</td>
						<td align="center" width="100">${article.ip }</td>
					</tr>
					<script type="text/javascript">
						test();
					</script>
				</c:forEach>
			</table>
		</c:if>
		
		<c:if test="${startPage>pageBlock }">
		<c:if test="${find_box eq 'no'}">
			<a href="/myWeb/board/list.do?pageNum=${startPage -pageBlock }">[이전]</a>
			</c:if>
		</c:if>

		<c:if test="${find_box eq 'no' }">
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<a href="/myWeb/board/list.do?pageNum=${i }">[${i }]</a>
			</c:forEach>
		</c:if>

		<c:if test="${find_box != 'no' }">
			<c:if
			 test="${startPage>pageBlock }">
			<a href="/myWeb/board/list.do?pageNum=${startPage -pageBlock }&find=${find}&find_box=${find_box}">[이전]</a>
		</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<a
					href="/myWeb/board/list.do?pageNum=${i }&find=${find}&find_box=${find_box}">[${i }]</a>
			</c:forEach>
			
		
			<c:if
			 test="${endPage<pageCount }">
			<a href="/myWeb/board/list.do?pageNum=${startPage+pageBlock }&find=${find}&find_box=${find_box}">[다음]</a>
		</c:if>
			
		</c:if>


		<c:if test="${endPage<pageCount }">
		<c:if test="${find_box eq 'no'}">
			<a href="/myWeb/board/list.do?pageNum=${startPage+pageBlock }">[다음]</a>
			</c:if>
		</c:if>

		<form method="post" name="find_frm" action="/myWeb/board/list.do"
			onsubmit="return check()">
			<select name="find" size="1">
				<option value="writer">작성자</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
			</select> &nbsp; 
			<input type="text" name="find_box" /> &nbsp; <input
				type="submit" value="검색" />&nbsp; 
				
		</form>



	</center>
</body>
</html>