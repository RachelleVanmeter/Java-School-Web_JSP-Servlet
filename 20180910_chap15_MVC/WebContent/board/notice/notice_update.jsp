<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../common/header.jsp"/>
	<h1>공지글 수정</h1>
	<form action="noticeUpdate.do" method="post">
		<input type="hidden" name="notice_author" value="${member.name}"/>
		<input type="hidden" name="notice_num" value="${notice.notice_num}"/>
		카테고리
		<select name="notice_category">
			<option value="${notice.notice_category}">${notice.notice_category}</option>
			<option value="공지">공지</option>
			<option value="알림">알림</option>
			<option value="당첨">당첨</option>
			<option value="이벤트">이벤트</option>
			<option value="우수공략">우수공략</option>
		</select>
		제목 : 
		<input type="text" name="notice_title" value="${notice.notice_title}" /><br/>
		content : 
		<textarea name="notice_content" style="width: 350px; height: 200px;">${notice.notice_content}</textarea><br/>
		<input type="submit" value="수정완료"/>
	</form>
</body>
</html>