<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.BoardDAO" %>
<%@ page import = "board.BoardVO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="../css/style.css"/>



<% request.setCharacterEncoding("utf-8");%>
<%
String id = (String)session.getAttribute("id");
int pageSize = 3;//한페이지에 표시할 글의 수 
SimpleDateFormat sdf = 
    new SimpleDateFormat("yyyy-MM-dd HH:mm");//날짜데이터 표시형식지정
String pageNum = request.getParameter("pageNum");//화면에 표시할 페이지번호
if (pageNum == null) //페이지번호가 없으면 1페이지의 내용이 화면에 표시
    pageNum = "1";
int count = 0;//전체글의 수
int currentPage = Integer.parseInt(pageNum);//숫자로 파싱
List<BoardVO> articleList = null;//글목록을 저장
BoardDAO dbPro = BoardDAO.getInstance();
count = dbPro.getArticleCount();//전체글수 얻어냄
int startRow = (currentPage - 1) * pageSize + 1;//현재 페이지에서의 시작글번호
int endRow = currentPage*pageSize;
try{
  if(count > 0)//테이블에 저장된 글이 있으면, 테이블에서 글목록을 가져옴
    articleList = dbPro.getArticles(startRow, endRow);
  if(articleList.isEmpty())//테이블에 저장된 글이 없으면, 전체글 수 : 0
    count = 0;
}catch(Exception e){}%>
   <table  width = "700" align="center">
   <caption>
   <h3> 글목록(전체 글:<%=count%>)</h3>
   </caption>
<tr>
	<td align="right">
	<button id="new">글쓰기</button>
	</td>
</table>
<% if (count == 0){//게시판에 글이 없는 경우%>
<div id="list_article" class="box2">
  <ul>
    <li><p>게시판에 저장된 글이 없습니다.
  </ul>
</div>
<%}else{//게시판에 글이 있는 경우%>
<table border="1" width="700" cellpadding="0" cellspacing = "0" align="center">
<tr height="30">
<td align="center" width="50" >번호</td>
<td align="center" width="250" >제 목</td>
<td align="center" width="100" >작성자</td>
<td align="center" width="150" >작성일</td>
<td align="center" width="50" >조 회</td>
<td align="center" width="100" >IP</td>
</tr>
<tr>
<% 
  //글목록을 반복처리
  for (int i = 0 ; i < articleList.size() ; i++) {
     BoardVO article = articleList.get(i);
%>
<td align="center" width ="100">
<%= article.getNum() %></td>
<td align="center" width="150">
<%
	int num = article.getNum();
	 int wid=0; 
	 if(article.getDepth()>0){
	    wid=5*(article.getDepth());
	 %>
	 
	    <img src="../images/level.gif" width="<%=wid%>">
	    <img src="../images/re.gif">
	<%}else{%>
	   <img src="../images/level.gif" width="<%=wid%>" height="16">
	<%}%>   
<!--수정6-->
<% if(article.getReadcount()>=20){ %>
<img src="images/hot.gif" border="0" height="16"><%} %>
<a href="#" onclick="content(<%=num%>,<%=currentPage%>);"><%= article.getSubject()%></a></td>


<td align="center" width="50"><%=article.getWriter() %></td>
<td align="center" width="150"><%= sdf.format(article.getRegdate()) %></td>
<td align="center"width="30"><%=article.getReadcount() %></td>
<td align="center" width="50"><%=article.getIp() %></td>
</tr>
<%} %>
</table>
<%} %>

<%-- 페이지 이동 처리 --%>
<div id="jump" class="box3">
<%
if(count>0){ //count 총게시글수
int pageBlock = 5; // [1,2,3,4,5] 다음 <이런식으로나오게
int imsi = count% pageSize ==0?0:1; //블락갯수가 게시글겟수와맞게떨어지면0아니면1
int pageCount = count/pageSize +imsi;  //총게시글수나누기한블락에보여줄게시글갯수+임시(0or1)
int startPage=(int)((currentPage-1)/pageBlock)*pageBlock+1;// //(currentPage< 현재페이지-1 / 페이지블럭)*페이지블럭+1 현재페이지구하기 
int endPage = startPage + pageBlock -1;
if (endPage>pageCount) endPage = pageCount;
if(startPage>pageBlock){%>
<a href="main.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a>
<%
}
for(int i = startPage;i<=endPage;i++){%>
<a href="main.jsp?pageNum=<%=i %>">[<%=i %>]</a>
<%}
	if(endPage<pageCount){
%>
<a href="main.jsp?pageNum=<%=startPage+pageBlock %>">[다음]</a>
<%}
	}%>

</div>




