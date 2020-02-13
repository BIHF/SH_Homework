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
		List<boardVo> list = (List<boardVo>) request.getAttribute("list");
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
				<%
					for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td class="lalign"><%=list.get(i).getNo() %></td>
					<td><a href="board.do?command=detail&no=<%=list.get(i).getNo() %>"><%=list.get(i).getContent() %></a></td>
					<td><%=list.get(i).getTime() %></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="3"><input type="button" value="글쓰기" onclick="location.href='board.do?command=insert'"></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>