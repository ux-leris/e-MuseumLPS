<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create Scenario</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
</head>
<body>
	<h3>Scenario Creation</h3>
	<form action="addObject" method="post">
		Name: <input type="text" name="name" /><br> 
		Objects: <select id="drp_objects">
			<c:forEach items="${objects}" var="obj">
				<option value="${obj}">${obj.getId()}- ${obj.getName() }</option>
			</c:forEach>
		</select>
		<br><br> 
		<input type="submit" value="Create">
	</form>
</body>
<script>
	$(function() {
		$('.date-picker').datepicker({
			showButtonPanel : true,
			dateFormat : 'dd/mm/yy'
		});
	});
</script>
</html>