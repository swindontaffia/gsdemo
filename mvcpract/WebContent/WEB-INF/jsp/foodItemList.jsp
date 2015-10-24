<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>

	<h1>Food Items</h1>
 
 	<table border="2">
 	<tr>
 	<th>Name</th><th>Units</th><th>Carbs</th>
 	<th>Sugars</th><th>Fats</th><th>Saturates</th>
 	<th>Protein</th><th>Fibre</th><th>Sodium</th>
 	<th>Energy</th>
 	</tr>
	<c:forEach items="${foodItems}" var="foodItem">
	<tr>
		<td>${foodItem.name}</td><td>${foodItem.units}</td><td>${foodItem.carbs}</td>
		<td>${foodItem.sugars}</td><td>${foodItem.fats}</td><td>${foodItem.saturates}</td>
		<td>${foodItem.protein}</td><td>${foodItem.fibre}</td><td>${foodItem.sodium}</td>
		<td>${foodItem.energy}</td>
	</tr>
	</c:forEach>
 	</table>
 
</body>
</html>