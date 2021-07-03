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
<title>Insert Record</title>
<%@include file="common.jsp"%>
</head>
<body>
	<fieldset>
		<legend>Add Details </legend>
		<form action="./add" method="post">
			
			<table>
			<tr>
					<td>Mid</td>
					<td>:</td>
					<td><input type="text" name="mid" required="required"></td>
				</tr>
			
			<tr>
					<td>To Email</td>
					<td>:</td>
					<td><input type="text" name="email" required="required"></td>
				</tr>
				<tr>
					<td>Subject</td>
					<td>:</td>
					<td><input type="text" name="subject" required="required"></td>
				</tr>
				
				<tr>
					<td>Message</td>
					<td>:</td>
					<td><input type="text" name="message" required="required"></td>
				</tr>
				
				<tr>
					<td>Status</td>
					<td>:</td>
					<td><input type="text" name="status" required="required"></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="send mail"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: magenta;"><%=msg%>
	</h1>
	<%
		}
	%>
</body>
</html>