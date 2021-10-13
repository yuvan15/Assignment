<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Camp</title>

<style>

    fieldset{
            background-color: #f1f1f1;
            border: none;
            border-radius: 2px;
            margin-bottom: 12px;
            overflow: hidden;
            padding: 0 .625em;
        }

        label{
            cursor: pointer;
            display: inline-block;
            padding: 3px 6px;
            text-align: right;
            width: 250px;
            vertical-align: top;
        }

        input{
            font-size: inherit;
        }
        
        h1{
        	color:red
        
        }
        
        
    
</style>

</head>
<body>
<h1 style="text-align: center;">Registration Form</h1>
<hr>
<br>

<div>
<form:form action="/addCamp" modelAttribute="camp" method="post">

<div>
<label for="">CampId</label>
<form:input path="campId"/>
<form:errors path = "campId" />
</div>
<br>


<div>
<label for="">CampName</label>
<form:input path="name"/>
<form:errors path = "name" />
</div>
<br>

<div>
<label for="">CampDate</label>
<form:input type="date" path="campDate"/>
<form:errors path = "campDate" />
</div>
<br>


<div>
<label for="">Phone Number</label>
<form:input path="phoneNumber"/>
<form:errors path = "phoneNumber" />
</div>
<br>


<div>
<label for="">location</label>
<form:input path="location"/>
<form:errors path = "location" cssStyle="color:red"/>
</div>
<br>


<div>
<label for="">pin code</label>
<form:input path="pinCode"/>
<form:errors path = "pinCode" />
</div>
<br>

<div>
<input type ="submit" value="Register Camp">
</div>

</form:form>
</div>
</body>
</html>