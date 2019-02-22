<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserList - Contact Application</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<s:url value="/static/css/style.css" var="url_css"></s:url>
<link href="${url_css}" rel="stylesheet" type="text/css">

<script type="text/javascript">


function changeStatus(uid,lstatus){
	
	
	
	//alert(userId+","+loginStatus);
	
	$.ajax({

		url : 'change_status',
		data:{userId:uid,loginStatus:lstatus},
		success : function(data) {
			
alert(data);

		}

	});
} 



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


				<h1>UserList</h1>

				<table border="1">

					<tr>

						<td>SR</td>
						<td>USER</td>
						<td>NAME</td>
						<td>PHONE</td>
						<td>EMAIL</td>
						<td>ADDRESS</td>
						<td>USERNAME</td>
						<td>STATUS</td>



					</tr>
					<c:forEach var="u" items="${userList}" varStatus="st">

						<tr>

							<td>${st.count}</td>
							<td>${u.userId}</td>
							<td>${u.name}</td>
							<td>${u.phone}</td>
							<td>${u.email}</td>
							<td>${u.address}</td>
							<td>${u.loginName}</td>
							<td><select id="id_${u.userId}"
								onchange="changeStatus(${u.userId},$(this).val())">

									<option value="1">Active</option>
									<option value="2">Block</option>

							</select> <script type="text/javascript">
								$('#id_${u.userId}').val(${u.loginStatus});
							</script> ${u.loginStatus}</td>



						</tr>




					</c:forEach>



				</table>

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