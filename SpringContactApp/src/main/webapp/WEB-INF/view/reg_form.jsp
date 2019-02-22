<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration - Contact Application</title>

<s:url value="/static/css/style.css" var="url_css"></s:url>
<link href="${url_css}" rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#id_check_avail").click(function() {

			$.ajax({

				url : 'check_avail',
				data : {
					username : $("#id_username").val()
				},
				success : function(data) {

					$("#id_res_div").html(data);

				}

			});

		});

	});
</script>



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


				<h3>User Registration</h3> <%-- 	<jsp:include page="dashboard_user.jsp" ></jsp:include> --%>

				<%-- 	 <s:url var="url_login" value="/login"></s:url>  --%> <c:if
					test="${err!=null}">

					<p class="error">${err}</p>


				</c:if> <f:form action="/SpringContactApp/register"
					modelAttribute="command">


					<table border="1">




						<tr>


							<td>Name</td>
							<td><f:input path="user.name" /></td>



						</tr>


						<tr>


							<td>Phone</td>
							<td><f:input path="user.phone" /></td>



						</tr>


						<tr>


							<td>Email</td>
							<td><f:input path="user.email" /></td>



						</tr>


						<tr>


							<td>Address</td>
							<td><f:textarea path="user.address" /></td>



						</tr>

						<tr>


							<td>UserName</td>
							<td><f:input id="id_username" path="user.loginName" />



								<button type="button" id="id_check_avail">Check
									Availability</button>



								<div id="id_res_div" class="error"></div></td>






						</tr>


						<tr>


							<td>Password</td>
							<td><f:input path="user.password" /></td>



						</tr>












						<tr>


							<td colspan="2" align="right"><button>Submit</button> <br>
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