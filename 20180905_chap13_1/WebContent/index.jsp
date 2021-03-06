<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!-- jdbc/OracleDB -->
<%
	Connection conn = null;
	PreparedStatement pstmt = null; // 프리페어드 스테이트먼트
	ResultSet rs = null;
	
	ResultSetMetaData rsmd = null;
	
	try {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		out.println("<h3>연결되었습니다.</h3>");
		
		String sql = "SELECT * FROM board ORDER BY b_num DESC";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		rsmd = rs.getMetaData();
		
		/* out.print("<h3>" + rsmd.getColumnCount()
				+ "  " + rsmd.getColumnName(1)
				+ "  " + rsmd.getColumnName(2)
				+ "</h3>"); */
	} catch (Exception e) {
		out.println("<h3>연결에 실패하였습니다.</h3>");
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellspacing="0">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td colspan="2">내용</td>
		</tr>
		<% while (rs.next()) { %>
			<tr>
				<td><%=rs.getInt(1) %></td>
				<td><%=rs.getString(2) %></td>
				<td><%=rs.getString(3) %></td>
				<td>
					<a href="update.jsp?b_num=<%=rs.getInt(1)%>">수정</a> | <a href="delete.jsp?b_num=<%=rs.getInt(1)%>">삭제</a>
				</td>
			</tr>
		<% } %>
		<tr>
			<td colspan=4>
				<a href="write.jsp">작성하러 가기</a>
			</td>
		</tr>
	</table>
	<%
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>