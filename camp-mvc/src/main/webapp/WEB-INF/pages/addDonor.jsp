<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor-Registration</title>
</head>
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
<body>

<h1 style="text-align: center;">Registration Form</h1>
<hr>
<br>

<div>
<form:form action="/addDonor" modelAttribute="donor" method="post">

<div>
<label for="">DonorId</label>
<form:input path="id"/>
<form:errors path = "id" />
</div>
<br>


<div>
<label for="">DonorName</label>
<form:input path="name"/>
<form:errors path = "name" />
</div>
<br>


<div>
<label for="">DonorBlood Group</label>
<form:input path="bloodGroup"/>
<form:errors path = "bloodGroup" />
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
<label for="">lastDonation</label>
<form:input type="date" path="previousDonation"/>
<form:errors path = "previousDonation" />
</div>
<br>


<div>
<label for="">pin code</label>
<form:input path="pinCode"/>
<form:errors path = "pinCode" />
</div>
<br>

<div>
<input type ="submit" value="Register">
</div>

</form:form>
</div>

</body>
</html>

