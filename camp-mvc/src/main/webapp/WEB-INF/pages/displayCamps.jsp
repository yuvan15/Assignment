<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

table {
  width: 100%;
  border: 1px solid #000;
}

th, td {
  width: 25%;
  text-align: left;
  vertical-align: top;
  border: 1px solid #000;
  border-collapse: collapse;
  padding: 0.3em;
  caption-side: bottom;
}

caption {
  padding: 0.3em;
  color: #fff;
  background: #000;
}

th {
  background: #eee;
}

</style>
</head>
<body>

<table>

	<tr>
		<th>Camp Id</th>
		<th>Camp Name</th>
		<th>Camp Date</th>
		<th>Phone Number</th>
		<th>Location</th>
		<th>PinCode</th>
	</tr>
	
	<c:forEach items ="${camps}" var ="eachItem">

		<tr>
			<td>${eachItem.campId}</td>
			<td>${eachItem.name}</td>
			<td>${eachItem.campDate}</td>
			<td>${eachItem.phoneNumber}</td>
			<td>${eachItem.location}</td>
			<td>${eachItem.pinCode}</td>
		</tr>
	
	</c:forEach>
	
</table>

</body>
</html>