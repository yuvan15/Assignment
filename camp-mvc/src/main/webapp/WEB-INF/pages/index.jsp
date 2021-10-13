<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BLOOD CAMP</title>
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
<h1 style="text-align: center;">${majHeading}</h1>

<a href="/addDonor"><button class="btn-btn-primary">Register</button></a>

<a href="/getAllDonors"><button class="btn-btn-primary">Display All Donor's</button></a>

<a href="/getAllCamp"><button class="btn-btn-primary">Display All Camp's</button></a>

<hr>

<br>

<form action="/getBloodGroup" >
	<label for="">Search By Blood Group : </label>
	<input type="text" name="search">
	<input type="submit">
</form>
<br>

<form action="/getLocation" >
	<label for="">Search By Location : </label>
	<input type="text" name="location">
	<input type="submit">
</form>
<br>



<form action="/unregister" >
	<label for="">Un-Register : </label>
	<input type="text" name="value">
	<input type="submit">
</form>
<br>

<form action="/getCampLocation" >
	<label for="">Search By Camp Location : </label>
	<input type="text" name="location">
	<input type="submit">
</form>
<br>
<!--  
<form action="/update" >
	<label for="">update : </label>
	<input type="number" name="value">
	<input type="text" name="group">
	<input type="submit">
</form>
-->




<br>
<br>



<hr>
<h1 style="text-align:center">Update Donor Details</h1>

<form action="/updatedonor" >

	<!--<label for="">update : </label>  -->
	
	<label for="">Enter Donor's Id : </label>
	<input type="number" name="donorId"> 
	<br>
	<br>
	
	<label for="">Enter Donor's Name : </label>
	<input type="text" name="donorName">
	<br>
	<br>
	
	<label for="">Enter Donor's blood group : </label>
	<input type="text" name="bloodGroup">
	<br>
	<br>
	
	<label for="">Enter Donor's Location : </label>
	<input type="text" name="donorLocation">
	<br>
	<br>
	
	<label for="">Enter Phone Number : </label>
	<input type="number" name="num">
	<br>
	<br>
	
	<label for="">Enter Predonated date : </label>
	<input type="date" name="preDate">
	 <br>
	 <br>
	 
	<label for="">Enter pincode : </label>
	<input type="number" name="pinCode">
	<br>
	<br>
	
	<input type="submit" value="updateDonor">
</form>
<br>
<br>

<hr>
<h3 style="text-align: center"><i><b>Organization Usage Regarding Camp</b></i></h3>

<a href="/addCamp"><button class="btn-btn-primary">Register-Camp</button></a>

<p><i>To delete the planned camp enter campId in the delete camp</i> </p>
<br>
<form action="/unregisterCamp" >
	<label for="">Delete Camp : </label>
	<input type="text" name="value">
	<input type="submit">
</form>
<br>
<hr>


<form action="/updateCamp" >
	
	
	<label for="">Enter Updated-Camp Id : </label>
	<input type="number" name="id"> 
	<br>
	<br>
	
	<label for="">Enter Updated-Camp pinCode : </label>
	<input type="text" name="pin">
	<br>
	<br>
	
	<label for="">Enter Updated-Camp location : </label>
	<input type="text" name="location">
	<br>
	<br>
	
	<label for="">Enter Updated-Camp date : </label>
	<input type="date" name="date">
	<br>
	<br>
	
	<label for="">Enter Camp PhoneNumber : </label>
	<input type="number" name="num">
	<br>
	<br>
	
	<input type="submit" value="update-campDetails">
</form>

</body>
</html>