<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import= "java.util.ArrayList,actiontag.Customer" %>
    <%
    ArrayList<String> s = new ArrayList<String>();
    s.add("트와이스");
    s.add("레드벨벳");
    request.setAttribute("s",s);
    Customer[]c = new Customer[2];
    
    c[0] = new Customer();
    c[0].setName("손손");
    c[0].setEmail("손메일");
    c[0].setPhone("손전화버노");
    c[1] = new Customer();
    c[1].setName("홍홍");
    c[1].setEmail("홍메일");
    c[1].setPhone("홍전화버노");
    session.setAttribute("c",c);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>asd</h1>${requestScope.s }
<ul>
<li>${s[0]}</li>
</ul>
<ul>

<li>이름:${c[0].name }</li>
<li>메일:${c[0].email }</li>
<li>번호:${c[0].phone }</li>
</ul>
<ul>
<li>이름:${c[1].name }</li>
<li>메일:${c[1].email }</li>
<li>번호:${c[1].phone }</li>

</ul>
</body>
</html>