<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="welcome">Home</a>
<h1>${message}</h1>
<div>Total no of employees: ${list.size()}</div><br>
	<table border = '1'>
	<tr>
		<th> Identity Number </th><th> Employee Name </th><th> Company Name </th>
	</tr>
	<c:forEach items="${list}" var="employee">
		<tr>
			<td>${employee.id}</td><td>${employee.name}</td><td>${employee.company}</td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>