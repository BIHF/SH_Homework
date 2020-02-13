<%@page import="com.board.vo.boardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<%
	boardVo vo = (boardVo)request.getAttribute("vo");
%>
</head>
<body>
	<form action="board.do">
		<input type="hidden" name="command" value="updateres">
		<input type="hidden" name="no" value="<%=vo.getNo() %>">
		<div id="wrapper">
			<table id="keywords" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<td>왜 말을 바꾸는가!</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="content" value="<%=vo.getContent() %>"></td>
						<td><input type="submit" value="수정"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>