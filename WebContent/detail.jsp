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

</head>
<body>
	<%
		boardVo vo = (boardVo) request.getAttribute("vo");
	%>
	<div id="wrapper">
		<table id="keywords" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th><span>번호</span></th>
					<th><span>제목</span></th>
					<th><span>작성일</span></th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td class="lalign"><%=vo.getNo()%></td>
					<td><%=vo.getContent()%></td>
					<td><%=vo.getTime()%></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" value="삭제"
						onclick="location.href='board.do?command=delete&no=<%=vo.getNo()%>'">
						<input type="button" value="수정"
						onclick="location.href='board.do?command=update&no=<%=vo.getNo()%>'">
						<input type="button" value="뒤로가기" onclick="location.href='board.do?command=selectList'">
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>