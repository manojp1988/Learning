
<%@ include file="header.jsp"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib uri="WEB-INF/tlds/Calculate.tld" prefix="calc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<my:now></my:now>
	<form method="post" action="summary.jsp">
		<table>
			<tr><td> Name</td><td>:</td><td><input name="name"/></td></tr>
			<tr><td> DOB</td><td>:</td><td><input name="dob"/></td></tr>
			<tr><td> College</td><td>:</td><td><input name="name"/></td></tr>
			<tr><td> </td><td></td><td><input type="submit"></td></tr>
		</table>
	</form>
	<my:hello></my:hello>
</body>
</html>