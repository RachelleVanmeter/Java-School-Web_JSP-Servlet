<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>join</h1>
<style>
	table {
		text-align: center;
		margin: 0 auto;
	}
	table tr {
		height: 40px;
	}
</style>
<form action="joinCheck.jsp" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pass" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="addr" /></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="회원가입" /></td>
		</tr>
	</table>
</form>