<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script.js"></script>
</head>
<body>
<form method="post" action="member.mdo?cmd=regProc" name="regForm">
<table border="1">
	<tr><td colspan="2" align="center">회원가입 정보입력</td>
	</tr>
	
	<tr>
		<td>아이디 : </td>
		<td><input type="text"name="id" size="20" onchange="idchange()"/>&nbsp; <input type="button" value="중복확인" onClick="idCheck(this.form.id.value)" /></td>
		</tr>
		<tr>
		<td>비밀번호 : </td>
		<td><input type="password" name="pass" size="20"/>
		</td>
		</tr>
		<tr>
		<td>비밀번호 확인 : </td>
		<td><input type="password" name="repass" size="20"/></td>
		</tr>
		<tr>
		<td>이름 : </td>
		<td><input type="text" name="name" size="20"/></td></tr>
		<tr>
		<td>전화번호 : </td>
		<td> <select name="phone1">
		<option value="02">02</option>
		<option value="010">010</option>
		<option value="011">011</option>
		</select> &nbsp;-&nbsp;
		<input type="text" name="phone2" size="5"/>-&nbsp;
		<input type="text" name="phone3" size="5"/></td>
		</tr>
		<tr>
		<td>이메일 :</td>
		<td><input type="text" name="email"/></td>
		</tr>						
		<tr>
			<td>우편번호 : </td>
			<td><input type="text" name= "zipcode" size="20"/>&nbsp;
			<input type= "button" value ="찾기" onClick="zipCheck()"/></td></tr>
			<tr>
				<td>주소1:</td>
				<td><input type="text" name="address1" size="30"/></td>
				</tr>
				<tr>
				<td>주소2:</td>
				<td><input type="text" name="address2" size="30"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="button" value= "회원가입" onClick="inputCheck()"/>&nbsp;
					<input type="reset" value="다시입력"></td>
					</tr>
	</table>
</form>
</body>
</html>