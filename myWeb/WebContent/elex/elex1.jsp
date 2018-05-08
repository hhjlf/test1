<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "actiontag.Customer, java.util.HashMap" %>
    <%
    Customer c = new Customer();
    c.setName("손");
    c.setEmail("son@");
    c.setPhone("11");
    request.setAttribute("c",c);
    
    HashMap<String,String> map = new HashMap<String,String>();
    map.put("name","소나타");
    map.put("maker","현대");
    request.setAttribute("car",map);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<ul>

<li>이름 :${c.name }</li>
<li>메일 :${c.email }</li>
<li>전화 :${c.phone }</li>
</ul>
<br/>
<ul>
<li>자동차 :${car.name }</li>
<li>제조사:${car.maker }</li>
</ul>
</body>
</html>