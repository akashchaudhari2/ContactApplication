<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Dashboard - Contact Application</title>

<s:url value="/static/css/style.css" var="url_css"></s:url>
<link href="${url_css}" rel="stylesheet" type="text/css">


</head>
<s:url value="/static/images/bg.jpg" var="url_bg"></s:url>
<body background="${ url_bg} ">

	<table border="1" width="80%" align="center">


		<tr>


			<td height="80px">
				<%-- Header --%> <jsp:include page="include/header.jsp"></jsp:include>

			</td>

		</tr>


		<tr>


			<td height="25px">
				<%-- Menu --%> <jsp:include page="include/menu.jsp"></jsp:include>

			</td>

		</tr>


		<tr>


			<td height="350px" valign="top">
				<%-- Page Content AREA --%>


				<h1>User Dashboard</h1> TODO:- User Options

			</td>

		</tr>


		<tr>


			<td height="25px">
				<%-- footer --%> <jsp:include page="include/footer.jsp"></jsp:include>
			</td>

		</tr>



	</table>





</body>
</html>