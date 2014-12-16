<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="welcome">Home</a>
<h1>${message}</h1>
<form name="frm" action="delete" method="post">
	<table>
		<tr>
			<td>Employee Id: </td><td> <input type="text" name="id"> </td>
		</tr>
	</table>
	<input type="submit" value="Add"/>
</form>
</body>
</html>