<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String msg = (String) request.getAttribute("msg");
%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Data</title>
<%@include file="common.jsp"%>
</head>
<body>
	<fieldset>
		<legend>Enter the Recived mail details</legend>
		<form action="./delete1">
			<table>
				<tr>
					<td>Message ID</td>
					<td>:</td>
					<td><input type="text" name="mid" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Delete"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: cyan;"><%=msg%>
	</h1>
	<%
		}
	%>
</body>
</html>