<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mail</title>
<%@include file="common.jsp"%>
</head>
<body>
	<table border="1" style="width: 100%">
		<tr>
			<th style="background-color: lightgrey; color: blue; height: 30px">
				<a href="./compose">Compose</a>
			<th style="background-color: lightgrey; color: blue; height: 30px"><a
				href="./getAllSent">sent</a></th>
			<th style="background-color: lightgrey; color: blue; height: 30px"><a
				href="./getAll">Inbox</a></th>
			<th style="background-color: lightgrey; color: blue; height: 30px"><a
				href="./getDeleteForm">Delete Sent Mail</a></th>

			</th>
			<th style="background-color: lightgrey; color: blue; height: 30px"><a
				href="./getDeleteForm1">Delete Recived mail</a></th>
			<th style="background-color: lightgrey; color: blue; height: 30px"><a
				href="./logout">logout</a></th>
		</tr>
	</table>
</body>
</html>