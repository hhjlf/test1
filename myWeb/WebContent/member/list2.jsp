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
String id = "";
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

<div id="list_head" class="box2">
   <h3 class="inline">글목록(전체 글:<%=count%>)</h3>
   <button id="new">글쓰기</button>
</div>

<% if (count == 0){//게시판에 글이 없는 경우%>
<div id="list_article" class="box2">
  <ul>
    <li><p>게시판에 저장된 글이 없습니다.
  </ul>
</div>
<%}else{//게시판에 글이 있는 경우%>
<div id="list_article" class="box2">
<% 
  //글목록을 반복처리
  for (int i = 0 ; i < articleList.size() ; i++) {
     BoardVO article = articleList.get(i);
%>
   <ul class="article">  
    <li class="layout_f">
     <%String writer = article.getWriter();
       out.println("글쓴이 :"+writer);
     %>
    <li class="layout_f">
     <%
	 int wid=0; 
	 if(article.getDepth()>0){
	    wid=5*(article.getDepth());
	 %>
	    <img src="../images/level.gif" width="<%=wid%>">
	    <img src="../images/re.gif">
	<%}else{%>
	   <img src="../images/level.gif" width="<%=wid%>" height="16">
	<%}%>
	
	<% int num = article.getNum();
	   int ref = article.getRef();
	   int step = article.getStep();
	   int depth = article.getDepth();
	   
	%>
	제목 :<%=article.getSubject()%>
	<p class="date">작성일 : <%=sdf.format(article.getRegdate())%>&nbsp;&nbsp; 조회수: <%=article.getReadcount()%>
	[IP]<%=article.getIp()%><br>
	<pre><div style="border:1px solid black; height :300px"><%=article.getContent()%></div></pre><br>
	<%try{
    	id = (String)session.getAttribute("id");
      }catch(Exception e){}%>
	<%if(id.equals(writer)) {%>
	  <button id="edit" 
	   name="<%=num+","+pageNum%>" onclick="edit(this)">수정</button>
	  <button id="delete" 
	   name="<%=num+","+pageNum%>" onclick="del(this)">삭제</button>
	<%}else{ %>
	  <button id="reply" 
	   name="<%=num+","+ref+","+step+","+depth+","+pageNum%>" 
	  onclick="reply(this)">댓글쓰기</button>
	<%}%>
  </ul>
<%}%>
</div>
<%}%>

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




