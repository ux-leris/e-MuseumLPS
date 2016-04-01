<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Edit Scenario</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
</head>
<body>
	<h3>Edit Scenario</h3>
	<form action="editScenario" method="post">
		Name: <input type="text" name="name" value="${scenario.getName() }" /><br>
		Date: <input type="text" name="date" class="date-picker"
		value="${scenario.getHistoricalTime().getTime() }" /><br>
		<br><input type="submit" value="Save">
	</form>
</body>
<script>
$(function() {
    $('.date-picker').datepicker( {
        showButtonPanel: true,
        dateFormat: 'dd/mm/yy'
    });
});
</script>
</html>