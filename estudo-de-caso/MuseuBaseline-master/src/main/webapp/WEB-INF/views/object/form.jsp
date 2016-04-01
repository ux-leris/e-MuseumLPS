<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Object</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
</head>
<body>
	<h3>MuseologicalObject Creation</h3>
	<form action="add" method="post">
		Name: <input type="text" name="name" /><br>
		<!-- NOTE A data do objeto é a de quando ele é inserido ou sua data histórica? -->
		Date: <input type="text" name="date" class="date-picker" /><br>
		URL: <input type="text" name="url" /><br>
		<br><input type="submit" value="Create">
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