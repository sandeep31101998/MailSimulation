<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String errMsg = (String) request.getAttribute("errMsg");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
<%@include file="common.jsp"%>
</head>
<body>
	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red"><%=errMsg%>
	</h1>
	<%
	}
	%>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: green; text-align: center"><%=msg%>
	</h1>
	<%
	}
	%>
	
	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-center">User Login</h4>
						<form action="./login" method="post">


							<div class="form-group">
								<label for="em">Email address</label> <input
									type="email" class="form-control" id="em"
									name="email" aria-describedby="emailHelp" required>

							</div>

							<div class="form-group">
								<label for="pw">Password</label> <input
									name="password" type="password" class="form-control"
									id="pw" required>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Login</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>