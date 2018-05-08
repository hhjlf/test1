<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
     
   /*     if(${id== null}) {
            alert("게시판을 이용하시려면 로그인하셔야 합니다.");
            location.href="/bbs/login.bbs";
        }
    }); */
    
    // Perform an asynchronous HTTP (Ajax) request.
    // 비동기 통신 Ajax를 Setting한다.
    $.ajaxSetup({
        type:"POST",
        async:true,
        dataType:"json",
        error:function(xhr) {
            console.log("error html = " + xhr.statusText);
        }
    });
    
    $(function() {
        $("#commentWrite").on("click", function() {
        	alert("처음클릭!");
            $.ajax({
                url:"comment.do",
                dataType:"text",
                data:{
                    commentContent:$("#commentContent").val(),
                    num:"${article.num}"
                },
                 beforeSend:function() {
                    console.log("시작 전...");
                },
                complete:function() {
                    console.log("완료 후...");
                },
                success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
           
                    if(data.result == 1) {            // 쿼리 정상 완료, executeUpdate 결과
                        console.log("comment가 정상적으로 입력되었습니다.");
                        $("#commentContent").val("");
                        showHtml(data.comments, 1);
                     	alert("d!!");
                    }
                }
            })
        });
     	
    });
 
    function showHtml(data, commPageNum) {
        let html = "<table class='table table-striped table-bordered' style='margin-top: 10px;'><tbody>";
        $.each(data, function(index, item) {
            html += "<tr align='center'>";
            html += "<td>" + (index+1) + "</td>";
            html += "<td>" + item.id + "</td>";
            html += "<td align='left'>" + item.commentContent + "</td>";
            let presentDay = item.commentDate.substring(0, 10);
            html += "<td>" + presentDay + "</td>";
            html += "</tr>";
        });
        html += "</tbody></table>";
        commPageNum = parseInt(commPageNum);        // 정수로 변경
        // commentCount는 동기화되어 값을 받아오기 때문에, 댓글 insert에 즉각적으로 처리되지 못한다.
        if("${article.commentCount}" > commPageNum * 10) {
            nextPageNum = commPageNum + 1;
            html +="<input type='button' class='btn btn-default' onclick='getComment(nextPageNum, event)' value='다음 comment 보기'>";
        }
        
        $("#showComment").html(html);
        $("#commentContent").val("");
        $("#commentContent").focus();
    }
    
    function getComment(commPageNum, event) {
    	alert(commPageNum);
        $.ajax({
            url:"aa.dos",
            dataType:"JSON",
            data:{
                commPageNum:commPageNum,
                num:"${article.num}"
            },
            success:function(data) {
                alert("씨ㅏ발");
            	console.log("comment를 정상적으로 조회하였습니다.");
                showHtml(data, commPageNum);
                
                let position = $("#showComment table tr:last").position();
                $('html, body').animate({scrollTop : position.top}, 400);        // 두 번째 param은 스크롤 이동하는 시간
            }
        })
    }
</script>



</head>
<body>
<center><b>글내용보기</b>
<br>

<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">
<tr height="30">
<td align="center" width="125" >글번호</td>
<td align="center" width="125" >${number}</td>
<td align="center" width="125" >조회수 </td>
<td align="center" width="125" align="center">${article.readcount}</td>
</tr>
<tr height="30">
<td align="center" width="125">작성자 </td>
<td align="center" width="125" >${article.writer}</td>
<td align="center" width="125" >작성일 </td>
<td align="center" width="125" >${article.regdate}</td>
</tr>
<tr height ="30">
<td align="center" width="125" >글제목 </td>
<td align="center" width="375" align="center" colspan="3">${article.subject}</td>
</tr>
<tr>
<td align="center" width="125" >글내용 </td>
<td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
</tr>
<tr height="30">
<td colspan="4" align="right">
<input type="button" value="글수정" onclick="document.location.href='/myWeb/board/updateForm.do?num=${article.num}&pageNum=${pageNum}'">&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="글삭제" onclick="document.location.href='/myWeb/board/deleteForm.do?num=${article.num}&ref=${article.ref}&pageNum=${pageNum}'">&nbsp;&nbsp;&nbsp;&nbsp;

<input type="button" value = "답글쓰기" onclick="document.location.href='/myWeb/board/writeForm.do?num=${article.num}&ref=${article.ref}&step=${article.step}&depth=${article.depth}'">&nbsp;&nbsp;&nbsp;&nbsp;
<input type ="button" value="글목록"  onclick="document.location.href='/myWeb/board/list.do?pageNum=${pageNum}'">
</td>
</tr>

</table>
</form>

<div class="input-group" role="group"  style="margin-top: 10px; width: 100%;">
    <textarea class="form-control" rows="3" id="commentContent" placeholder="댓글을 입력하세요." style="width: 100%;" ></textarea>
    <div class="btn-group btn-group-sm" role="group" >
       
       
            <input type="button" class="btn btn-default" value="댓글 쓰기" id="commentWrite">
      
        <input type="button" class="btn btn-default" value="댓글 읽기(${article.commentCount})" 
                onclick="getComment(${article.commentCount}, event)" id="commentRead">
    </div>
</div>
 
<!-- Comment 태그 추가 -->
<div class="input-group" role="group" aria-label="..." style="margin-top: 10px; width: 100%;">
    <div id="showComment" style="text-align: center;"></div>
</div>






</center>

</body>
</html>