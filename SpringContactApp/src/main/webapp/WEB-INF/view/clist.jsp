<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List - Contact Application</title>

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


				<h3>Contact List</h3> <c:if test="${param.act eq 'sv'}">


					<p class="sucess">Contact is Successfully Saved</p>

				</c:if> <c:if test="${param.act eq 'del'}">


					<p class="sucess">Contact is Deleted Successfully</p>

				</c:if>

				<form action='<s:url value="/user/contact_search" ></s:url>'>


					<input type="text" name="freeText" value="${param.freeText}"
						placeholder="Enter Text To Search">


					<button>Find</button>

				</form> <br>


				<form action='<s:url value="/user/bulk_cdelete"></s:url>'>


					<button>Delete Selected Records</button>
					<br><br>

					<table border="1" cellpadding="3">

						<tr>


							<th>SELECT</th>
							<th>CID</th>
							<th>NAME</th>
							<th>PHONE</th>
							<th>EMAIL</th>
							<th>ADDRESS</th>
							<th>REMARK</th>
							<th>ACTION</th>


						</tr>


						<c:if test="${empty  contactList}">

							<tr>


								<td align="center" colspan="8" class="error">No Records
									Present</td>


							</tr>



						</c:if>



						<c:forEach var="c" items="${contactList}" varStatus="st">

							<tr>


								<td align="center"><input type="checkbox" name="cid" value="${c.contactId}"></td>
								<td>${c.contactId}</td>
								<td>${c.name}</td>
								<td>${c.phone}</td>
								<td>${c.email}</td>
								<td>${c.address}</td>
								<td>${c.remark}</td>


								<s:url var="url_del" value="/user/del_contact">


									<s:param name="cid" value="${c.contactId}"></s:param>

								</s:url>



								<s:url var="url_edit" value="/user/edit_contact">


									<s:param name="cid" value="${c.contactId}"></s:param>

								</s:url>


								<td><a href="${url_edit}"> Edit </a> |<a href="${url_del}">
										Delete</a></td>


							</tr>




						</c:forEach>


					</table>

				</form>

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