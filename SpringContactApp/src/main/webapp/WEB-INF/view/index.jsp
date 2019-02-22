<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Application</title>

<s:url value="../static/css/style.css" var="url_css"></s:url>
<link href="${url_css}" rel="stylesheet" type="text/css">
</head>
<s:url value="../static/images/bg.jpg" var="url_bg"></s:url>
<body background="${url_bg} ">

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


				<h3>User Login</h3> <%-- 	<jsp:include page="dashboard_user.jsp" ></jsp:include> --%>

				<%-- 	 <s:url var="url_login" value="/login"></s:url>  --%> <c:if
					test="${err!=null}">

					<p>${err}</p>


				</c:if> <c:if test="${param.act eq 'lo'}">

					<p class="success">Logout Successfully.Thanks for Using Contact
						Application</p>


				</c:if> <c:if test="${param.act eq 'reg'}">

					<p class="success">User Registered Successfully.Please Login</p>


				</c:if> <f:form action="/SpringContactApp/login" modelAttribute="command">


					<table border="1">

						<tr>


							<td>UserName</td>
							<td><f:input path="loginName" /></td>



						</tr>


						<tr>


							<td>Password</td>
							<td><f:input path="password" /></td>



						</tr>

						<tr>


							<td colspan="2" align="right"><button>Login</button> <br>
								<a href="#">New User Registration</a></td>




						</tr>

					</table>


				</f:form>






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