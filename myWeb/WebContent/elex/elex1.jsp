<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "actiontag.Customer, java.util.HashMap" %>
    <%
    Customer c = new Customer();
    c.setName("��");
    c.setEmail("son@");
    c.setPhone("11");
    request.setAttribute("c",c);
    
    HashMap<String,String> map = new HashMap<String,String>();
    map.put("name","�ҳ�Ÿ");
    map.put("maker","����");
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

<li>�̸� :${c.name }</li>
<li>���� :${c.email }</li>
<li>��ȭ :${c.phone }</li>
</ul>
<br/>
<ul>
<li>�ڵ��� :${car.name }</li>
<li>������:${car.maker }</li>
</ul>
</body>
</html>