<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Museological Object</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
</head>
<body>
	<h3>Edit Museological Object</h3>
	<form action="update" method="post">
		Id: <input type="text" name="id" value="${ object.getId() }" readonly/><br>
		Name: <input type="text" name="name" value="${ object.getName() }" /><br>
		Date: <input type="text" name="date" class="date-picker"
		value="${ format.format(object.getDate().getTime()) }" /><br>
		<!--Type:
		<select name="objectType">
			<option value="default">Default</option>
			<option value="image">Image</option>
			<option value="text">Text</option>
		</select><br>
		<p id="url">URL: <input type="text" name="url" value=" ${ image.getUrlAddress() } " /></p>
		<br>--><input type="submit" value="Save">
	</form>
</body>
<script>
	$(function() {
		$('.date-picker').datepicker({
			showButtonPanel : true,
			dateFormat : 'dd/mm/yy'
		});
		
		//$('select:[name=objectType]')
	});
</script>
</html>