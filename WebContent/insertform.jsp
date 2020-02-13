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
	<form action="board.do">
		<input type="hidden" name="command" value="insertres">
		<div id="wrapper">
			<table id="keywords" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<td>무슨말이 하고싶은가!</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="content"></td>
						<td><input type="submit" value="작성"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>