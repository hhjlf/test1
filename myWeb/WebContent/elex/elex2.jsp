<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import= "java.util.ArrayList,actiontag.Customer" %>
    <%
    ArrayList<String> s = new ArrayList<String>();
    s.add("Ʈ���̽�");
    s.add("���座��");
    request.setAttribute("s",s);
    Customer[]c = new Customer[2];
    
    c[0] = new Customer();
    c[0].setName("�ռ�");
    c[0].setEmail("�ո���");
    c[0].setPhone("����ȭ����");
    c[1] = new Customer();
    c[1].setName("ȫȫ");
    c[1].setEmail("ȫ����");
    c[1].setPhone("ȫ��ȭ����");
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

<li>�̸�:${c[0].name }</li>
<li>����:${c[0].email }</li>
<li>��ȣ:${c[0].phone }</li>
</ul>
<ul>
<li>�̸�:${c[1].name }</li>
<li>����:${c[1].email }</li>
<li>��ȣ:${c[1].phone }</li>

</ul>
</body>
</html>