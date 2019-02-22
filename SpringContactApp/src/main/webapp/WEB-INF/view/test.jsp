<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>

<script>
	$(document).ready(function() {

		/* 		alert('JQuery is ready to integrated'); */

		$("#id_get_time").click(function() {

			//alert('Button Clicked');

			$.ajax({

				url : 'get_time',
				success : function(data) {
					
					$("#id_time").html(data);

				}

			});

		});

	});
</script>

<title>Insert title here</title>
</head>
<body>


	<h1>AJAX Test</h1>

	<button id="id_get_time">Get Server Time</button>

	<p id="id_time"></p>



</body>
</html>