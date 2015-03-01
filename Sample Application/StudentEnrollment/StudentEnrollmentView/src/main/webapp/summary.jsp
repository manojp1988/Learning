<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Summary</title>
</head>
<body>
<table border="solid">
<c:forEach var="student" items="${students}">
	<tr>
	<td> <c:out value="${student.name}"/><p></td> 
	<td> <c:out value="${student.phone}"/><p></td>
	<td> <c:out value="${student.pk.email}"/><p></td>
	</tr>
</c:forEach>
</table>
</body>
</html>