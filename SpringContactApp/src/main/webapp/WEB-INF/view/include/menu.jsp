<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<s:url value="/logout" var="url_logout"></s:url>


	<c:if test="${sessionScope.userId==null}">


		<s:url value="/reg_form" var="url_reg_form"></s:url>

		<a href="#">Home</a>

|

	<a href="#">Login</a>

|

	<a href="${url_reg_form}">Register</a>


|

	<a href="#">About</a>
	
	
	|

	<a href="#">Help</a>

	</c:if>



	<c:if test="${sessionScope.userId!=null && sessionScope.role==1}">

		<a href="#">Home</a>

|

	<a href='<s:url value="/admin/users"></s:url>'>UserList</a>

|

	<a href="${url_logout} ">Logout</a>





	</c:if>


	<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">



		<s:url value="/user/dashboard" var="url_uhome"></s:url>

		<s:url value="/user/contact_form" var="url_cform"></s:url>


		<s:url value="/user/clist" var="url_clist"></s:url>



		<a href="${ url_uhome}">Home</a>

|

	<a href="${url_cform}">AddContact</a>

|


	<a href="${url_clist }">ContactList</a>

|

	<a href="${url_logout}">Logout</a>





	</c:if>

</body>
</html>